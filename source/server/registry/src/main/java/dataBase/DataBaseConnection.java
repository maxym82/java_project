package dataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {

    private static Connection connection = null;
    private static final String url;
    private static final String userName;
    private static final String password;

    private DataBaseConnection () {
    }
    static {
        url = System.getProperty("dbURL");
        userName = System.getProperty("dbUserName");
        password = System.getProperty("dbPassword");
    }

    public static Connection getConnection() {
        try {
            if (connection == null) {
                connection = DriverManager.getConnection(url, userName, password);
                System.out.println("Connection has been established");
            }else if (connection.isClosed()) {
                connection = DriverManager.getConnection(url, userName, password);
                System.out.println("Connection has been established");
            }
        } catch (SQLException e) {
            System.out.println("Was not able to set up connection: \n" + e.getMessage());
        }
        return connection;
    }
}
