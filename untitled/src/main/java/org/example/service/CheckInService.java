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
    private static final String url = "jdbc:mysql://localhost:3306/ptpmud";
    private static final String username = "root";
    private static final String password = "1";
    private static Connection connection;

    public static void checkIn (UserEntity user) throws SQLException, ParseException {
        connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement();
        CheckInEntity checkIn = new CheckInEntity(user.getId(), DateUtils.now());
        checkIn.validCheckInLate();
        String sql = String.format("INSERT INTO TBL_CHECKIN (USER_ID, CHECKIN, checkin_late, go_out_amount) VALUES (%d,  '%s', %d, %d)",
                checkIn.getUserId(),
                DateUtils.sdtf.format(checkIn.getCheckin()),
                checkIn.getCheckinLate(),
                0
        );
        statement.execute(sql);
        statement.execute(String.format("INSERT INTO TBL_LOGINING values (%d)", user.getId()));
    }

    public static void goOut (Integer userId) throws SQLException, ParseException , ClassNotFoundException {
        connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement();
        Long goutOutAmount = getGoOutAmount(userId) + 1;
        String sql = String.format("update tbl_checkin set %s =  '%s', go_out_amount = %d where user_id = %d and CHECKIN BETWEEN  '%s'  AND  '%s' ",
                "go_out" + goutOutAmount, DateUtils.nowStr(), goutOutAmount, userId, DateUtils.todayStr(), DateUtils.tomorrowStr()
        );
        statement.execute(sql);
    }

    public static void goIn (Integer userId) throws SQLException, ParseException, ClassNotFoundException {
        connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement();
        String sql = String.format("update tbl_checkin set go_in%d =  '%s'  where user_id = %d and CHECKIN BETWEEN '%s' AND '%s' ",
                goInTimes(userId) + 1, DateUtils.nowStr(), userId, DateUtils.todayStr(), DateUtils.tomorrowStr()
        );
        statement.execute(sql);
    }

    public static void checkOut (Integer userId) throws SQLException, ParseException, ClassNotFoundException {
        connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement();
        CheckInEntity checkIn = findByUserIdAndCheckInToday(userId);
        checkIn.setCheckout(DateUtils.now());
        checkIn.validCheckoutEarly();
        checkIn.validGoOutTime();
        checkIn.validWorkTime();
        String sql = String.format(
                "update tbl_checkin set checkout = '%s', checkout_early = %d, go_out_time = %d, work_time = %d where user_id = %d and CHECKIN BETWEEN '%s' AND '%s' ",
                 DateUtils.sdtf.format(checkIn.getCheckout()), checkIn.getCheckoutEarly(), checkIn.getGoOutTime(), checkIn.getWorkTime(), userId, DateUtils.todayStr(), DateUtils.tomorrowStr()
        );
        statement.execute(sql);
        statement.execute(String.format("Delete from TBL_LOGINING where logining = %d", userId));
    }

    public static CheckInEntity findByUserIdAndCheckIn (Integer userId, Date checkIn) throws SQLException, ClassNotFoundException {
        connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement();
        Date nextDay = Date.from(checkIn.toInstant().minus(-1, ChronoUnit.DAYS));
        String sql = String.format("SELECT * FROM TBL_CHECKIN WHERE USER_ID = %d AND  CHECKIN BETWEEN '%s' AND '%s' ",
                userId, DateUtils.sdf.format(checkIn), DateUtils.sdf.format(nextDay)
        );
        ResultSet resultSet;

        statement.execute(sql);
        resultSet = statement.getResultSet();
        return resultSet.next()
                ? new CheckInEntity(
                resultSet.getInt(1),
                resultSet.getInt(2),
                resultSet.getTimestamp(3)== null ? null : new Date(resultSet.getTimestamp(3).getTime()),
                resultSet.getTimestamp(4)== null ? null : new Date(resultSet.getTimestamp(4).getTime()),
                resultSet.getTimestamp(5)== null ? null : new Date(resultSet.getTimestamp(5).getTime()),
                resultSet.getTimestamp(6)== null ? null : new Date(resultSet.getTimestamp(6).getTime()),
                resultSet.getTimestamp(7)== null ? null : new Date(resultSet.getTimestamp(7).getTime()),
                resultSet.getTimestamp(8)== null ? null : new Date(resultSet.getTimestamp(8).getTime()),
                resultSet.getTimestamp(9)== null ? null : new Date(resultSet.getTimestamp(9).getTime()),
                resultSet.getTimestamp(10)== null ? null :new Date(resultSet.getTimestamp(10).getTime()),
                resultSet.getLong(11),
                resultSet.getLong(12),
                resultSet.getLong(13),
                resultSet.getLong(14),
                resultSet.getLong(15)
        )
                : null;
    }

    public static CheckInEntity findByUserIdAndCheckInToday(Integer userId) throws SQLException, ParseException, ClassNotFoundException {
        connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement();
        ResultSet resultSet;
        String sql = String.format("SELECT * FROM TBL_CHECKIN WHERE USER_ID = %d AND  CHECKIN BETWEEN '%s' AND '%s' ",
                userId, DateUtils.todayStr(), DateUtils.tomorrowStr()
        );

        statement.execute(sql);
        resultSet = statement.getResultSet();
        return resultSet.next()
                ? new CheckInEntity(
                        resultSet.getInt(1),
                        resultSet.getInt(2),
                        resultSet.getTimestamp(3)== null ? null : new Date(resultSet.getTimestamp(3).getTime()),
                        resultSet.getTimestamp(4)== null ? null : new Date(resultSet.getTimestamp(4).getTime()),
                        resultSet.getTimestamp(5)== null ? null : new Date(resultSet.getTimestamp(5).getTime()),
                        resultSet.getTimestamp(6)== null ? null : new Date(resultSet.getTimestamp(6).getTime()),
                        resultSet.getTimestamp(7)== null ? null : new Date(resultSet.getTimestamp(7).getTime()),
                        resultSet.getTimestamp(8)== null ? null : new Date(resultSet.getTimestamp(8).getTime()),
                        resultSet.getTimestamp(9)== null ? null : new Date(resultSet.getTimestamp(9).getTime()),
                        resultSet.getTimestamp(10)== null ? null :new Date(resultSet.getTimestamp(10).getTime()),
                        resultSet.getLong(11),
                        resultSet.getLong(12),
                        resultSet.getLong(13),
                        resultSet.getLong(14),
                        resultSet.getLong(15)
                )
                : null;
    }

    public static ArrayList<CheckInEntity> findByUserIdAndCheckInBetween (Integer userId, Date fromDate, Date toDate) throws SQLException {
        ArrayList<CheckInEntity> list = new ArrayList<>();
        connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement();
        ResultSet resultSet;
        toDate = Date.from(toDate.toInstant().minus(-1, ChronoUnit.DAYS));
        String sql = String.format("SELECT * FROM TBL_CHECKIN WHERE USER_ID = %d AND  CHECKIN BETWEEN '%s' AND '%s' ",
                userId, DateUtils.sdf.format(fromDate), DateUtils.sdf.format(toDate)
        );

        statement.execute(sql);
        resultSet = statement.getResultSet();
        while (resultSet.next()) {
            list.add(new CheckInEntity(
                    resultSet.getInt(1),
                    resultSet.getInt(2),
                    resultSet.getTimestamp(3)== null ? null : new Date(resultSet.getTimestamp(3).getTime()),
                    resultSet.getTimestamp(4)== null ? null : new Date(resultSet.getTimestamp(4).getTime()),
                    resultSet.getTimestamp(5)== null ? null : new Date(resultSet.getTimestamp(5).getTime()),
                    resultSet.getTimestamp(6)== null ? null : new Date(resultSet.getTimestamp(6).getTime()),
                    resultSet.getTimestamp(7)== null ? null : new Date(resultSet.getTimestamp(7).getTime()),
                    resultSet.getTimestamp(8)== null ? null : new Date(resultSet.getTimestamp(8).getTime()),
                    resultSet.getTimestamp(9)== null ? null : new Date(resultSet.getTimestamp(9).getTime()),
                    resultSet.getTimestamp(10)== null ? null :new Date(resultSet.getTimestamp(10).getTime()),
                    resultSet.getLong(11),
                    resultSet.getLong(12),
                    resultSet.getLong(13),
                    resultSet.getLong(14),
                    resultSet.getLong(15)
            ));
        }
        return list;
    }

    public static Long getGoOutAmount (Integer userId) throws SQLException, ParseException, ClassNotFoundException {
        return findByUserIdAndCheckIn(userId, DateUtils.today()).getGoOutAmount();
    }

    public static Integer goInTimes (Integer userId) throws SQLException, ParseException, ClassNotFoundException {
        CheckInEntity checkIn = findByUserIdAndCheckIn(userId, DateUtils.today());
        if (checkIn.getGoIn1() == null) return 0;
        if (checkIn.getGoIn2() == null) return 1;
        if (checkIn.getGoIn3() == null) return 2;
        return 3;
    }

    public static void reCheckIn(Integer userId) throws SQLException {
        connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement();
        statement.execute(String.format("INSERT INTO TBL_LOGINING values (%d)", userId));
    }
}
