package no.cantara.tools.visuale.domain;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class HealthMapper {

    private static final Logger log = LoggerFactory.getLogger(HealthMapper.class);
    public static ObjectMapper mapper = new ObjectMapper().configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);

    private static boolean tryCustomDeserializer = true;

    public static Health fromRealWorldJson(String json) {
        if (json == null || json.length() < 1) {
            return new Health().withStatus("DOWN");
        }

        Health health = new Health();
        try {
            health = mapper.readValue(json, Health.class);
        } catch (Exception e) {
            log.error("Unable to jackson deserialize json.  json:{}  exception:{}", json, Arrays.asList(e.getStackTrace()));
        }

        if (tryCustomDeserializer) {
            try {
                ObjectMapper mycustommapper = new ObjectMapper().configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
                SimpleModule module = new SimpleModule();
                module.addDeserializer(Health.class, new HealthDeserializer());
                mycustommapper.registerModule(module);
                Health myHealth = mycustommapper.readValue(json, Health.class);
                return myHealth;
            } catch (Exception e) {
                log.error("Unable to custom deserialize json.  json:{}  exception:{}", json, Arrays.asList(e.getStackTrace()));
            }
        }

        return health;
    }

}
