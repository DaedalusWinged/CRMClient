package ged.daedaluswin.crmclient.helper;

import com.alee.laf.WebLookAndFeel;

import javax.swing.*;

/**
 * Created by TeoGia on 12 April 2015.
 *
 * Checks computer's OS and initializes the default LookAnfFeel.
 * Creates a shutdown hook, for the application to exit properly on shutdown signal.
 */
public class Init {

    /**
     * To be used by multiple Threads that need to continue running even after an exit signal is sent.
     */
    public static volatile boolean keepRunning = false;

    private static String OS = System.getProperty("os.name").toLowerCase();

    private static boolean isWindows() {return (OS.contains("win"));}

    private static boolean isMac() {return (OS.contains("mac"));}

    private static boolean isUnix() {return (OS.contains("nix") || OS.contains("nux") || OS.contains("aix"));}

    private static boolean isSolaris() {return (OS.contains("sunos"));}

    public static void _init(){
        MyShutdownHook shutdownHook = new MyShutdownHook();
        Runtime.getRuntime().addShutdownHook(shutdownHook);

        WebLookAndFeel.install();
        //TODO customize WebLaF using StyleManager (in order to produce a skin xml)

        if (isWindows()) {
            System.out.println("Windows OS detected");
        } else if (isMac()) {
            System.out.println("Mac OS detected");
        } else if (isUnix()) {
            System.out.println("Unix or Linux OS detected");
        } else if (isSolaris()) {
            System.out.println("Solaris OS detected");
        } else {
            System.out.println("Your OS is not supported!");
            shutdown();
            System.exit(0);
        }
    }

    /**
     * Code to be executed on shutdown signal.
     */
    private static void shutdown() {
        //TODO check if any thread is running, using the keepRunning variable. Wait for it to execute, then move on.
        System.out.println("Exiting CRMClient..");
        while (keepRunning){System.out.println("trololol!!! u wait now");}
    }

    private static class MyShutdownHook extends Thread {
        public void run() {
            shutdown();
        }
    }
}
