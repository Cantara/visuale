package no.cantara.tools.visuale.domain;

import com.fasterxml.jackson.core.json.JsonReadFeature;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Instant;
import java.util.Arrays;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HealthMapper {

    private static final Logger log = LoggerFactory.getLogger(HealthMapper.class);
    public static ObjectMapper mapper = new ObjectMapper().configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
            .configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false)
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
            .enable(JsonReadFeature.ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER.mappedFeature())
            .enable(JsonReadFeature.ALLOW_UNESCAPED_CONTROL_CHARS.mappedFeature())
            .findAndRegisterModules();
    ;

    private static boolean tryCustomDeserializer = true;

    public static Health fromRealWorldJson(String json) {
        if (json == null || json.length() < 1) {
            return new Health().withStatus("DOWN");
        }
        json = json.replaceAll("\\p{Cc}", "");

        Health health = new Health();
        if (!tryCustomDeserializer) {
            try {
                health = mapper.readValue(json, Health.class);
                health.setOriginalHealth(json);

            } catch (Exception e) {
                log.error("Unable to jackson deserialize json.  json:{}  exception:{}", json, Arrays.asList(e.getStackTrace()));
            }
        }


        if (tryCustomDeserializer) {
            try {
                ObjectMapper mycustommapper = new ObjectMapper().configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
                        .configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false)
                        .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                        //.enable(JsonReadFeature.ALLOW_UNESCAPED_CONTROL_CHARS.mappedFeature())
                        .enable(JsonReadFeature.ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER.mappedFeature())
                        .findAndRegisterModules();//.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
                SimpleModule module = new SimpleModule();
                module.addDeserializer(Health.class, new HealthDeserializer());
                mycustommapper.registerModule(module);
                Health myHealth = mycustommapper.readValue(json, Health.class);
                myHealth.setOriginalHealth(json);
                myHealth.setReceivedNow(Instant.now().toString());
                return myHealth;
            } catch (Exception e) {
                log.error("Unable to custom deserialize json.  json:{}  exception:{}", json, Arrays.asList(e.getStackTrace()));
            }
        }

        return health;
    }

    public static String extractIpv4Address(String source) {
        if (source == null) {
            return "0.0.0.0";
        }
        String postfix = "";
        if (source.toLowerCase(Locale.ROOT).endsWith("-xff")) {
            postfix = "xff";
        }
        String IPADDRESS_PATTERN = "(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)";
        Pattern pattern = Pattern.compile(IPADDRESS_PATTERN);
        Matcher matcher = pattern.matcher(source);
        if (matcher.find()) {
            if (postfix.length() > 1) {
                return matcher.group() + "-" + postfix;
            } else {
                return matcher.group();
            }
        } else {
            return "0.0.0.0";
        }
    }
}
