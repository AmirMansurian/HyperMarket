package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB_Connection {

    Connection connection = null;

    public static Connection get_connection () throws ClassNotFoundException, SQLException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        Connection connection = DriverManager.getConnection( "jdbc:sqlserver://localhost:1433;DatabaseName=HyperMarket", "Amir", "1234");
        return connection;
    }

}
