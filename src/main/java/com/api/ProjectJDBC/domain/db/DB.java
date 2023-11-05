package com.api.ProjectJDBC.domain.db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DB {
    private static Connection connection = null;

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            try {
                var properties = loadProperties();
                connection = DriverManager.getConnection(
                        properties.getProperty("dburl"),
                        properties.getProperty("user"),
                        properties.getProperty("password")
                );
            } catch (Exception e) {
                throw new DbException(e.getMessage());
            }
        }
        return connection;
    }

    public static Properties loadProperties() {
        Properties properties = new Properties();
        try (FileInputStream basePropertieFile = new FileInputStream("src/main/resources/application.properties")) {
            properties.load(basePropertieFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return properties;
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
    }
    public static void closeStatement(Statement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
    }

    public static void closeResultSet(ResultSet result) {
        if (result != null) {
            try {
                result.close();
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
    }
}
