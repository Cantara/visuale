package no.cantara.tools.visuale.notifications;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Instant;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Supplier;

/**
 * This instance
 */
public class NotificationService {

    public static final Logger logger = LoggerFactory.getLogger(NotificationService.class);
    public static ObjectMapper mapper = new ObjectMapper().configure(com.fasterxml.jackson.core.JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

    private final String alarmFilename = "./logs/service-notification-alarms.log";
    private final String warningFilename = "./logs/service-notification-warnings.log";
    private final String notificationStateFilename = "./logs/service-notification-mapname.json";

    public final Map<String, String> warningMap = new ConcurrentHashMap();
    public final Map<String, String> alarmMap = new ConcurrentHashMap<>();
    private boolean initialBootWarning = true;
    private boolean initialBootAlarm = true;

    private boolean loadedStateFromFile = false;

    private final SlackNotificationClient notificationClient;

    public NotificationService(Supplier<String> environmentNameSupplier) {
//       sendAlarm("test", "atull");
//        sendWarning("test", "wtull");
//        clearService("test");

        notificationClient = new SlackNotificationClient(environmentNameSupplier);
    }

    public boolean sendWarning(String service, String warningMessage) {
        if (!loadedStateFromFile) {
            restoreNotificationStateMaps();
            loadedStateFromFile = true;
        }
        if (warningMap.get(service) == null || !warningMessage.equalsIgnoreCase(warningMap.get(service))) {
            String timestampText = " - Timestamp: " + Instant.now().toString();
            warningMap.put(service, warningMessage);
            warningMessage = warningMessage + timestampText;
            appendWarningToFile(service, warningMessage, false);
            notificationClient.notifySlackWarning(service, warningMessage);
            // Check if we are recovering form an alarm situation, if so we clear the alarm
            if (alarmMap.get(service) != null) {
                notificationClient.clearSlackAlarm(service, timestampText);
            }
            storeNotificationStateMaps();
        }
        return true;
    }

    public boolean sendAlarm(String service, String alarmMessage) {
        if (!loadedStateFromFile) {
            restoreNotificationStateMaps();
            loadedStateFromFile = true;
        }
        if (alarmMap.get(service) == null | !alarmMessage.equalsIgnoreCase(alarmMap.get(service))) {
            String timestampText = " - Timestamp: " + Instant.now().toString();
            alarmMap.put(service, alarmMessage);
            alarmMessage = alarmMessage + timestampText;
            appendAlarmToFile(service, alarmMessage, false);
            notificationClient.notifySlackAlarm(service, alarmMessage);
            storeNotificationStateMaps();
        }
        return true;
    }

    public boolean clearService(String service) {
        String timestampText = " - Timestamp: " + Instant.now().toString();
        if (alarmMap.get(service) != null) {
            alarmMap.remove(service);
            appendAlarmToFile(service, "", true);
            notificationClient.clearSlackAlarm(service, timestampText);
        }
        if (warningMap.get(service) != null) {
            warningMap.remove(service);
            appendWarningToFile(service, "", true);
            notificationClient.clearSlackWarning(service, timestampText);
        }
        return true;
    }

    private void appendAlarmToFile(String service, String amessage, boolean cleared) {
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

    private void appendWarningToFile(String service, String mwessage, boolean cleared) {
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

    private void storeNotificationStateMaps() {
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

    private boolean restoreNotificationStateMaps() {
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
                warningMap.clear();
                warningMap.putAll(mapper.readValue(content, Map.class));
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
                alarmMap.clear();
                alarmMap.putAll(mapper.readValue(content, Map.class));
            }
        } catch (Exception e) {
            logger.error("Unable to restore alarm state", e);

        }
        return true;
    }

}
