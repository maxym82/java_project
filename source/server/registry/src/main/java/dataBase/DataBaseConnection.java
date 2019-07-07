package dataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {

    private static DataBaseConnection instance;
    private Connection connection = null;
    private final String url;
    private final String userName;
    private final String password;

    private DataBaseConnection () {
        this.url = System.getProperty("dbURL");
        this.userName = System.getProperty("dbUserName");
        this.password = System.getProperty("dbPassword");
    }

    public void setConnection() {
        try {
            this.connection = DriverManager.getConnection(url, userName, password);
            System.out.println("Connection has been established");
        } catch (SQLException e) {
            System.out.println("Was not able to set up connection: \n" + e.getMessage());
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public static DataBaseConnection getInstance() throws SQLException {
        if (instance == null) {
            instance = new DataBaseConnection();
        } else if (instance.getConnection().isClosed()) {
            instance = new DataBaseConnection();
        }
        return instance;
    }
}
