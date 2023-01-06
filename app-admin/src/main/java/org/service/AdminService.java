package org.service;


import org.model.AdminEntity;

import java.sql.*;

public class AdminService {
    private static final String url = "jdbc:mysql://localhost:3306/ptpmud";
    private static final String user = "root";
    private static final String password = "1";
    private static Connection connection;
    public static AdminEntity find (AdminEntity admin) throws SQLException {
        connection = DriverManager.getConnection(url, user, password);
        Statement statement = connection.createStatement();
        ResultSet resultSet;
        String sql = String.format("select * from tbl_admin where username like '%s' and password like '%s'",
                admin.getUsername(), admin.getPassword());

        statement.execute(sql);
        resultSet = statement.getResultSet();
        return  resultSet.next()
                ? new AdminEntity(resultSet.getString("username" ), resultSet.getString("password"))
                : null;
    }

    public static void changePassword (String newPass) throws SQLException {
        connection = DriverManager.getConnection(url, user, password);
        Statement statement = connection.createStatement();
        String sql = String.format("update tbl_admin set password = '%s'", newPass);

        statement.execute(sql);
    }
}
