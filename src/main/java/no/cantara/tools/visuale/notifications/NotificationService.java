package no.cantara.tools.visuale.notifications;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

public class NotificationService {

    public static final Logger logger = LoggerFactory.getLogger(NotificationService.class);

    private static final String alarmFilename = "./logs/service-notification-alarms.log";
    private static final String warningFilename = "./logs/service-notification-warnings.log";

    public static Map warningMap = new HashMap<>();
    public static Map alarmMap = new HashMap<>();

    public static boolean sendWarning(String service, String warningMessage) {
        if (warningMap.get(service) == null) {
            warningMap.put(service, warningMessage);
            appendWarningToFile(service, warningMessage, false);
        }
        return true;
    }

    public static boolean sendAlarm(String service, String alarmMessage) {
        if (alarmMap.get(service) == null) {
            alarmMap.put(service, alarmMessage);
            appendAlarmToFile(service, alarmMessage, false);
        }
        return true;
    }

    public static boolean clearService(String service) {
        if (alarmMap.get(service) != null) {
            alarmMap.remove(service);
            appendAlarmToFile(service, "", false);
        }
        if (warningMap.get(service) != null) {
            warningMap.remove(service);
            appendWarningToFile(service, "", false);
        }
        return true;
    }

    private static void appendAlarmToFile(String service, String message, boolean cleared) {
        try {
            FileWriter fileWriter = new FileWriter(alarmFilename, true);
            PrintWriter printWriter = new PrintWriter(fileWriter, true);
            if (!cleared) {
                printWriter.println("Alarm for " + service);
                printWriter.println("    " + Instant.now().toString() + " - " + message + "\n");
            } else {
                printWriter.println("Alarm for " + service + " cleared - time: " + Instant.now().toString());
            }
            printWriter.flush();
            printWriter.close();
            fileWriter.flush();
            fileWriter.close();
        } catch (Exception e) {
            logger.error("Unable to send and persist alarm");
        }
    }

    private static void appendWarningToFile(String service, String mwessage, boolean cleared) {
        try {
            FileWriter fileWriter = new FileWriter(warningFilename, true);
            PrintWriter printWriter = new PrintWriter(fileWriter, true);
            if (!cleared) {
                printWriter.println("Warning for " + service);
                printWriter.println("    " + Instant.now().toString() + " - " + mwessage + "\n");
            } else {
                printWriter.println("Warning for " + service + " cleared - time: " + Instant.now().toString());
            }
            printWriter.flush();
            printWriter.close();
            fileWriter.flush();
            fileWriter.close();
        } catch (Exception e) {
            logger.error("Unable to send and persist warning");
        }
    }
}
