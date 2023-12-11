package lab5.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    public static Connection getConnection(String url, String name, String pass) {
        try {
            return DriverManager.getConnection(url, name, pass);
        } catch (SQLException e ) {
            System.out.println("Connection isn't created! Method returned NULL!");
            return null;
        }
    }
}