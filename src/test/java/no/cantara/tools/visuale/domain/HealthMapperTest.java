package no.cantara.tools.visuale.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class HealthMapperTest {

    ObjectMapper mapper = new ObjectMapper();

    @Test
    public void testHealthMapper() throws Exception {
        Health health = HealthMapper.fromRealWorldJson(quadimhealth);
        assertTrue("OK".equalsIgnoreCase(health.getStatus()));
        System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(health));

        health = HealthMapper.fromRealWorldJson(whydahHealth);
        assertTrue("OK".equalsIgnoreCase(health.getStatus()));
        System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(health));

        health = HealthMapper.fromRealWorldJson(whydahTest2);
        assertTrue("OK".equalsIgnoreCase(health.getStatus()));
        System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(health));

        health = HealthMapper.fromRealWorldJson(demoHealthString);
        assertTrue("N/A".equalsIgnoreCase(health.getStatus()));
        System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(health));

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

    String whydahTest2 = "{\n" +
            "  \"Status\": \"true\",\n" +
            "  \"Version\": \"2.5.38-SNAPSHOT [Whydah-SSOLoginWebApp-1 - 172.31.48.218  fe80:0:0:0:1064:c3ff:fe70:b12e%eth0  172.31.48.218  0:0:0:0:0:0:0:1%lo  127.0.0.1]\",\n" +
            "  \"DEFCON\": \"DEFCON5\",\n" +
            "  \"hasApplicationToken\": \"true\",\n" +
            "  \"hasValidApplicationToken\": \"true\",\n" +
            "  \"hasApplicationsMetadata\": \"false\",\n" +
            "  \"now\": \"2020-03-30T10:36:53.366Z\",\n" +
            "  \"running since\": \"2020-03-30T01:02:35.729Z\",\n" +
            "\n" +
            "  \"securitytokenservice_health\": \"https://whydahdev.cantara.no/tokenservice/health\" ,\n" +
            "  \"useradminservice_health\": \"https://whydahdev.cantara.no/useradminservice/health\" ,\n" +
            "  \"statisticsservice_health\": \"https://whydahdev.cantara.no/reporter/health\" ,\n" +
            "  \"crmservice_health\": \"https://whydahdev.cantara.no/crmservice/health\" \n" +
            "}";

    String demoHealthString = "{\n" +
            " \"version\":\"0.0.2-SNAPSHOT\",\n" +
            " \"name\":\"quadim-measurement-service\",\n" +
            " \"now\":\"2020-04-06T07:36:55.165575Z\",\n" +
            " \"ip\":\"172.31.41.32  fe80:0:0:0:4b6:58ff:fec9:c378%eth0  172.31.41.32  0:0:0:0:0:0:0:1%lo  127.0.0.1\",\n" +
            " \"running since\":\"2020-04-06T06:27:04.667815Z\",\n" +
            " \"Database Backend\":\"jdbc:h2:mem:testdb\",\n" +
            " \"Measurement count\":\"4\"}";
}