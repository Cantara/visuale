package no.cantara.tools.visuale.notifications;

import org.junit.jupiter.api.Test;

import java.util.UUID;

public class NotificationServiceTest {

    String ref = UUID.randomUUID().toString();

    @Test
    public void testSendAlert() {
        NotificationService.sendAlarm("service-alarm-test-" + ref, "debug-alarm-test-message");


        NotificationService.sendWarning("service-warning-test-" + ref, "debug-warning-test-message");
        NotificationService.clearService("service-alarm-test-" + ref);
        NotificationService.clearService("service-warning-test-" + ref);
    }
}