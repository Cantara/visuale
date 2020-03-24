package no.cantara.tools.visuale.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class UrlEncoderTest {

    @Test
    void urlEncodeTest() {
        String value = "/ENTRA-Test/En flow";
        String expected = "%2FENTRA-Test%2FEn%20flow";
        Assertions.assertEquals(expected, UrlEncoder.urlEncode(value));
    }
}