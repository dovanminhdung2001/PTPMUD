package org.example.service;

import org.example.model.CheckInEntity;
import org.example.model.dto.CheckInDTO;
import org.example.model.req.FilterCheckinReq;
import org.example.utils.DateUtils;

import java.sql.*;
import java.text.ParseException;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CheckInService {
    private static final String url = "jdbc:mysql://localhost:3306/ptpmud";
    private static final String username = "root";
    private static final String password = "1";
    private static Connection connection;

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

    public static List<CheckInDTO> findByUserIdAndCheckInBetween (FilterCheckinReq req) throws SQLException, ParseException {
        connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement();
        String sql;

        if (req.getFrom().equals("") && req.getTo().equals("") && req.getId().equals("")) {
            sql = String.format("select tu.full_name , tc.* from tbl_user tu, tbl_checkin tc where tu.id = tc.user_id and tc.checkin > '%s' and tc.checkin < '%s'",
                    DateUtils.todayStr(), DateUtils.tomorrowStr()
            );
            return listDto(statement, sql);
        }

        if (!req.getFrom().equals("") && !req.getTo().equals("")) {
            StringBuffer stringBuffer = new StringBuffer("select tu.full_name , tc.* from tbl_user tu, tbl_checkin tc where tu.id = tc.user_id and tc.checkin > '");
            stringBuffer.append(req.getFrom()).append("' and tc.checkin < '"). append(req.getTo());
            sql = req.getId().equals("")
                    ? stringBuffer.append("'").toString()
                    : stringBuffer.append("' and tu.id = ").append(req.getId()).toString();
            sql += " order by tc.checkin , tc.user_id";
            return listDto(statement, sql);
        } else {
            sql = String.format("select tu.full_name , tc.* from tbl_user tu, tbl_checkin tc where tu.id = tc.user_id and tu.id = %s order by tc.checkin", req.getId());
            return listDto(statement, sql);
        }
    }

    private static List<CheckInDTO> listDto  (Statement statement, String sql) throws SQLException {
        ArrayList<CheckInDTO> list = new ArrayList<>();
        ResultSet resultSet;
        statement.execute(sql);
        resultSet = statement.getResultSet();
        while (resultSet.next()) {
            CheckInEntity checkIn = new CheckInEntity(
                    resultSet.getInt(2),
                    resultSet.getInt(3),
                    resultSet.getTimestamp(4)== null ? null : new Date(resultSet.getTimestamp(4).getTime()),
                    resultSet.getTimestamp(5)== null ? null : new Date(resultSet.getTimestamp(5).getTime()),
                    resultSet.getTimestamp(6)== null ? null : new Date(resultSet.getTimestamp(6).getTime()),
                    resultSet.getTimestamp(7)== null ? null : new Date(resultSet.getTimestamp(7).getTime()),
                    resultSet.getTimestamp(8)== null ? null : new Date(resultSet.getTimestamp(8).getTime()),
                    resultSet.getTimestamp(9)== null ? null : new Date(resultSet.getTimestamp(9).getTime()),
                    resultSet.getTimestamp(10)== null ? null : new Date(resultSet.getTimestamp(10).getTime()),
                    resultSet.getTimestamp(11)== null ? null : new Date(resultSet.getTimestamp(11).getTime()),
                    resultSet.getLong(12),
                    resultSet.getLong(13),
                    resultSet.getLong(14),
                    resultSet.getLong(15),
                    resultSet.getLong(16)
            );
            list.add(
                    new CheckInDTO(
                            checkIn.getUserId(),
                            resultSet.getString(1),
                            DateUtils.sdtf.format(checkIn.getCheckin()),
                            checkIn.getGoOut1() == null ? "" : DateUtils.stf.format(checkIn.getGoOut1()),
                            checkIn.getGoIn1() == null ? "" : DateUtils.stf.format(checkIn.getGoIn1()),
                            checkIn.getGoOut2() == null ? "" : DateUtils.stf.format(checkIn.getGoOut2()),
                            checkIn.getGoIn2() == null ? "" : DateUtils.stf.format(checkIn.getGoIn2()),
                            checkIn.getGoOut3() == null ? "" : DateUtils.stf.format(checkIn.getGoOut3()),
                            checkIn.getGoIn3() == null ? "" : DateUtils.stf.format(checkIn.getGoIn3()),
                            checkIn.getCheckout() == null ? "" : DateUtils.sdtf.format(checkIn.getCheckout()),
                            DateUtils.secondToHms(checkIn.getCheckinLate()),
                            DateUtils.secondToHms(checkIn.getCheckoutEarly()),
                            checkIn.goOutTimes(),
                            checkIn.totalGoOutStr(),
                            checkIn.totalWorkStr()
                    )
            );
        }
        return list;
    }

}
