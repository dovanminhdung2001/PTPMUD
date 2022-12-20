package org.example;

import org.example.controller.CheckInController;
import org.example.model.AdminEntity;
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
    public static void main( String[] args )   {
//        CheckInController checkInController = new CheckInController();
        CheckInForm checkInForm = new CheckInForm();
        CheckOutForm checkOutForm = new CheckOutForm();
    }
}
