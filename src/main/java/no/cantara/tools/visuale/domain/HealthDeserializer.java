package no.cantara.tools.visuale.domain;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class HealthDeserializer extends StdDeserializer<Health> {

    private static final long serialVersionUID = 1883547683050039861L;

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
        Map<String, String> jsonFlattenedMap = new HashMap<>();
        while (fieldNames.hasNext()) {
            String fieldName = fieldNames.next();
            JsonNode fieldvalueNode = jsonnode.get(fieldName);
            Iterator<String> subFieldNames = fieldvalueNode.fieldNames();
            while (subFieldNames.hasNext()) {
                String subfieldName = fieldNames.next();
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
        String statusValue = jsonFlattenedMap.get("status");
        if (statusValue == null || statusValue.length() < 1) {
            statusValue = "";
        }

        if ("true".equalsIgnoreCase(statusValue.toLowerCase())) {
            statusValue = "OK";
        }
        String nowValue = jsonFlattenedMap.get("now");
        String ipValue = jsonFlattenedMap.get("ip");
        String versionValue = jsonFlattenedMap.get("version");
        String runningSinceValue = jsonFlattenedMap.get("running since");
        String nameValue = jsonFlattenedMap.get("name");

        if (ipValue == null || ipValue.length() < 1 && versionValue.length() > 30) {
            int beginindex = 1 + versionValue.lastIndexOf("-");
            int endindex = beginindex + 17;
            if (endindex > versionValue.length()) {
                endindex = versionValue.length();
            }
            if (beginindex > 0) {
                ipValue = versionValue.substring(beginindex, endindex).trim();
            }

        }
        if (nameValue == null || nameValue.length() < 1 && versionValue.length() > 30) {
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

        Health customSerializedhealth = new Health().withStatus(statusValue).withName(nameValue)
                .withIp(ipValue).withVersion(versionValue).withNow(nowValue)
                .withRunningSince(runningSinceValue);
        return customSerializedhealth;
    }
}

