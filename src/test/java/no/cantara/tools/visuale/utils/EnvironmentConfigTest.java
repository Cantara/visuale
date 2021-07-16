package no.cantara.tools.visuale.utils;

import no.cantara.config.ApplicationProperties;
import no.cantara.config.testsupport.ApplicationPropertiesTestHelper;
import org.junit.jupiter.api.Test;

class EnvironmentConfigTest {

    static {
        ApplicationPropertiesTestHelper.enableMutableSingleton();
        ApplicationProperties.builder().testDefaults().buildAndSetStaticSingleton();
    }

    @Test
    public void testParseJsonEnvironment() {
        EnvironmentConfig environmentConfig = new EnvironmentConfig();

        System.out.println(environmentConfig);
    }
}