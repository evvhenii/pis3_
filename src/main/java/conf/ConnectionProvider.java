package conf;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {
    static final String DB_URL = "jdbc:postgresql://localhost:5432/iasa-java";
    static final String USER = "postgres";
    static final String PASS = "123";
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER, PASS);
    }
}
