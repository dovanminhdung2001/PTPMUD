package org.example.service;

import org.example.model.UserEntity;

import java.sql.*;
import java.util.ArrayList;

public class UserService {
    private static final String url = "jdbc:mysql://localhost:3306/ptpmud";
    private static final String username = "root";
    private static final String password = "1";
    private static Connection connection;

    public static void create(UserEntity user) throws SQLException {
        connection = DriverManager.getConnection(url, username, password);
        String sql = String.format("INSERT INTO TBL_USER (Password, FULL_NAME, PHONE) VALUES ('%s', '%s', '%s')",
                user.getPassword(), user.getFullName(), user.getPhone());
        Statement statement = connection.createStatement();

        statement.execute(sql);
        connection.close();
    }

    public static UserEntity find(Integer id) throws SQLException, ClassNotFoundException {
        connection = DriverManager.getConnection(url, username, password);
        String sql = String.format("select * from tbl_user where id = %d", id);
        Statement statement = connection.createStatement();
        ResultSet resultSet;

        statement.execute(sql);
        resultSet = statement.getResultSet();
        return resultSet.next()
                ? new UserEntity(resultSet.getInt("id"),
                        resultSet.getString("password"),
                        resultSet.getString("full_name"),
                        resultSet.getString("phone"))
                : null;
    }

    public static ArrayList<UserEntity> findAll() throws SQLException, ClassNotFoundException {
        connection = DriverManager.getConnection(url, username, password);
        String sql =  "select * from tbl_user  " ;
        Statement statement = connection.createStatement();
        ResultSet resultSet;
        ArrayList<UserEntity> list = new ArrayList<>();

        statement.execute(sql);
        resultSet = statement.getResultSet();
        while (resultSet.next()) {
            list.add(new UserEntity(
                    resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4)
            ));
        }
        return list;
    }

    public static Boolean isLogging (Integer id) throws SQLException, ClassNotFoundException {
        connection = DriverManager.getConnection(url, username, password);
        String sql = String.format("select * from TBL_LOGINING where LOGINING = %d", id);
        Statement statement = connection.createStatement();
        ResultSet resultSet;

        statement.execute(sql);
        resultSet = statement.getResultSet();
        return resultSet.next()
                ? true
                : false;
    }

    public static void update (UserEntity user) throws SQLException {
        connection = DriverManager.getConnection(url, username, password);
        String sql = String.format("update  tbl_user set password = '%s', full_name = '%s', phone = '%s' where id = %d",
                user.getPassword(), user.getFullName(), user.getPhone(), user.getId());
        Statement statement = connection.createStatement();

        statement.execute(sql);
        connection.close();
    }

    public static void delete (Integer id) throws SQLException {
        connection = DriverManager.getConnection(url, username, password);
        String sql = String.format("delete from tbl_logining where logining = %d", id);
        Statement statement = connection.createStatement();
        statement.execute(sql);
        sql = String.format("delete from tbl_checkin where user_id = %d", id);
        statement.execute(sql);
        sql = String.format("delete from tbl_user where id = %d", id);
        statement.execute(sql);
    }
}
