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
//        System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(health));

        health = HealthMapper.fromRealWorldJson(whydahHealth);
        assertTrue("OK".equalsIgnoreCase(health.getStatus()));
//        System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(health));

        health = HealthMapper.fromRealWorldJson(whydahTest2);
        assertTrue("OK".equalsIgnoreCase(health.getStatus()));
//        System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(health));

        health = HealthMapper.fromRealWorldJson(mapi);
        assertTrue("OK".equalsIgnoreCase(health.getStatus()));
//        System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(health));

        health = HealthMapper.fromRealWorldJson(doorhealth);
        assertTrue("OK".equalsIgnoreCase(health.getStatus()));
//        System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(health));

        health = HealthMapper.fromRealWorldJson(old_school_health);
        assertTrue("OK".equalsIgnoreCase(health.getStatus()));

        health = HealthMapper.fromRealWorldJson(uawa);
        assertTrue("OK".equalsIgnoreCase(health.getStatus()));
//        System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(health));

        health = HealthMapper.fromRealWorldJson(crm);
        assertTrue("OK".equalsIgnoreCase(health.getStatus()));
//        System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(health));

        health = HealthMapper.fromRealWorldJson(whydahSTS3);
        assertTrue("OK".equalsIgnoreCase(health.getStatus()));
        System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(health));

        health = HealthMapper.fromRealWorldJson(failing_in_the_wild_json_health);
        assertTrue("OK".equalsIgnoreCase(health.getStatus()));
        System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(health));

        health = HealthMapper.fromRealWorldJson(badOauthHeathJson);
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

    String whydahSTS3 = "{\n" +
            "  \"Status\": \"OK\",\n" +
            "  \"Version\": \"2.5.38-SNAPSHOT [Whydah-SecurityTokenService ]\",\n" +
            "  \"DEFCON\": \"DEFCON5\",\n" +
            "  \"max application session time (s)\": \"120\",\n" +
            "  \"max user session extension time (s)\": \"15552000\",\n" +
            "  \"ClusterSize\": \"1\",\n" +
            "  \"UserLastSeenMapSize\": \"0\",\n" +
            "  \"UserPinMapSize\": \"0\",\n" +
            "  \"AuthenticatedUserTokenMapSize\": \"0\",\n" +
            "  \"AuthenticatedApplicationRepositoryMapSize\": \"7\",\n" +
            "  \"AuthenticatedApplicationKeyMapSize\": \"7\",\n" +
            "  \"ConfiguredApplications\":  \"15\",\n" +
            "  \"ActiveApplications\": {\n" +
            "  \"Whydah-CRMService-1[2311]\" : 2,\n" +
            "  \"Whydah-UserIdentityBackend[2210]\" : 1,\n" +
            "  \"Whydah-SecurityTokenService[2211]\" : 1,\n" +
            "  \"Whydah-SSOLoginWebApp-1[2215]\" : 1,\n" +
            "  \"Whydah-UserAdminService-1[2212]\" : 1,\n" +
            "  \"Whydah-UserAdminWebApp-1[2219]\" : 1\n" +
            "},\n" +
            "  \"ThreatSignalMapSize\": \"20\",\n" +
            "  \"now\": \"2020-04-23T05:21:25.248Z\",\n" +
            "  \"running since\": \"2020-04-23T01:02:08.668Z\",  \n" +
            "\n" +
            "\"threat_signals\" :   {\n" +
            "    \"2020-04-23T04:52:37.371Z\" : {\n" +
            "      \"source\" : \"\",\n" +
            "      \"signal-emitter\" : \"**6df*4e62fe*88e2191d0*0e96*0**1 - 2212:Whyd*h-UserAdminServi*e-1\",\n" +
            "      \"instant\" : \"2020-04-23T04:52:37.324Z\",\n" +
            "      \"signal-severity\" : \"LOW\",\n" +
            "      \"text\" : \"Application authentication failure\",\n" +
            "      \"usertokenid\" : \"N/A\",\n" +
            "      \"EMITTER IP\" : \"172.31.44.117  fe80:0:0:0:426:baff:fe61:cea4%eth0  172.31.44.117  0:0:0:0:0:0:0:1%lo  127.0.0.1\",\n" +
            "      \"IMMEDIATE THREAT\" : true,\n" +
            "      \"appName\" : \"NULL\",\n" +
            "      \"appId\" : \"2311\",\n" +
            "      \"DEFCON\" : \"DEFCON5\",\n" +
            "      \"apptokenid\" : \"38*6*1*04d02dffd0937*795ee91936d\"\n" +
            "    },\n" +
            "    \"2020-04-23T04:52:37.394Z\" : {\n" +
            "      \"source\" : \"\",\n" +
            "      \"signal-emitter\" : \"**6df*4e62fe*88e2191d0*0e96*0**1 - 2212:Whyd*h-UserAdminServi*e-1\",\n" +
            "      \"instant\" : \"2020-04-23T04:52:37.324Z\",\n" +
            "      \"signal-severity\" : \"LOW\",\n" +
            "      \"text\" : \"Application authentication failure\",\n" +
            "      \"usertokenid\" : \"N/A\",\n" +
            "      \"EMITTER IP\" : \"172.31.44.117  fe80:0:0:0:426:baff:fe61:cea4%eth0  172.31.44.117  0:0:0:0:0:0:0:1%lo  127.0.0.1\",\n" +
            "      \"IMMEDIATE THREAT\" : true,\n" +
            "      \"appName\" : \"NULL\",\n" +
            "      \"appId\" : \"2311\",\n" +
            "      \"DEFCON\" : \"DEFCON5\",\n" +
            "      \"apptokenid\" : \"38*6*1*04d02dffd0937*795ee91936d\"\n" +
            "    },\n" +
            "    \"2020-04-23T04:53:33.837Z\" : {\n" +
            "      \"source\" : \"\",\n" +
            "      \"signal-emitter\" : \"**6df*4e62fe*88e2191d0*0e96*0**1 - 2212:Whyd*h-UserAdminServi*e-1\",\n" +
            "      \"instant\" : \"2020-04-23T04:53:33.819Z\",\n" +
            "      \"signal-severity\" : \"LOW\",\n" +
            "      \"text\" : \"Application authentication failure\",\n" +
            "      \"usertokenid\" : \"N/A\",\n" +
            "      \"EMITTER IP\" : \"172.31.44.117  fe80:0:0:0:426:baff:fe61:cea4%eth0  172.31.44.117  0:0:0:0:0:0:0:1%lo  127.0.0.1\",\n" +
            "      \"IMMEDIATE THREAT\" : true,\n" +
            "      \"appName\" : \"NULL\",\n" +
            "      \"appId\" : \"2311\",\n" +
            "      \"DEFCON\" : \"DEFCON5\",\n" +
            "      \"apptokenid\" : \"66959e*e2923*f5f1*0952299396*4d3\"\n" +
            "    },\n" +
            "    \"2020-04-23T04:53:33.860Z\" : {\n" +
            "      \"source\" : \"\",\n" +
            "      \"signal-emitter\" : \"**6df*4e62fe*88e2191d0*0e96*0**1 - 2212:Whyd*h-UserAdminServi*e-1\",\n" +
            "      \"instant\" : \"2020-04-23T04:53:33.836Z\",\n" +
            "      \"signal-severity\" : \"LOW\",\n" +
            "      \"text\" : \"Application authentication failure\",\n" +
            "      \"usertokenid\" : \"N/A\",\n" +
            "      \"EMITTER IP\" : \"172.31.44.117  fe80:0:0:0:426:baff:fe61:cea4%eth0  172.31.44.117  0:0:0:0:0:0:0:1%lo  127.0.0.1\",\n" +
            "      \"IMMEDIATE THREAT\" : true,\n" +
            "      \"appName\" : \"NULL\",\n" +
            "      \"appId\" : \"2311\",\n" +
            "      \"DEFCON\" : \"DEFCON5\",\n" +
            "      \"apptokenid\" : \"66959e*e2923*f5f1*0952299396*4d3\"\n" +
            "    },\n" +
            "    \"2020-04-23T04:55:02.440Z\" : {\n" +
            "      \"source\" : \"\",\n" +
            "      \"signal-emitter\" : \"**6df*4e62fe*88e2191d0*0e96*0**1 - 2212:Whyd*h-UserAdminServi*e-1\",\n" +
            "      \"instant\" : \"2020-04-23T04:55:02.426Z\",\n" +
            "      \"signal-severity\" : \"LOW\",\n" +
            "      \"text\" : \"Application authentication failure\",\n" +
            "      \"usertokenid\" : \"N/A\",\n" +
            "      \"EMITTER IP\" : \"172.31.44.117  fe80:0:0:0:426:baff:fe61:cea4%eth0  172.31.44.117  0:0:0:0:0:0:0:1%lo  127.0.0.1\",\n" +
            "      \"IMMEDIATE THREAT\" : true,\n" +
            "      \"appName\" : \"NULL\",\n" +
            "      \"appId\" : \"2311\",\n" +
            "      \"DEFCON\" : \"DEFCON5\",\n" +
            "      \"apptokenid\" : \"6e9d24**4*69d4*889230e5*7e20**45\"\n" +
            "    },\n" +
            "    \"2020-04-23T04:55:02.470Z\" : {\n" +
            "      \"source\" : \"\",\n" +
            "      \"signal-emitter\" : \"**6df*4e62fe*88e2191d0*0e96*0**1 - 2212:Whyd*h-UserAdminServi*e-1\",\n" +
            "      \"instant\" : \"2020-04-23T04:55:02.459Z\",\n" +
            "      \"signal-severity\" : \"LOW\",\n" +
            "      \"text\" : \"Application authentication failure\",\n" +
            "      \"usertokenid\" : \"N/A\",\n" +
            "      \"EMITTER IP\" : \"172.31.44.117  fe80:0:0:0:426:baff:fe61:cea4%eth0  172.31.44.117  0:0:0:0:0:0:0:1%lo  127.0.0.1\",\n" +
            "      \"IMMEDIATE THREAT\" : true,\n" +
            "      \"appName\" : \"NULL\",\n" +
            "      \"appId\" : \"2311\",\n" +
            "      \"DEFCON\" : \"DEFCON5\",\n" +
            "      \"apptokenid\" : \"6e9d24**4*69d4*889230e5*7e20**45\"\n" +
            "    },\n" +
            "    \"2020-04-23T04:58:09.540Z\" : {\n" +
            "      \"source\" : \"\",\n" +
            "      \"signal-emitter\" : \"**6df*4e62fe*88e2191d0*0e96*0**1 - 2212:Whyd*h-UserAdminServi*e-1\",\n" +
            "      \"instant\" : \"2020-04-23T04:58:09.521Z\",\n" +
            "      \"signal-severity\" : \"LOW\",\n" +
            "      \"text\" : \"Application authentication failure\",\n" +
            "      \"usertokenid\" : \"N/A\",\n" +
            "      \"EMITTER IP\" : \"172.31.44.117  fe80:0:0:0:426:baff:fe61:cea4%eth0  172.31.44.117  0:0:0:0:0:0:0:1%lo  127.0.0.1\",\n" +
            "      \"IMMEDIATE THREAT\" : true,\n" +
            "      \"appName\" : \"NULL\",\n" +
            "      \"appId\" : \"2311\",\n" +
            "      \"DEFCON\" : \"DEFCON5\",\n" +
            "      \"apptokenid\" : \"*e259d53d*69257d3641690**89*47*f\"\n" +
            "    },\n" +
            "    \"2020-04-23T04:58:09.557Z\" : {\n" +
            "      \"source\" : \"\",\n" +
            "      \"signal-emitter\" : \"**6df*4e62fe*88e2191d0*0e96*0**1 - 2212:Whyd*h-UserAdminServi*e-1\",\n" +
            "      \"instant\" : \"2020-04-23T04:58:09.534Z\",\n" +
            "      \"signal-severity\" : \"LOW\",\n" +
            "      \"text\" : \"Application authentication failure\",\n" +
            "      \"usertokenid\" : \"N/A\",\n" +
            "      \"EMITTER IP\" : \"172.31.44.117  fe80:0:0:0:426:baff:fe61:cea4%eth0  172.31.44.117  0:0:0:0:0:0:0:1%lo  127.0.0.1\",\n" +
            "      \"IMMEDIATE THREAT\" : true,\n" +
            "      \"appName\" : \"NULL\",\n" +
            "      \"appId\" : \"2311\",\n" +
            "      \"DEFCON\" : \"DEFCON5\",\n" +
            "      \"apptokenid\" : \"*e259d53d*69257d3641690**89*47*f\"\n" +
            "    },\n" +
            "    \"2020-04-23T05:00:07.157Z\" : {\n" +
            "      \"source\" : \"\",\n" +
            "      \"signal-emitter\" : \"**6df*4e62fe*88e2191d0*0e96*0**1 - 2212:Whyd*h-UserAdminServi*e-1\",\n" +
            "      \"instant\" : \"2020-04-23T05:00:07.143Z\",\n" +
            "      \"signal-severity\" : \"LOW\",\n" +
            "      \"text\" : \"Application authentication failure\",\n" +
            "      \"usertokenid\" : \"N/A\",\n" +
            "      \"EMITTER IP\" : \"172.31.44.117  fe80:0:0:0:426:baff:fe61:cea4%eth0  172.31.44.117  0:0:0:0:0:0:0:1%lo  127.0.0.1\",\n" +
            "      \"IMMEDIATE THREAT\" : true,\n" +
            "      \"appName\" : \"NULL\",\n" +
            "      \"appId\" : \"2311\",\n" +
            "      \"DEFCON\" : \"DEFCON5\",\n" +
            "      \"apptokenid\" : \"299e4***59*90f9f8906871649f4095*\"\n" +
            "    },\n" +
            "    \"2020-04-23T05:00:07.176Z\" : {\n" +
            "      \"source\" : \"\",\n" +
            "      \"signal-emitter\" : \"**6df*4e62fe*88e2191d0*0e96*0**1 - 2212:Whyd*h-UserAdminServi*e-1\",\n" +
            "      \"instant\" : \"2020-04-23T05:00:07.153Z\",\n" +
            "      \"signal-severity\" : \"LOW\",\n" +
            "      \"text\" : \"Application authentication failure\",\n" +
            "      \"usertokenid\" : \"N/A\",\n" +
            "      \"EMITTER IP\" : \"172.31.44.117  fe80:0:0:0:426:baff:fe61:cea4%eth0  172.31.44.117  0:0:0:0:0:0:0:1%lo  127.0.0.1\",\n" +
            "      \"IMMEDIATE THREAT\" : true,\n" +
            "      \"appName\" : \"NULL\",\n" +
            "      \"appId\" : \"2311\",\n" +
            "      \"DEFCON\" : \"DEFCON5\",\n" +
            "      \"apptokenid\" : \"299e4***59*90f9f8906871649f4095*\"\n" +
            "    },\n" +
            "    \"2020-04-23T05:06:55.961Z\" : {\n" +
            "      \"source\" : \"\",\n" +
            "      \"signal-emitter\" : \"**6df*4e62fe*88e2191d0*0e96*0**1 - 2212:Whyd*h-UserAdminServi*e-1\",\n" +
            "      \"instant\" : \"2020-04-23T05:06:55.948Z\",\n" +
            "      \"signal-severity\" : \"LOW\",\n" +
            "      \"text\" : \"Application authentication failure\",\n" +
            "      \"usertokenid\" : \"N/A\",\n" +
            "      \"EMITTER IP\" : \"172.31.44.117  fe80:0:0:0:426:baff:fe61:cea4%eth0  172.31.44.117  0:0:0:0:0:0:0:1%lo  127.0.0.1\",\n" +
            "      \"IMMEDIATE THREAT\" : true,\n" +
            "      \"appName\" : \"NULL\",\n" +
            "      \"appId\" : \"2311\",\n" +
            "      \"DEFCON\" : \"DEFCON5\",\n" +
            "      \"apptokenid\" : \"748e6e2ed9515*8481*07e**33223941\"\n" +
            "    },\n" +
            "    \"2020-04-23T05:06:55.992Z\" : {\n" +
            "      \"source\" : \"\",\n" +
            "      \"signal-emitter\" : \"**6df*4e62fe*88e2191d0*0e96*0**1 - 2212:Whyd*h-UserAdminServi*e-1\",\n" +
            "      \"instant\" : \"2020-04-23T05:06:55.974Z\",\n" +
            "      \"signal-severity\" : \"LOW\",\n" +
            "      \"text\" : \"Application authentication failure\",\n" +
            "      \"usertokenid\" : \"N/A\",\n" +
            "      \"EMITTER IP\" : \"172.31.44.117  fe80:0:0:0:426:baff:fe61:cea4%eth0  172.31.44.117  0:0:0:0:0:0:0:1%lo  127.0.0.1\",\n" +
            "      \"IMMEDIATE THREAT\" : true,\n" +
            "      \"appName\" : \"NULL\",\n" +
            "      \"appId\" : \"2311\",\n" +
            "      \"DEFCON\" : \"DEFCON5\",\n" +
            "      \"apptokenid\" : \"748e6e2ed9515*8481*07e**33223941\"\n" +
            "    },\n" +
            "    \"2020-04-23T05:14:14.290Z\" : {\n" +
            "      \"source\" : \"\",\n" +
            "      \"signal-emitter\" : \"**6df*4e62fe*88e2191d0*0e96*0**1 - 2212:Whyd*h-UserAdminServi*e-1\",\n" +
            "      \"instant\" : \"2020-04-23T05:14:14.277Z\",\n" +
            "      \"signal-severity\" : \"LOW\",\n" +
            "      \"text\" : \"Application authentication failure\",\n" +
            "      \"usertokenid\" : \"N/A\",\n" +
            "      \"EMITTER IP\" : \"172.31.44.117  fe80:0:0:0:426:baff:fe61:cea4%eth0  172.31.44.117  0:0:0:0:0:0:0:1%lo  127.0.0.1\",\n" +
            "      \"IMMEDIATE THREAT\" : true,\n" +
            "      \"appName\" : \"NULL\",\n" +
            "      \"appId\" : \"2311\",\n" +
            "      \"DEFCON\" : \"DEFCON5\",\n" +
            "      \"apptokenid\" : \"*f*404*1e58*0*f31d7*680998808374\"\n" +
            "    },\n" +
            "    \"2020-04-23T05:14:14.315Z\" : {\n" +
            "      \"source\" : \"\",\n" +
            "      \"signal-emitter\" : \"**6df*4e62fe*88e2191d0*0e96*0**1 - 2212:Whyd*h-UserAdminServi*e-1\",\n" +
            "      \"instant\" : \"2020-04-23T05:14:14.298Z\",\n" +
            "      \"signal-severity\" : \"LOW\",\n" +
            "      \"text\" : \"Application authentication failure\",\n" +
            "      \"usertokenid\" : \"N/A\",\n" +
            "      \"EMITTER IP\" : \"172.31.44.117  fe80:0:0:0:426:baff:fe61:cea4%eth0  172.31.44.117  0:0:0:0:0:0:0:1%lo  127.0.0.1\",\n" +
            "      \"IMMEDIATE THREAT\" : true,\n" +
            "      \"appName\" : \"NULL\",\n" +
            "      \"appId\" : \"2311\",\n" +
            "      \"DEFCON\" : \"DEFCON5\",\n" +
            "      \"apptokenid\" : \"*f*404*1e58*0*f31d7*680998808374\"\n" +
            "    },\n" +
            "    \"2020-04-23T05:14:25.057Z\" : {\n" +
            "      \"source\" : \"\",\n" +
            "      \"signal-emitter\" : \"**6df*4e62fe*88e2191d0*0e96*0**1 - 2212:Whyd*h-UserAdminServi*e-1\",\n" +
            "      \"instant\" : \"2020-04-23T05:14:25.051Z\",\n" +
            "      \"signal-severity\" : \"LOW\",\n" +
            "      \"text\" : \"Application authentication failure\",\n" +
            "      \"usertokenid\" : \"N/A\",\n" +
            "      \"EMITTER IP\" : \"172.31.44.117  fe80:0:0:0:426:baff:fe61:cea4%eth0  172.31.44.117  0:0:0:0:0:0:0:1%lo  127.0.0.1\",\n" +
            "      \"IMMEDIATE THREAT\" : true,\n" +
            "      \"appName\" : \"NULL\",\n" +
            "      \"appId\" : \"2311\",\n" +
            "      \"DEFCON\" : \"DEFCON5\",\n" +
            "      \"apptokenid\" : \"f9*f1*95633686dd480e336*8ed*124*\"\n" +
            "    },\n" +
            "    \"2020-04-23T05:14:25.078Z\" : {\n" +
            "      \"source\" : \"\",\n" +
            "      \"signal-emitter\" : \"**6df*4e62fe*88e2191d0*0e96*0**1 - 2212:Whyd*h-UserAdminServi*e-1\",\n" +
            "      \"instant\" : \"2020-04-23T05:14:25.065Z\",\n" +
            "      \"signal-severity\" : \"LOW\",\n" +
            "      \"text\" : \"Application authentication failure\",\n" +
            "      \"usertokenid\" : \"N/A\",\n" +
            "      \"EMITTER IP\" : \"172.31.44.117  fe80:0:0:0:426:baff:fe61:cea4%eth0  172.31.44.117  0:0:0:0:0:0:0:1%lo  127.0.0.1\",\n" +
            "      \"IMMEDIATE THREAT\" : true,\n" +
            "      \"appName\" : \"NULL\",\n" +
            "      \"appId\" : \"2311\",\n" +
            "      \"DEFCON\" : \"DEFCON5\",\n" +
            "      \"apptokenid\" : \"f9*f1*95633686dd480e336*8ed*124*\"\n" +
            "    },\n" +
            "    \"2020-04-23T05:17:04.595Z\" : {\n" +
            "      \"source\" : \"\",\n" +
            "      \"signal-emitter\" : \"**6df*4e62fe*88e2191d0*0e96*0**1 - 2212:Whyd*h-UserAdminServi*e-1\",\n" +
            "      \"instant\" : \"2020-04-23T05:17:04.584Z\",\n" +
            "      \"signal-severity\" : \"LOW\",\n" +
            "      \"text\" : \"Application authentication failure\",\n" +
            "      \"usertokenid\" : \"N/A\",\n" +
            "      \"EMITTER IP\" : \"172.31.44.117  fe80:0:0:0:426:baff:fe61:cea4%eth0  172.31.44.117  0:0:0:0:0:0:0:1%lo  127.0.0.1\",\n" +
            "      \"IMMEDIATE THREAT\" : true,\n" +
            "      \"appName\" : \"NULL\",\n" +
            "      \"appId\" : \"2311\",\n" +
            "      \"DEFCON\" : \"DEFCON5\",\n" +
            "      \"apptokenid\" : \"dd08f39ff282780*08*50*23dd2ef829\"\n" +
            "    },\n" +
            "    \"2020-04-23T05:17:04.620Z\" : {\n" +
            "      \"source\" : \"\",\n" +
            "      \"signal-emitter\" : \"**6df*4e62fe*88e2191d0*0e96*0**1 - 2212:Whyd*h-UserAdminServi*e-1\",\n" +
            "      \"instant\" : \"2020-04-23T05:17:04.592Z\",\n" +
            "      \"signal-severity\" : \"LOW\",\n" +
            "      \"text\" : \"Application authentication failure\",\n" +
            "      \"usertokenid\" : \"N/A\",\n" +
            "      \"EMITTER IP\" : \"172.31.44.117  fe80:0:0:0:426:baff:fe61:cea4%eth0  172.31.44.117  0:0:0:0:0:0:0:1%lo  127.0.0.1\",\n" +
            "      \"IMMEDIATE THREAT\" : true,\n" +
            "      \"appName\" : \"NULL\",\n" +
            "      \"appId\" : \"2311\",\n" +
            "      \"DEFCON\" : \"DEFCON5\",\n" +
            "      \"apptokenid\" : \"dd08f39ff282780*08*50*23dd2ef829\"\n" +
            "    },\n" +
            "    \"2020-04-23T05:20:12.037Z\" : {\n" +
            "      \"source\" : \"\",\n" +
            "      \"signal-emitter\" : \"**6df*4e62fe*88e2191d0*0e96*0**1 - 2212:Whyd*h-UserAdminServi*e-1\",\n" +
            "      \"instant\" : \"2020-04-23T05:20:12.008Z\",\n" +
            "      \"signal-severity\" : \"LOW\",\n" +
            "      \"text\" : \"Application authentication failure\",\n" +
            "      \"usertokenid\" : \"N/A\",\n" +
            "      \"EMITTER IP\" : \"172.31.44.117  fe80:0:0:0:426:baff:fe61:cea4%eth0  172.31.44.117  0:0:0:0:0:0:0:1%lo  127.0.0.1\",\n" +
            "      \"IMMEDIATE THREAT\" : true,\n" +
            "      \"appName\" : \"NULL\",\n" +
            "      \"appId\" : \"2311\",\n" +
            "      \"DEFCON\" : \"DEFCON5\",\n" +
            "      \"apptokenid\" : \"799d778*1d*d4e76*e134814334288f7\"\n" +
            "    },\n" +
            "    \"2020-04-23T05:20:12.056Z\" : {\n" +
            "      \"source\" : \"\",\n" +
            "      \"signal-emitter\" : \"**6df*4e62fe*88e2191d0*0e96*0**1 - 2212:Whyd*h-UserAdminServi*e-1\",\n" +
            "      \"instant\" : \"2020-04-23T05:20:12.020Z\",\n" +
            "      \"signal-severity\" : \"LOW\",\n" +
            "      \"text\" : \"Application authentication failure\",\n" +
            "      \"usertokenid\" : \"N/A\",\n" +
            "      \"EMITTER IP\" : \"172.31.44.117  fe80:0:0:0:426:baff:fe61:cea4%eth0  172.31.44.117  0:0:0:0:0:0:0:1%lo  127.0.0.1\",\n" +
            "      \"IMMEDIATE THREAT\" : true,\n" +
            "      \"appName\" : \"NULL\",\n" +
            "      \"appId\" : \"2311\",\n" +
            "      \"DEFCON\" : \"DEFCON5\",\n" +
            "      \"apptokenid\" : \"799d778*1d*d4e76*e134814334288f7\"\n" +
            "    }\n" +
            "  }}\n";

    private String uawa = "{\n" +
            "  \"Status\": \"OK\",\n" +
            "  \"Version\": \"2.5.38-SNAPSHOT [Whydah-UserAdminWebApp-1 - 172.31.44.17  fe80:0:0:0:426:baff:fe61:cea4%eth0  172.31.44.17  0:0:0:0:0:0:0:1%lo  127.0.0.1]\",\n" +
            "  \"DEFCON\": \"DEFCON5\",\n" +
            "  \"STS\": \"https://entrasso-devtest.entraos.io/tokenservice/\",\n" +
            "  \"UAS\": \"https://entrasso-devtest.entraos.io/useradminservice/\",\n" +
            "  \"hasApplicationToken\": \"true\",\n" +
            "  \"hasValidApplicationToken\": \"true\",\n" +
            "  \"hasApplicationsMetadata\": \"true\",\n" +
            "  \"now\": \"2020-04-22T21:21:23.735Z\",\n" +
            "  \"running since\": \"2020-04-22T21:12:04.131Z\"}\n";

    private String crm = "{\n" +
            "  \"Status\": \"OK\",\n" +
            "  \"Version\": \"2.5.38-SNAPSHOT [reporterClient started - 172.31.44.11  fe80:0:0:0:426:baff:fe61:cea4%eth0  172.31.44.11  0:0:0:0:0:0:0:1%lo  127.0.0.1]\",\n" +
            "  \"DEFCON\": \"DEFCON5\",\n" +
            "  \"hasApplicationToken\": \"true\",\n" +
            "  \"hasValidApplicationToken\": \"true\",\n" +
            "  \"hasApplicationsMetadata\": \"false\",\n" +
            "  \"now\": \"2020-04-23T05:07:40.973Z\",\n" +
            "  \"running since\": \"2020-04-23T05:06:53.319Z\"}\n";

    private String mapi = "{\"Status\":\"true\",\"name\":\"menu-api\",\"ip\":\"172.31.42.94\",\"version\":\"1.0-SNAPSHOT\",\"now\":\"2020-04-28T08:45:19.568010Z\",\"running since\":\"2020-04-28T08:40:04.069113Z\",\"integrations\":[{\"name\":\"preorder-menu\",\"provider\":\"Retail Solution\",\"isMocked\":true}]}";

    private String doorhealth = "{\n" +
            "  \"Status\": \"true\",\n" +
            "  \"name\": \"Door: Moterom_180-20101\",\n" +
            "  \"lockStatus\": \"lock\",\n" +
            "  \"userIdentifier\": \"Mark\",\n" +
            "  \"lockTimeStamp\": \"2020-04-29T10:08:53.897581Z\",\n" +
            "  \"ip\": \"172.31.47.137:20101\",\n" +
            "  \"version\": \"Door: Moterom_180:20101\",\n" +
            "  \"now\": \"2020-04-29T10:09:00.941786Z\",\n" +
            "  \"running since\": \"2020-04-29T09:12:39.827905Z\"\n" +
            "\n" +
            "}\n";

    private String old_school_health = "{\"outcome\":\"UP\",\"status\":\"UP\",\"checks\":[]}";

    private String failing_in_the_wild_json_health = "{\"Status\":\"true\",\"name\":\"room-authorization-api\",\"ip\":\"172.31.13.23\",\"version\":\"0.6.6\",\"now\":\"2020-08-17T20:54:10.583681Z\",\"running since\":\"2020-08-01T17:31:03.398711Z\",\"\n" +
            "integrations\":[{\"name\":\"Nexudus-webhook\",\"isMocked\":true}]}";

    private String badOauthHeathJson = "{\n" +
            "  \"Status\": \"OK\",\n" +
            "  \"Version\": \"2.2.63-SNAPSHOT [Whydah-OAuth2Service-1 - 172.31.33.19  fe80:0:0:0:46e:ebff:fe9f:ce74%eth0  172.31.33.19  0:0:0:0:0:0:0:1%lo  127.0.0.1]\"\n" +
            ",\n" +
            "  \"IP\": \"172.31.33.19  fe80:0:0:0:46e:ebff:fe9f:ce74%eth0  172.31.33.19  0:0:0:0:0:0:0:1%lo  127.0.0.1\",\n" +
            "  \"DEFCON\": \"DEFCON5\",\n" +
            "  \"STS\": \"null\",\n" +
            "  \"UAS\": \"null\",\n" +
            "  \"hasApplicationToken\": \"false\",\n" +
            "  \"hasValidApplicationToken\": \"false\",\n" +
            "  \"hasApplicationsMetadata\": \"false\",\n" +
            "  \"ConfiguredApplications\": \"0\",\n" +
            "  \"now\": \"2020-08-17T21:11:26.766Z\",\n" +
            "  \"running since\": \"2020-08-17T08:26:39.925Z\",\n" +
            "\n" +
            "  \"clientIDs\": []\n" +
            "}";
}