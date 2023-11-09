package com.revature;

import java.sql.*;

public class PSQLConnectionUtility {
    static String url = "jdbc:postgresql://localhost:5432/JDBC-Demo";
    static String username = "postgres";
    static String password = "pass";

    static Connection getConnection() {

        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, username, password);
            System.out.println(connection.isValid(5));
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }

        return connection;
    }

}
