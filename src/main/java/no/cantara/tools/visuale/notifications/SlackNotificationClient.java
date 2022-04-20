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
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.BiConsumer;
import java.util.function.Supplier;

public class SlackNotificationClient implements Runnable {

    public static final Logger logger = LoggerFactory.getLogger(SlackNotificationClient.class);

    public static final String SLACK_ALERT_EMOJI = ":no_entry:";
    public static final String SLACK_WARNING_EMOJI = ":warning:";
    public static final String SLACK_REVIVED_EMOJI = ":green_heart:";
    private static final boolean REPORT_INTO_TO_ALARM = false;

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

    private final Thread slackSenderThread;
    private final BlockingQueue<SlackMessageEvent> eventQueue = new LinkedBlockingQueue<>();
    private final AtomicBoolean shouldRun = new AtomicBoolean(true);

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
        slackSenderThread = new Thread(this, "slack-notification-client");
        slackSenderThread.start();
    }

    @Override
    public void run() {
        final int MIN_INTERVAL_BETWEEN_SENDS_MS = 500;
        long lastSent = 0;
        while (shouldRun.get()) {
            try {
                SlackMessageEvent event = eventQueue.poll(2, TimeUnit.SECONDS);

                if (event != null && event.slackSender != null) {

                    /*
                     * Throttle Slack sending by ensuring that there is at least MIN_INTERVAL_BETWEEN_SENDS_MS
                     * milliseconds between sends.
                     */
                    long now = System.currentTimeMillis();
                    long millisSinceLastSent = Math.max(0, now - lastSent); // avoid negative duration due to clock sync
                    if (millisSinceLastSent < MIN_INTERVAL_BETWEEN_SENDS_MS) {
                        Thread.sleep(MIN_INTERVAL_BETWEEN_SENDS_MS - millisSinceLastSent);
                    }

                    // take note of time before sending message for more accurate throttling
                    lastSent = System.currentTimeMillis();

                    // send message to slack
                    event.slackSender.accept(event.service, event.message);
                }

            } catch (Throwable t) {
                logger.error("", t);
            }
        }
        logger.info("Slack event-loop stopped");
    }

    private void queue(String service, String message, BiConsumer<String, String> consumer) {
        eventQueue.add(new SlackMessageEvent(service, message, consumer));
    }

    public void shutdown() {
        shouldRun.set(false);
        eventQueue.add(new SlackMessageEvent(null, null, null));
    }

    private static class SlackMessageEvent {
        final String service;
        final String message;
        final BiConsumer<String, String> slackSender;

        private SlackMessageEvent(String service, String message, BiConsumer<String, String> slackSender) {
            this.service = service;
            this.message = message;
            this.slackSender = slackSender;
        }
    }

    public void notifySlackAlarm(String service, String message) {
        queue(service, message, this::doNotifySlackAlarm);
    }

    public void notifySlackInfo(String service, String message) {
        queue(service, message, this::doNotifySlackInfo);
    }

    public void clearSlackAlarm(String service, String message) {
        queue(service, message, this::doClearSlackAlarm);
    }

    public void notifySlackWarning(String service, String message) {
        queue(service, message, this::doNotifySlackWarning);
    }

    public void clearSlackWarning(String service, String message) {
        queue(service, message, this::doClearSlackWarning);
    }


    private void doNotifySlackInfo(String service, String message) {
        if (REPORT_INTO_TO_ALARM) {
            if (alertingIsEnabled && !service.toLowerCase().contains("simulator")) {
                ChatPostMessageRequest request = ChatPostMessageRequest.builder()
                        .channel(slackAlarmChannel)
                        .text(":beer:" + environmentNameSupplier.get() + " - service:" + service + " \n       - " + message)
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

        // Also report to warning channel as this will help understanding rolling upgrades
        if (alertingIsEnabled && !service.toLowerCase().contains("simulator")) {
            ChatPostMessageRequest request = ChatPostMessageRequest.builder()
                    .channel(slackWarningChannel)
                    .text(":beer:" + environmentNameSupplier.get() + " - service:" + service + " \n       - " + message)
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

    private void doNotifySlackAlarm(String service, String message) {
        if (alertingIsEnabled && !service.toLowerCase().contains("simulator")) {
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

    private void doClearSlackAlarm(String service, String timestampText) {
        if (alertingIsEnabled && !service.toLowerCase().contains("simulator")) {
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

    private void doNotifySlackWarning(String service, String message) {
        if (alertingIsEnabled && !service.toLowerCase().contains("simulator")) {
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

    private void doClearSlackWarning(String service, String timestampText) {
        if (alertingIsEnabled && !service.toLowerCase().contains("simulator")) {
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
