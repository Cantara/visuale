package no.cantara.tools.visuale.domain;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class HealthDeserializer extends StdDeserializer<Health> {

    private static final long serialVersionUID = 1883547683050039861L;
    private static final Logger log = LoggerFactory.getLogger(HealthDeserializer.class);

    public HealthDeserializer() {
        this(null);
    }

    public HealthDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public Health deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        JsonNode jsonnode = jp.getCodec().readTree(jp);
        Iterator<String> fieldNames = jsonnode.fieldNames();
        Map<String, String> jsonFlattenedMap = getFlattenedJsonMap(jsonnode, fieldNames);
        String statusValue = jsonFlattenedMap.remove("status");
        if (statusValue == null || statusValue.length() < 1) {
            statusValue = "";
        }

        if ("true".equalsIgnoreCase(statusValue.toLowerCase())) {
            statusValue = "OK";
        }
        if ("HEALTHY".equalsIgnoreCase(statusValue.toLowerCase())) {
            statusValue = "OK";
        }
        if ("OK".equalsIgnoreCase(statusValue.toLowerCase())) {
            statusValue = "OK";
        }
        if ("UP".equalsIgnoreCase(statusValue.toLowerCase())) {
            statusValue = "OK";
        }

        String nowValue = jsonFlattenedMap.remove("now");
        if ((nowValue == null || nowValue.length() < 1)) {
            nowValue = jsonFlattenedMap.remove("timestamp");
        }


        String ipValue = jsonFlattenedMap.remove("ip");
        String versionValue = jsonFlattenedMap.remove("version");
        String runningSinceValue = jsonFlattenedMap.remove("running since");
        if ((runningSinceValue == null || runningSinceValue.length() < 1)) {
            runningSinceValue = jsonFlattenedMap.remove("runningsince");
        }

        String nameValue = jsonFlattenedMap.remove("name");

        if ((ipValue == null || ipValue.length() < 1) && (versionValue != null && versionValue.length() > 30)) {
            int beginindex = 1 + versionValue.lastIndexOf("-");
            int endindex = beginindex + 17;
            if (endindex > versionValue.length()) {
                endindex = versionValue.length();
            }
            if (beginindex > 0) {
                ipValue = versionValue.substring(beginindex, endindex).trim();
            }

        }
        if ((nameValue == null || nameValue.length() < 1) && (versionValue != null && versionValue.length() > 30)) {
            int beginindex = 1 + versionValue.lastIndexOf("[");
            int endindex = beginindex + 30;
            if (endindex > versionValue.length()) {
                endindex = versionValue.length();
            }
            if (beginindex > 0) {
                nameValue = versionValue.substring(beginindex, endindex).trim();
            }

        }
        if (versionValue != null && versionValue.length() > 20) {
            if (versionValue.indexOf("[") > 10) {
                versionValue = versionValue.substring(0, versionValue.indexOf("[")).trim();
            } else if (versionValue.indexOf("(") > 10) {
                versionValue = versionValue.substring(0, versionValue.indexOf("(")).trim();
            } else {
                versionValue = versionValue.substring(0, 19);
            }
        }

        Map<String, String> additionalProperties = new HashMap<String, String>();
        for (String key : jsonFlattenedMap.keySet()) {
            additionalProperties.put(key, jsonFlattenedMap.get(key));
        }

        Health customSerializedhealth = new Health().withStatus(statusValue).withName(nameValue)
                .withIp(ipValue).withVersion(versionValue).withNow(nowValue)
                .withRunningSince(runningSinceValue)
                .withAdditionalProperties(additionalProperties);
        return customSerializedhealth;
    }

    private Map<String, String> getFlattenedJsonMap(JsonNode jsonnode, Iterator<String> fieldNames) {
        Map<String, String> jsonFlattenedMap = new HashMap<>();
        try {
            while (fieldNames.hasNext()) {
                String fieldName = fieldNames.next();
                JsonNode fieldvalueNode = jsonnode.get(fieldName);
                Iterator<String> subFieldNames = fieldvalueNode.fieldNames();
                while (subFieldNames.hasNext()) {
                    String subfieldName = subFieldNames.next();
                    JsonNode subfieldvalueNode = fieldvalueNode.get(fieldName);
                    if (fieldvalueNode.isTextual()) {
                        String subfieldValue = subfieldvalueNode.textValue();
                        String combinedkey = fieldName + ":" + subfieldName;
                        jsonFlattenedMap.put(combinedkey.toLowerCase(), subfieldValue);

                    }

                }
                if (fieldvalueNode.isTextual()) {
                    String fieldValue = fieldvalueNode.textValue();
                    jsonFlattenedMap.put(fieldName.toLowerCase(), fieldValue);
                }
            }
        } catch (Exception e) {
            log.warn("Unable to handle data as JSON", e);
        }

        return jsonFlattenedMap;
    }
}

