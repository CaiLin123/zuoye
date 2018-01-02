package zuoye;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Jdbc {
    static {
        Properties prop = new Properties();
        ClassLoader classLoader = Jdbc.class.getClassLoader();
        InputStream in = classLoader.getResourceAsStream("jdbc.properties");
        try {
            prop.load(in);
            String driverName = prop.getProperty("driverName");
            url = prop.getProperty("url");
            database = prop.getProperty("database");
            username = prop.getProperty("username");
            password = prop.getProperty("password");
            Class.forName(driverName);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static String url;
    private static String database;
    private static String username;
    private static String password;

    public static Connection getConn() throws SQLException {
        Connection connection = DriverManager.getConnection(url + database, username, password);
        return connection;
    }
}
