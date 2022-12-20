package org.example.service;

import org.example.model.CheckInEntity;
import org.example.model.UserEntity;
import org.example.utils.DateUtils;

import java.sql.*;
import java.text.ParseException;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;

public class CheckInService {
    private static final String url = "jdbc:oracle:thin:@localhost:1521:orcl";
    private static final String username = "sysdba";
    private static final String password = "123456789";
    private static Connection connection;

    public static void checkIn (UserEntity user) throws SQLException , ClassNotFoundException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement();
        String sql = String.format("INSERT INTO SYSDBA.TBL_CHECKIN (USER_ID, CHECKIN) VALUES (%d,  TO_DATE('%s', 'yyyy-mm-dd hh24:mi:ss'))",
                user.getId(),
                DateUtils.nowStr()
        );
        statement.execute(sql);
        statement.execute(String.format("INSERT INTO SYSDBA.TBL_LOGINING values (%d)", user.getId()));
    }

    public static void goOut (Integer userId) throws SQLException, ParseException , ClassNotFoundException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement();
        String sql = String.format("update sysdba.tbl_checkin set %s = to_date('%s', 'yyyy-mm-dd hh24:mi:ss') where user_id = %d and CHECKIN BETWEEN TO_DATE('%s', 'yyyy-mm-dd') AND  TO_DATE('%s', 'yyyy-mm-dd')",
                "go_out" + (goOutTimes(userId) + 1), DateUtils.nowStr(), userId, DateUtils.todayStr(), DateUtils.tomorrowStr()
        );
        statement.execute(sql);
    }

    public static void goIn (Integer userId) throws SQLException, ParseException, ClassNotFoundException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement();
        String sql = String.format("update sysdba.tbl_checkin set go_in%d = to_date('%s', 'yyyy-mm-dd hh24:mi:ss') where user_id = %d and CHECKIN BETWEEN TO_DATE('%s', 'yyyy-mm-dd') AND  TO_DATE('%s', 'yyyy-mm-dd')",
                goInTimes(userId) + 1, DateUtils.nowStr(), userId, DateUtils.todayStr(), DateUtils.tomorrowStr()
        );
        statement.execute(sql);
    }

    public static void checkOut (Integer userId) throws SQLException, ParseException {
        connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement();
        String sql = String.format("update sysdba.tbl_checkin set checkout = to_date('%s', 'yyyy-mm-dd hh24:mi:ss') where user_id = %d and CHECKIN BETWEEN TO_DATE('%s', 'yyyy-mm-dd') AND  TO_DATE('%s', 'yyyy-mm-dd')",
                 DateUtils.nowStr(), userId, DateUtils.todayStr(), DateUtils.tomorrowStr()
        );
        statement.execute(sql);
        statement.execute(String.format("Delete from SYSDBA.TBL_LOGINING where logining = %d", userId));
    }

    public static CheckInEntity findByUserIdAndCheckIn (Integer userId, Date checkIn) throws SQLException, ClassNotFoundException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement();
        Date nextDay = Date.from(checkIn.toInstant().minus(-1, ChronoUnit.DAYS));
        String sql = String.format("SELECT * FROM SYSDBA.TBL_CHECKIN WHERE USER_ID = %d AND  CHECKIN BETWEEN TO_DATE('%s', 'yyyy-mm-dd') AND  TO_DATE('%s', 'yyyy-mm-dd')",
                userId, DateUtils.sdf.format(checkIn), DateUtils.sdf.format(nextDay)
        );
        ResultSet resultSet;

        statement.execute(sql);
        resultSet = statement.getResultSet();
        return resultSet.next()
                ? new CheckInEntity(
                        resultSet.getInt(1),
                        resultSet.getInt(2),
                        resultSet.getDate(3),
                        resultSet.getDate(4),
                        resultSet.getDate(5),
                        resultSet.getDate(6),
                        resultSet.getDate(7),
                        resultSet.getDate(8),
                        resultSet.getDate(9),
                        resultSet.getDate(10)
                )
                : null;
    }

    public static CheckInEntity findByUserIdAndCheckInToday(Integer userId) throws SQLException, ParseException, ClassNotFoundException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement();
        ResultSet resultSet;
        String sql = String.format("SELECT * FROM SYSDBA.TBL_CHECKIN WHERE USER_ID = %d AND  CHECKIN BETWEEN TO_DATE('%s', 'yyyy-mm-dd') AND  TO_DATE('%s', 'yyyy-mm-dd')",
                userId, DateUtils.todayStr(), DateUtils.tomorrowStr()
        );

        statement.execute(sql);
        resultSet = statement.getResultSet();
        return resultSet.next()
                ? new CheckInEntity(
                        resultSet.getInt(1),
                        resultSet.getInt(2),
                        resultSet.getDate(3),
                        resultSet.getDate(4),
                        resultSet.getDate(5),
                        resultSet.getDate(6),
                        resultSet.getDate(7),
                        resultSet.getDate(8),
                        resultSet.getDate(9),
                        resultSet.getDate(10)
                )
                : null;
    }

    public static ArrayList<CheckInEntity> findByUserIdAndCheckInBetween (Integer userId, Date fromDate, Date toDate) throws SQLException {
        ArrayList<CheckInEntity> list = new ArrayList<>();
        connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement();
        ResultSet resultSet;
        toDate = Date.from(toDate.toInstant().minus(-1, ChronoUnit.DAYS));
        String sql = String.format("SELECT * FROM SYSDBA.TBL_CHECKIN WHERE USER_ID = %d AND  CHECKIN BETWEEN TO_DATE('%s', 'yyyy-mm-dd') AND  TO_DATE('%s', 'yyyy-mm-dd')",
                userId, DateUtils.sdf.format(fromDate), DateUtils.sdf.format(toDate)
        );

        statement.execute(sql);
        resultSet = statement.getResultSet();
        while (resultSet.next()) {
            list.add(new CheckInEntity(
                    resultSet.getInt(1),
                    resultSet.getInt(2),
                    resultSet.getDate(3),
                    resultSet.getDate(4),
                    resultSet.getDate(5),
                    resultSet.getDate(6),
                    resultSet.getDate(7),
                    resultSet.getDate(8),
                    resultSet.getDate(9),
                    resultSet.getDate(10)
            ));
        }
        return list;
    }


    public static Integer goOutTimes (Integer userId) throws SQLException, ParseException, ClassNotFoundException {
        CheckInEntity checkIn = findByUserIdAndCheckIn(userId, DateUtils.today());
        if (checkIn.getGoOut1() == null) return 0;
        if (checkIn.getGoOut2() == null) return 1;
        if (checkIn.getGoOut3() == null) return 2;
        return 3;
    }

    public static Integer goInTimes (Integer userId) throws SQLException, ParseException, ClassNotFoundException {
        CheckInEntity checkIn = findByUserIdAndCheckIn(userId, DateUtils.today());
        if (checkIn.getGoIn1() == null) return 0;
        if (checkIn.getGoIn2() == null) return 1;
        if (checkIn.getGoIn3() == null) return 2;
        return 3;
    }
}
