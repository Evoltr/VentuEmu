package net.ventugames.ventuemu.database;

import com.zaxxer.hikari.HikariDataSource;
import net.ventugames.ventuemu.VentuEmu;
import net.ventugames.ventuemu.utils.UtilLogger;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by yarno on 6/6/2016.
 */
public class Database {

    private VentuEmu ventuEmu;

    private String host;
    private String port;
    private String database;
    private String username;
    private String password;

    private HikariDataSource source;

    public Database(VentuEmu ventuEmu) {
        this.ventuEmu = ventuEmu;

        this.host = ventuEmu.getConfig().getSetting("db-host");
        this.port = ventuEmu.getConfig().getSetting("db-port");
        this.database = ventuEmu.getConfig().getSetting("db-database");
        this.username = ventuEmu.getConfig().getSetting("db-username");
        this.password = ventuEmu.getConfig().getSetting("db-password");
    }

    public void setup() {
        source = new HikariDataSource();

        source.setMaximumPoolSize(20);
        source.setDataSourceClassName("com.mysql.jdbc.jdbc2.optional.MysqlDataSource");
        source.addDataSourceProperty("serverName", host);
        source.addDataSourceProperty("port", port);
        source.addDataSourceProperty("databaseName", database);
        source.addDataSourceProperty("user", username);
        source.addDataSourceProperty("password", password);

        UtilLogger.info("Connection established with the Database.");
    }

    public Connection getConnection() throws SQLException {
        return source.getConnection();
    }
}
