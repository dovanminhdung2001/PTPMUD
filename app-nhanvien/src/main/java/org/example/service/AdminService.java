package org.example.service;


import org.example.model.AdminEntity;

import java.sql.*;

public class AdminService {
    private static String url = "jdbc:oracle:thin:@localhost:1521:orcl";
    private static String user = "sysdba";
    private static String password = "123456789";
    private static Connection connection;

    public static AdminEntity find (AdminEntity admin) throws SQLException {
        connection = DriverManager.getConnection(url, user, password);
        Statement statement = connection.createStatement();
        ResultSet resultSet;
        String sql = String.format("select * from sysdba.tbl_admin where username like '%s' and password like '%s'",
                admin.getUsername(), admin.getUsername());

        statement.execute(sql);
        resultSet = statement.getResultSet();
        return  resultSet.next()
                ? new AdminEntity(resultSet.getString("username" ), resultSet.getString("password"))
                : null;
    }
}
