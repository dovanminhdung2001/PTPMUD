package org.example;

import org.example.controller.CheckInController;
import org.example.model.AdminEntity;
import org.example.model.CheckInEntity;
import org.example.service.CheckInService;
import org.example.utils.DateUtils;
import org.example.view.AdminLoginForm;
import org.example.view.CheckInForm;
import org.example.view.CheckOutForm;
import org.example.view.ResultCheckOutForm;

import java.sql.*;
import java.text.ParseException;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class App {
    private static final String url = "jdbc:mysql://localhost:3306/ptpmud";
    private static final String username = "root";
    private static final String password = "1";
    private static Connection connection;

    public static void main( String[] args ) throws ParseException {

        CheckInController checkInController = new CheckInController();
////        new ResultCheckOutForm(new CheckInEntity(1, 1, new Date(),new Date(),new Date(), null, null, null, null, new Date()));
////        System.out.println(new Date(10000));
//        System.out.println(DateUtils.today());
    }
}
