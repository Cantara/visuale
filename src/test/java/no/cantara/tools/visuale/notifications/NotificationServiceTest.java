package no.cantara.tools.visuale.notifications;

import no.cantara.config.ApplicationProperties;
import no.cantara.config.testsupport.ApplicationPropertiesTestHelper;
import org.junit.jupiter.api.Test;

import java.util.UUID;

public class NotificationServiceTest {

    static {
        ApplicationPropertiesTestHelper.enableMutableSingleton();
        ApplicationProperties.builder().testDefaults().buildAndSetStaticSingleton();
    }

    String ref = UUID.randomUUID().toString();

    @Test
    public void testSendAlert() {
        NotificationService notificationService = new NotificationService(() -> "junit-test-environment");
        notificationService.sendAlarm("service-alarm-test-" + ref, "debug-alarm-test-message");


        notificationService.sendWarning("service-warning-test-" + ref, "debug-warning-test-message");
        notificationService.clearService("service-alarm-test-" + ref);
        notificationService.clearService("service-warning-test-" + ref);
    }
}