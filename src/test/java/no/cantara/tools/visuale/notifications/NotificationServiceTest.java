package no.cantara.tools.visuale.notifications;

import org.junit.jupiter.api.Test;

public class NotificationServiceTest {

    @Test
    public void testSendAlert() {
        NotificationService.sendAlarm("xtest-service", "alarm-test-message");


        NotificationService.sendWarning("xtest-service2", "warning-test-message");
        NotificationService.clearSlackAlarm("xtest-service");
        NotificationService.clearSlackAlarm("xtest-service2");
    }
}