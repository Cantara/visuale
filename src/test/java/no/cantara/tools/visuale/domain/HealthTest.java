package no.cantara.tools.visuale.domain;

import com.fasterxml.jackson.core.json.JsonReadFeature;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class HealthTest {

    public static ObjectMapper mapper = new ObjectMapper().configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
            .configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false)
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
            .enable(JsonReadFeature.ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER.mappedFeature())
            .enable(JsonReadFeature.ALLOW_UNESCAPED_CONTROL_CHARS.mappedFeature())
            .enable(JsonReadFeature.ALLOW_NON_NUMERIC_NUMBERS.mappedFeature())
            .findAndRegisterModules();

    public static ObjectMapper mycustommapper = new ObjectMapper().configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
            .configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false)
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
            //.enable(JsonReadFeature.ALLOW_UNESCAPED_CONTROL_CHARS.mappedFeature())
            .enable(JsonReadFeature.ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER.mappedFeature())
            .findAndRegisterModules();//.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);


    @Test
    public void testSerializeRealWorldHealth() throws Exception {
        SimpleModule module = new SimpleModule();
        module.addDeserializer(Health.class, new HealthDeserializer());
        mycustommapper.registerModule(module);

        Health health = mapper.readValue(quadimhealth, Health.class);

        assertTrue("true".equalsIgnoreCase(health.getStatus()));

        health = mapper.readValue(whydahHealth, Health.class);

        assertTrue("OK".equalsIgnoreCase(health.getStatus()));

        health = mycustommapper.readValue(eventStoreHealth, Health.class);

        assertTrue("OK".equalsIgnoreCase(health.getStatus()));

        health = HealthMapper.fromRealWorldJson(analyticsHealth);

        assertTrue("OK".equalsIgnoreCase(health.getStatus()));

        health = HealthMapper.fromRealWorldJson(eventStoreHealth);

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

    String analyticsHealth = "{\n" +
            "  \"Status\": \"UP\",\n" +
            "  \"health-compute-time-ms\": \"0\",\n" +
            "  \"ip\": \"10.3.50.139\",\n" +
            "  \"ip-all\": \"10.3.50.139  127.0.0.1  0:0:0:0:0:0:0:1%lo\",\n" +
            "  \"jetty.server\": {\n" +
            "    \"details\": {\n" +
            "      \"connectors\": [\n" +
            "        {\n" +
            "          \"host\": null,\n" +
            "          \"idleTimeout\": -1,\n" +
            "          \"lifecycle\": \"running\",\n" +
            "          \"localPort\": 8280,\n" +
            "          \"name\": null,\n" +
            "          \"port\": 8280,\n" +
            "          \"protocols\": \"http/1.1, h2c\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"host\": null,\n" +
            "          \"idleTimeout\": -1,\n" +
            "          \"lifecycle\": \"running\",\n" +
            "          \"localPort\": 8243,\n" +
            "          \"name\": null,\n" +
            "          \"port\": 8243,\n" +
            "          \"protocols\": \"ssl, alpn, h2, http/1.1\"\n" +
            "        }\n" +
            "      ],\n" +
            "      \"lifecycle\": \"running\",\n" +
            "      \"threadpool\": {\n" +
            "        \"idleThreads\": 4,\n" +
            "        \"threads\": 10\n" +
            "      }\n" +
            "    },\n" +
            "    \"status\": \"UP\"\n" +
            "  },\n" +
            "  \"name\": \"analytics-vanilla\",\n" +
            "  \"now\": \"2023-05-04 09:28:1608Z\",\n" +
            "  \"running since\": \"2023-05-02 12:48:3286Z\",\n" +
            "  \"version\": \"0.18.13\"\n" +
            "}";

    String eventStoreHealth = "{\n" +
            "  \"status\": \"UP\",\n" +
            "  \"name\": \"eventstore\",\n" +
            "  \"version\": \"22.10\",\n" +
            "  \"ip\": \"10.3.50.161\",\n" +
            "  \"now\": \"2023-05-04 09:31:1715Z\",\n" +
            "  \"running_since\": \"2023-04-29 05:00:21\",\n" +
            "  \"nodesInCluster\": 3,\n" +
            "  \"gossip\": {\n" +
            "    \"members\": [\n" +
            "      {\n" +
            "        \"instanceId\": \"ff3896e8-d2e9-4313-8f04-70775df048d2\",\n" +
            "        \"timeStamp\": \"2023-05-04 09:31:17Z\",\n" +
            "        \"state\": \"Leader\",\n" +
            "        \"isAlive\": true,\n" +
            "        \"httpEndPointIp\": \"10.3.50.98\",\n" +
            "        \"httpEndPointPort\": 2113,\n" +
            "        \"isReadOnlyReplica\": false\n" +
            "      },\n" +
            "      {\n" +
            "        \"instanceId\": \"04f5f1c7-f2be-48f8-8ea5-f10047df8d87\",\n" +
            "        \"timeStamp\": \"2023-05-04 09:31:16Z\",\n" +
            "        \"state\": \"Follower\",\n" +
            "        \"isAlive\": true,\n" +
            "        \"httpEndPointIp\": \"10.3.50.22\",\n" +
            "        \"httpEndPointPort\": 2113,\n" +
            "        \"isReadOnlyReplica\": false\n" +
            "      },\n" +
            "      {\n" +
            "        \"instanceId\": \"faebe0ef-69dd-4597-b860-07160f5d8985\",\n" +
            "        \"timeStamp\": \"2023-05-04 09:31:17Z\",\n" +
            "        \"state\": \"Follower\",\n" +
            "        \"isAlive\": true,\n" +
            "        \"httpEndPointIp\": \"10.3.50.161\",\n" +
            "        \"httpEndPointPort\": 2113,\n" +
            "        \"isReadOnlyReplica\": false\n" +
            "      }\n" +
            "    ],\n" +
            "    \"serverIp\": \"10.3.50.161\",\n" +
            "    \"serverPort\": 2113\n" +
            "  }\n" +
            "}";
}