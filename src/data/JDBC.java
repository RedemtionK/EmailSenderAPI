package data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface JDBC {

    void connect(String serverName,
                    String databaseName,
                    String username,
                    String password) throws SQLException;
    Connection getConnection();
    ResultSet executeQuery(String query);
    boolean executeUpdate(String query);
}
