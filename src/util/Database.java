package util;

import com.mysql.cj.jdbc.MysqlDataSource;
import data.JDBC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Database implements JDBC {
    private MysqlDataSource dataSource;
    private Connection connection;

    @Override
    public void connect(String serverName, String databaseName, String username, String password) throws SQLException {

        dataSource = new MysqlDataSource();
        dataSource.setServerName(serverName);
        dataSource.setDatabaseName(databaseName);
        dataSource.setUser(username);
        dataSource.setPassword(password);
        connection = dataSource.getConnection();

    }

    @Override
    public Connection getConnection() {
        return connection;
    }

    @Override
    public ResultSet executeQuery(String query) {
        try {
            return connection.
                    createStatement().
                    executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean executeUpdate(String query) {
        try {
            connection.
                    createStatement().
                    executeUpdate(query);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
