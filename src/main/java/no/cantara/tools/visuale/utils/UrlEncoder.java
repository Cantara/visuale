package no.cantara.tools.visuale.utils;

import org.slf4j.Logger;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import static org.slf4j.LoggerFactory.getLogger;

public class UrlEncoder {
    private static final Logger log = getLogger(UrlEncoder.class);

    public static String urlEncode(String value) {
        String encoded = null;
        try {
            encoded = URLEncoder.encode(value, "UTF-8");
            encoded = encoded.replace("+", "%20");
        } catch (UnsupportedEncodingException e) {
            //should not happen as UTF-8 is valid
            log.warn("Unsupported encoding. {}", value);
        }
        return encoded;
    }
}
