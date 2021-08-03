package no.cantara.tools.visuale.notifications;

import com.slack.api.Slack;
import com.slack.api.methods.MethodsClient;
import com.slack.api.methods.SlackApiException;
import com.slack.api.methods.request.chat.ChatPostMessageRequest;
import com.slack.api.methods.response.chat.ChatPostMessageResponse;
import no.cantara.config.ApplicationProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.function.Supplier;

public class SlackNotificationClient {

    public static final Logger logger = LoggerFactory.getLogger(SlackNotificationClient.class);

    public static final String SLACK_ALERT_EMOJI = ":no_entry:";
    public static final String SLACK_WARNING_EMOJI = ":warning:";
    public static final String SLACK_REVIVED_EMOJI = ":green_heart:";

    private static final String SLACK_ALERTING_ENABLED_KEY = "slack_alerting_enabled";
    private static final String SLACK_TOKEN_KEY = "slack_token";
    private static final String SLACK_ALARM_CHANNEL_KEY = "slack_alarm_channel";
    private static final String SLACK_WARNING_CHANNEL_KEY = "slack_warning_channel";

    private final boolean alertingIsEnabled;

    private final String slackToken;
    private final Slack slack;
    private final String slackAlarmChannel;
    private final String slackWarningChannel;

    private final MethodsClient methodsClient;

    private final Supplier<String> environmentNameSupplier;

    public SlackNotificationClient(Supplier<String> environmentNameSupplier) {
        this.environmentNameSupplier = environmentNameSupplier;
        alertingIsEnabled = ApplicationProperties.getInstance().asBoolean(SLACK_ALERTING_ENABLED_KEY);
        slackToken = ApplicationProperties.getInstance().get(SLACK_TOKEN_KEY);
        slackAlarmChannel = ApplicationProperties.getInstance().get(SLACK_ALARM_CHANNEL_KEY);
        slackWarningChannel = ApplicationProperties.getInstance().get(SLACK_WARNING_CHANNEL_KEY);
        slack = Slack.getInstance();
        if (alertingIsEnabled) {
            methodsClient = slack.methods(slackToken);
        } else {
            methodsClient = null;
        }
    }

    void notifySlackAlarm(String service, String message) {
        if (alertingIsEnabled) {
            ChatPostMessageRequest request = ChatPostMessageRequest.builder()
                    .channel(slackAlarmChannel)
                    .text(SLACK_ALERT_EMOJI + environmentNameSupplier.get() + " - service:" + service + " is down. \n       - " + message)
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

    void clearSlackAlarm(String service, String timestampText) {
        if (alertingIsEnabled) {
            ChatPostMessageRequest request = ChatPostMessageRequest.builder()
                    .channel(slackAlarmChannel)
                    .text(SLACK_REVIVED_EMOJI + " " + environmentNameSupplier.get() + " - service: " + service + " is back in service. " + timestampText)
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

    void notifySlackWarning(String service, String message) {
        if (alertingIsEnabled) {
            ChatPostMessageRequest request = ChatPostMessageRequest.builder()
                    .channel(slackWarningChannel)
                    .text(SLACK_WARNING_EMOJI + " " + environmentNameSupplier.get() + " - service: " + service + " is having trouble. \n       - " + message)
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

    void clearSlackWarning(String service, String timestampText) {
        if (alertingIsEnabled) {
            ChatPostMessageRequest request = ChatPostMessageRequest.builder()
                    .channel(slackWarningChannel)
                    .text(SLACK_REVIVED_EMOJI + " " + environmentNameSupplier.get() + " - service: " + service + " is back in service. " + timestampText)
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
}
