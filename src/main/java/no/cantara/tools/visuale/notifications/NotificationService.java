package no.cantara.tools.visuale.notifications;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.slack.api.Slack;
import com.slack.api.methods.MethodsClient;
import com.slack.api.methods.SlackApiException;
import com.slack.api.methods.request.chat.ChatPostMessageRequest;
import com.slack.api.methods.response.chat.ChatPostMessageResponse;
import no.cantara.tools.visuale.status.StatusService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Instant;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static no.cantara.config.ServiceConfig.getProperty;

public class NotificationService {

    public static final Logger logger = LoggerFactory.getLogger(NotificationService.class);
    public static ObjectMapper mapper = new ObjectMapper().configure(com.fasterxml.jackson.core.JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

    private static final String alarmFilename = "./logs/service-notification-alarms.log";
    private static final String warningFilename = "./logs/service-notification-warnings.log";
    private static final String notificationStateFilename = "./logs/service-notification-mapname.json";

    public static Map warningMap = new ConcurrentHashMap();
    public static Map alarmMap = new ConcurrentHashMap<>();
    private static boolean initialBootWarning = true;
    private static boolean initialBootAlarm = true;

    private static boolean loadedStateFromFile = false;
    public static final String SLACK_ALERT_EMOJI = ":no_entry:";
    public static final String SLACK_WARNING_EMOJI = ":warning:";
    public static final String SLACK_REVIVED_EMOJI = ":green_heart:";
    private static final String SLACK_ALERTING_ENABLED_KEY = "slack_alerting_enabled";
    private static final String SLACK_TOKEN_KEY = "slack_token";
    private static final String SLACK_ALARM_CHANNEL_KEY = "slack_alarm_channel";
    private static final String SLACK_WARNING_CHANNEL_KEY = "slack_warning_channel";
    private static final boolean alertingIsEnabled;
    private static final String slackToken;
    private static final Slack slack;
    private static final String slackAlarmChannel;
    private static final String slackWarningChannel;
    private static MethodsClient methodsClient = null;

    static {
        String slackAlertingEnabled = getProperty(SLACK_ALERTING_ENABLED_KEY);
        alertingIsEnabled = Boolean.valueOf(slackAlertingEnabled);
        slackToken = getProperty(SLACK_TOKEN_KEY);
        slackAlarmChannel = getProperty(SLACK_ALARM_CHANNEL_KEY);
        slackWarningChannel = getProperty(SLACK_WARNING_CHANNEL_KEY);
        slack = Slack.getInstance();
        setupClient();
//       sendAlarm("test", "atull");
//        sendWarning("test", "wtull");
//        clearService("test");

    }

    public static boolean sendWarning(String service, String warningMessage) {
        if (!loadedStateFromFile) {
            restoreNotificationStateMaps();
            loadedStateFromFile = true;
        }
        if (warningMap.get(service) == null) {
            warningMap.put(service, warningMessage);
            appendWarningToFile(service, warningMessage, false);
            notifySlackWarning(service, warningMessage);
            storeNotificationStateMaps();
        }
        return true;
    }

    public static boolean sendAlarm(String service, String alarmMessage) {
        if (!loadedStateFromFile) {
            restoreNotificationStateMaps();
            loadedStateFromFile = true;
        }
        if (alarmMap.get(service) == null) {
            alarmMap.put(service, alarmMessage);
            appendAlarmToFile(service, alarmMessage, false);
            notifySlackAlarm(service, alarmMessage);
            storeNotificationStateMaps();
        }
        return true;
    }

    public static boolean clearService(String service) {
        if (alarmMap.get(service) != null) {
            alarmMap.remove(service);
            appendAlarmToFile(service, "", true);
            clearSlackAlarm(service);
        }
        if (warningMap.get(service) != null) {
            warningMap.remove(service);
            appendWarningToFile(service, "", true);
            clearSlackWarning(service);
        }
        return true;
    }

    private static synchronized void appendAlarmToFile(String service, String amessage, boolean cleared) {
        try {
            FileWriter fileWriter;
            if (initialBootAlarm && !cleared) {
                initialBootAlarm = false;
                fileWriter = new FileWriter(alarmFilename, false);
            } else {
                fileWriter = new FileWriter(alarmFilename, true);
            }
            PrintWriter printWriter = new PrintWriter(fileWriter, true);
            if (!cleared) {
                printWriter.println("Alarm for " + service);
                printWriter.println("    " + Instant.now().toString() + " - " + amessage);
            } else {
                printWriter.println("Cleared Alarm for " + service + " - time: " + Instant.now().toString());
            }
            printWriter.flush();
        } catch (Exception e) {
            logger.error("Unable to send and persist alarm", e);
        }
    }

    private static synchronized void appendWarningToFile(String service, String mwessage, boolean cleared) {
        try {
            FileWriter fileWriter;
            if (initialBootWarning && !cleared) {
                initialBootWarning = false;
                fileWriter = new FileWriter(warningFilename, false);
            } else {
                fileWriter = new FileWriter(warningFilename, true);
            }
            PrintWriter printWriter = new PrintWriter(fileWriter, true);
            if (!cleared) {
                printWriter.println("Warning for " + service);
                printWriter.println("    " + Instant.now().toString() + " - " + mwessage);
            } else {
                printWriter.println("Cleared Warning for " + service + "  - time: " + Instant.now().toString());
            }

            printWriter.close();
        } catch (Exception e) {
            logger.error("Unable to send and persist warning", e);
        }
    }

    private synchronized static void storeNotificationStateMaps() {
        if (warningMap.size() > 0) {
            String warningMapFilename = notificationStateFilename.replace("mapname", "warning");
            try {
                FileWriter fileWriter = new FileWriter(warningMapFilename, false);
                PrintWriter printWriter = new PrintWriter(fileWriter, true);
                printWriter.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(warningMap));

                printWriter.close();
            } catch (Exception e) {
                logger.error("Unable to send and persist warning state", e);
            }
        }
        if (alarmMap.size() > 0) {
            String alarmMapFilename = notificationStateFilename.replace("mapname", "alarm");
            try {
                FileWriter fileWriter = new FileWriter(alarmMapFilename, false);
                PrintWriter printWriter = new PrintWriter(fileWriter, true);
                printWriter.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(alarmMap));
                printWriter.close();
            } catch (Exception e) {
                logger.error("Unable to send and persist alarm state", e);
            }
        }
    }

    private static boolean restoreNotificationStateMaps() {
        if (loadedStateFromFile) {
            return true;
        }
        loadedStateFromFile = true;
        String warningMapFileName = notificationStateFilename.replace("mapname", "warning");
        try {
            File file = new File(warningMapFileName);
            file.getParentFile().mkdirs();
            file.createNewFile();

            String content = new String(Files.readAllBytes(Paths.get(warningMapFileName)), StandardCharsets.UTF_8);
            if (content != null && content.length() > 4) {
                warningMap = mapper.readValue(content, Map.class);
            }
        } catch (Exception e) {
            logger.error("Unable to restore warning state", e);

        }
        String alarmMapFileName = notificationStateFilename.replace("mapname", "alarm");
        try {
            File file = new File(alarmMapFileName);
            file.getParentFile().mkdirs();
            file.createNewFile();
            String content = new String(Files.readAllBytes(Paths.get(alarmMapFileName)), StandardCharsets.UTF_8);
            if (content != null && content.length() > 4) {
                alarmMap = mapper.readValue(content, Map.class);
            }
        } catch (Exception e) {
            logger.error("Unable to restore alarm state", e);

        }
        return true;
    }

    public static void notifySlackAlarm(String service, String message) {
        if (alertingIsEnabled) {
            ChatPostMessageRequest request = ChatPostMessageRequest.builder()
                    .channel(slackAlarmChannel)
                    .text(SLACK_ALERT_EMOJI + StatusService.DASHBOARD_ENVIRONMENT_NAME + " - service:" + service + " is down. \n - " + message)
                    .build();

            try {
                ChatPostMessageResponse response = methodsClient.chatPostMessage(request);
                if (response != null && !response.isOk()) {
                    logger.warn("Failed to send message: {} to channel: {}. Response: {}", message, slackAlarmChannel, response);
                } else {
                    logger.trace("Slack Response: {}", response);
                }
            } catch (IOException e) {
                logger.trace("IOException when sending message: {} to channel {}. Reason: {}", message, slackAlarmChannel, e.getMessage());
            } catch (SlackApiException e) {
                logger.trace("SlackApiException when sending message: {} to channel {}. Reason: {}", message, slackAlarmChannel, e.getMessage());
            }
        }
    }

    public static void clearSlackAlarm(String service) {
        if (alertingIsEnabled) {
            ChatPostMessageRequest request = ChatPostMessageRequest.builder()
                    .channel(slackAlarmChannel)
                    .text(SLACK_REVIVED_EMOJI + " " + StatusService.DASHBOARD_ENVIRONMENT_NAME + " - service: " + service + " is back in service")
                    .build();

            try {
                ChatPostMessageResponse response = methodsClient.chatPostMessage(request);
                if (response != null && !response.isOk()) {
                    logger.warn("Failed to send message: {} to channel: {}. Response: {}", service, slackAlarmChannel, response);
                } else {
                    logger.trace("Slack Response: {}", response);
                }
            } catch (IOException e) {
                logger.trace("IOException when sending message: {} to channel {}. Reason: {}", service, slackAlarmChannel, e.getMessage());
            } catch (SlackApiException e) {
                logger.trace("SlackApiException when sending message: {} to channel {}. Reason: {}", service, slackAlarmChannel, e.getMessage());
            }
        }
    }

    public static void notifySlackWarning(String service, String message) {
        if (alertingIsEnabled) {
            ChatPostMessageRequest request = ChatPostMessageRequest.builder()
                    .channel(slackWarningChannel)
                    .text(SLACK_WARNING_EMOJI + " " + StatusService.DASHBOARD_ENVIRONMENT_NAME + " - service: " + service + " is down. \n - " + message)
                    .build();

            try {
                ChatPostMessageResponse response = methodsClient.chatPostMessage(request);
                if (response != null && !response.isOk()) {
                    logger.warn("Failed to send message: {} to channel: {}. Response: {}", message, slackWarningChannel, response);
                } else {
                    logger.trace("Slack Response: {}", response);
                }
            } catch (IOException e) {
                logger.trace("IOException when sending message: {} to channel {}. Reason: {}", message, slackWarningChannel, e.getMessage());
            } catch (SlackApiException e) {
                logger.trace("SlackApiException when sending message: {} to channel {}. Reason: {}", message, slackWarningChannel, e.getMessage());
            }
        }
    }

    public static void clearSlackWarning(String service) {
        if (alertingIsEnabled) {
            ChatPostMessageRequest request = ChatPostMessageRequest.builder()
                    .channel(slackWarningChannel)
                    .text(SLACK_REVIVED_EMOJI + " " + StatusService.DASHBOARD_ENVIRONMENT_NAME + " - service: " + service + " is back in service")
                    .build();

            try {
                ChatPostMessageResponse response = methodsClient.chatPostMessage(request);
                if (response != null && !response.isOk()) {
                    logger.warn("Failed to send message: {} to channel: {}. Response: {}", service, slackWarningChannel, response);
                } else {
                    logger.trace("Slack Response: {}", response);
                }
            } catch (IOException e) {
                logger.trace("IOException when sending message: {} to channel {}. Reason: {}", service, slackWarningChannel, e.getMessage());
            } catch (SlackApiException e) {
                logger.trace("SlackApiException when sending message: {} to channel {}. Reason: {}", service, slackWarningChannel, e.getMessage());
            }
        }
    }

    private static void setupClient() {
        if (alertingIsEnabled) {
            methodsClient = slack.methods(slackToken);
        }
    }
}
