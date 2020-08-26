package no.cantara.tools.visuale.domain;

import com.fasterxml.jackson.core.json.JsonReadFeature;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class HealthTest {

    public static ObjectMapper mapper = new ObjectMapper().configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
            .configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false)
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
            .enable(JsonReadFeature.ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER.mappedFeature())
            .findAndRegisterModules();//.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);

    @Test
    public void testSerializeRealWorldHealth() throws Exception {
        Health health = mapper.readValue(quadimhealth, Health.class);

        assertTrue("true".equalsIgnoreCase(health.getStatus()));

        health = mapper.readValue(whydahHealth, Health.class);

        assertTrue("OK".equalsIgnoreCase(health.getStatus()));
    }


    String quadimhealth = "{\n" +
            "  \"Status\": \"true\"," +
            "  \"Version\": \"0.62.38-SNAPSHOT [Quadim CV Backend API - 172.31.33.86  fe80:0:0:0\n" +
            ":473:a6ff:feb8:2e76%eth0  172.31.33.86  0:0:0:0:0:0:0:1%lo  127.0.0.1]\",\n" +
            "  \"IndexSizes\": \"OverlordIndex:5 - OverlordProfileIndex:9 - JsonResumeIndex:0 - \n" +
            "SkillIndex:7 - MeasurementIndex:4\",\n" +
            "  \"Database Backend\": \"jdbc:h2:mem:overlordbase\",\n" +
            "  \"DatabaseSizes\": \"Overlords: 0 - OverlordProfileMappingSpecificationEntity: 0 \n" +
            "- SkillEntity: 4 - MeasurementEntity: 4 - FileStore files: 1 - AcquitisionProces\n" +
            "sEntity: 1 - Companies: 4 - Users: 1\",\n" +
            "  \"now\": \"2020-03-28T20:21:44.983Z\",\n" +
            "  \"running since\": \"2020-03-26T18:03:04.737Z\"\n" +
            "\n" +
            "}\n";

    String whydahHealth = "{\n" +
            "  \"Status\": \"OK\",\n" +
            "  \"Version\": \"2.5.36-SNAPSHOT [Whydah-SecurityTokenService - 172.31.48.218  fe80:0:0:0:1064:c3ff:fe70:b12e%eth0  172.31.48.218  0:0:0:0:0:0:0:1%lo  127.0.0.1]\",\n" +
            "  \"DEFCON\": \"DEFCON5\",\n" +
            "  \"max application session time (s)\": \"120\",\n" +
            "  \"max user session extension time (s)\": \"15552000\",\n" +
            "  \"ClusterSize\": \"1\",\n" +
            "  \"UserLastSeenMapSize\": \"8\",\n" +
            "  \"UserPinMapSize\": \"3\",\n" +
            "  \"AuthenticatedUserTokenMapSize\": \"560\",\n" +
            "  \"AuthenticatedApplicationRepositoryMapSize\": \"762\",\n" +
            "  \"AuthenticatedApplicationKeyMapSize\": \"762\",\n" +
            "  \"ConfiguredApplications\":  \"51\",\n" +
            "  \"ActiveApplications\": \"{Whydah-Jenkins[9999]=754,\n" +
            "                           Whydah-OAuth2Service-1[402222]=1,\n" +
            "                           Whydah-CRMService-1[2311]=1,\n" +
            "                           Whydah-UserIdentityBackend[2210]=1,\n" +
            "                           Whydah-SecurityTokenService[2211]=1,\n" +
            "                           Whydah-SSOLoginWebApp-1[2215]=1,\n" +
            "                           Whydah-UserAdminService-1[2212]=1,\n" +
            "                           Whydah-UserAdminWebApp-1[2219]=1,\n" +
            "                           Whydah-CRMService[2311]=1}\",\n" +
            "  \"ThreatSignalMapSize\": \"58\",\n" +
            "  \"now\": \"2020-03-28T20:32:00.696Z\",\n" +
            "  \"running since\": \"2020-03-28T01:02:11.974Z\"" +
            "} ";
}