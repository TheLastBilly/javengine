package javengine;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

public class logger {
    private static boolean file_specified = false;
    private static FileWriter writer;
    private static String outfile;

    public static void rawLog(String msg)
    {
        System.out.print(msg);
    }

    private static void writeToFile(String msg)
    {
        try
        {
            writer = new FileWriter(outfile);
            writer.write(msg); 
            writer.close();
        }
        catch(Exception e)
        {
            rawLog("[GLOBAL] Cannot write to file \"" + outfile + "\", error: " + e.getMessage());
        }
    }

    private static void log(String msg, String module)
    {
        String out_msg = "[" + module + "] " + msg + "\n";
        rawLog(out_msg);
        if(file_specified)
            writeToFile(out_msg);
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

    public static void initFileOutput(String path)
    {
        if(file_specified)
            return;
        
        try
        {
            writer = new FileWriter(path);
            writer.close();
            outfile = path;
            file_specified = true;
        }
        catch(Exception e)
        {
            log("Error openning file: \"" + e.getMessage() + "\"");
        }
    }
}