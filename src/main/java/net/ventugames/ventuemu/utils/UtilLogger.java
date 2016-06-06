package net.ventugames.ventuemu.utils;

/**
 * Created by yarno on 6/6/2016.
 */
public class UtilLogger {

    public static void info(String message) {
        System.out.println("[INFO] " + message);
    }

    public static void debug(String message) {
        System.out.println("[DEBUG] " + message);
    }

    public static void warn(String message) {
        System.out.println("[WARN] " + message);
    }

    public static void critical(String message) {
        System.out.println("[CRITICAL] " + message);
    }
}
