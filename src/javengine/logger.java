package javengine;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

public class logger {
    public static void rawLog(String msg)
    {
        System.out.print(msg);
    }

    private static void log(String msg, String module)
    {
        rawLog("[" + module + "] " + msg + "\n");
    }

    public static void log(String msg)
    {
        log(msg, "GLOBAL");
    }

    public static class client
    {
        private String name;
        public client(String name)
        {
            this.name = name.toUpperCase();
        }

        public void log(String msg)
        {
            logger.log(msg, name);
        }
    }
}