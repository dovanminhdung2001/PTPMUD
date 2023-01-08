package org.example;

import org.example.control.*;
import org.example.view.*;

import java.sql.SQLException;
import java.text.ParseException;

public class App {
    public static void main( String[] args ) throws SQLException, ParseException {
        new ManageCheckInControl();
//        new LoginControl();
//        new ChangePasswordControl();
    }
}
