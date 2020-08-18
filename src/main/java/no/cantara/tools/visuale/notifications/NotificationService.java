package no.cantara.tools.visuale.notifications;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Instant;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class NotificationService {

    public static final Logger logger = LoggerFactory.getLogger(NotificationService.class);
    public static ObjectMapper mapper = new ObjectMapper().configure(com.fasterxml.jackson.core.JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

    private static final String alarmFilename = "./logs/service-notification-alarms.log";
    private static final String warningFilename = "./logs/service-notification-warnings.log";
    private static final String notificationStateFilename = "./logs/service-notification-mapname.json";

    public static Map warningMap = new ConcurrentHashMap();
    public static Map alarmMap = new ConcurrentHashMap<>();
    private static boolean initialBootWarning = true;
    private static boolean initialBootAlarm = true;

    private static boolean loadedStateFromFile = false;

//    static {
//        sendAlarm("test", "atull");
//        sendWarning("test", "wtull");
//        clearService("test");
//    }

    public static boolean sendWarning(String service, String warningMessage) {
        if (!loadedStateFromFile) {
            restoreNotificationStateMaps();
            loadedStateFromFile = true;
        }
        if (warningMap.get(service) == null) {
            warningMap.put(service, warningMessage);
            appendWarningToFile(service, warningMessage, false);
            storeNotificationStateMaps();
        }
        return true;
    }

    public static boolean sendAlarm(String service, String alarmMessage) {
        if (!loadedStateFromFile) {
            restoreNotificationStateMaps();
            loadedStateFromFile = true;
        }
        if (alarmMap.get(service) == null) {
            alarmMap.put(service, alarmMessage);
            appendAlarmToFile(service, alarmMessage, false);
            storeNotificationStateMaps();
        }
        return true;
    }

    public static boolean clearService(String service) {
        if (alarmMap.get(service) != null) {
            alarmMap.remove(service);
            appendAlarmToFile(service, "", true);
        }
        if (warningMap.get(service) != null) {
            warningMap.remove(service);
            appendWarningToFile(service, "", true);
        }
        return true;
    }

    private static synchronized void appendAlarmToFile(String service, String amessage, boolean cleared) {
        try {
            FileWriter fileWriter;
            if (initialBootAlarm && !cleared) {
                initialBootAlarm = false;
                fileWriter = new FileWriter(alarmFilename, false);
            } else {
                fileWriter = new FileWriter(alarmFilename, true);
            }
            PrintWriter printWriter = new PrintWriter(fileWriter, true);
            if (!cleared) {
                printWriter.println("Alarm for " + service);
                printWriter.println("    " + Instant.now().toString() + " - " + amessage);
            } else {
                printWriter.println("Cleared Alarm for " + service + " - time: " + Instant.now().toString());
            }
            printWriter.flush();
        } catch (Exception e) {
            logger.error("Unable to send and persist alarm", e);
        }
    }

    private static synchronized void appendWarningToFile(String service, String mwessage, boolean cleared) {
        try {
            FileWriter fileWriter;
            if (initialBootWarning && !cleared) {
                initialBootWarning = false;
                fileWriter = new FileWriter(warningFilename, false);
            } else {
                fileWriter = new FileWriter(warningFilename, true);
            }
            PrintWriter printWriter = new PrintWriter(fileWriter, true);
            if (!cleared) {
                printWriter.println("Warning for " + service);
                printWriter.println("    " + Instant.now().toString() + " - " + mwessage);
            } else {
                printWriter.println("Cleared Warning for " + service + "  - time: " + Instant.now().toString());
            }

            printWriter.close();
        } catch (Exception e) {
            logger.error("Unable to send and persist warning", e);
        }
    }

    private synchronized static void storeNotificationStateMaps() {
        if (warningMap.size() > 0) {
            String warningMapFilename = notificationStateFilename.replace("mapname", "warning");
            try {
                FileWriter fileWriter = new FileWriter(warningMapFilename, false);
                PrintWriter printWriter = new PrintWriter(fileWriter, true);
                printWriter.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(warningMap));

                printWriter.close();
            } catch (Exception e) {
                logger.error("Unable to send and persist warning state", e);
            }
        }
        if (alarmMap.size() > 0) {
            String alarmMapFilename = notificationStateFilename.replace("mapname", "alarm");
            try {
                FileWriter fileWriter = new FileWriter(alarmMapFilename, false);
                PrintWriter printWriter = new PrintWriter(fileWriter, true);
                printWriter.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(alarmMap));
                printWriter.close();
            } catch (Exception e) {
                logger.error("Unable to send and persist alarm state", e);
            }
        }
    }

    private static boolean restoreNotificationStateMaps() {
        if (loadedStateFromFile) {
            return true;
        }
        loadedStateFromFile = true;
        String warningMapFileName = notificationStateFilename.replace("mapname", "warning");
        try {
            File file = new File(warningMapFileName);
            file.getParentFile().mkdirs();
            file.createNewFile();

            String content = new String(Files.readAllBytes(Paths.get(warningMapFileName)), StandardCharsets.UTF_8);
            if (content != null && content.length() > 4) {
                warningMap = mapper.readValue(content, Map.class);
            }
        } catch (Exception e) {
            logger.error("Unable to restore warning state", e);

        }
        String alarmMapFileName = notificationStateFilename.replace("mapname", "alarm");
        try {
            File file = new File(alarmMapFileName);
            file.getParentFile().mkdirs();
            file.createNewFile();
            String content = new String(Files.readAllBytes(Paths.get(alarmMapFileName)), StandardCharsets.UTF_8);
            if (content != null && content.length() > 4) {
                alarmMap = mapper.readValue(content, Map.class);
            }
        } catch (Exception e) {
            logger.error("Unable to restore alarm state", e);

        }
        return true;
    }
}
