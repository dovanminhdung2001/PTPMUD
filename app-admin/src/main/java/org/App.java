package org;

import org.control.AdminLoginControl;
import org.control.ChangePasswordControl;
import org.utils.DateUtils;
import org.view.*;

import java.sql.SQLException;
import java.text.ParseException;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) throws ParseException, SQLException {
//        new AdminLoginForm();
//            new ChangePasswordControl();
        new AdminLoginControl();
    }
}
