package net.ventugames.ventuemu;

import com.bugsnag.Client;
import lombok.Getter;
import net.ventugames.ventuemu.config.Configuration;
import net.ventugames.ventuemu.database.Database;
import net.ventugames.ventuemu.utils.UtilLogger;

import java.io.File;
import java.io.IOException;

/**
 * Created by yarno on 6/6/2016.
 */
public class VentuEmu {

    private static VentuEmu instance;
    private Configuration configuration;
    private Database database;
    private long uptime;
    private boolean running = true;


    public VentuEmu() {
        System.out.println();
        System.out.println("#########################################");
        System.out.println("##  VentuEmu v1-INDEV Habbo Emulator   ##");
        System.out.println("##  Copyright (C) 2016 VentuGames      ##");
        System.out.println("##  Yarno // Evoltr                    ##");
        System.out.println("##  http://ventugames.com              ##");
        System.out.println("#########################################");
        System.out.println();
        instance = this;
        uptime = System.currentTimeMillis();
        loadConfig();

        //Connect to the database.
        database = new Database(this);
        database.setup();
    }

    public static void main(String[] args) {
        new VentuEmu().run();
    }

    public void run() {
        //TODO: Let the system run
    }

    public Configuration getConfig() {
        return configuration;
    }

    public void loadConfig() {
        configuration = new Configuration(new File("config.properties"));

        try {
            configuration.load();
        } catch (IOException e) {
            UtilLogger.warn("Failed to load config: " + e.getMessage());
        }
    }

    public void shutdown() {
        running = false;
        UtilLogger.critical("Shutting down...");

        //Exit out of the program.
        System.exit(0);
    }

    public static VentuEmu getInstance() {
        return instance;
    }
    public long getUptime() {
        return uptime;
    }
    public Database getDatabase() {
        return database;
    }
    public Configuration getConfiguration() {
        return configuration;
    }
    public boolean isRunning() {
        return running;
    }

}
