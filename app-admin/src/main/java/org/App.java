package org;

import org.control.*;
import org.utils.DateUtils;
import org.view.*;

import java.sql.SQLException;
import java.text.ParseException;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) throws ParseException, SQLException, ClassNotFoundException {
//        new ManageUserControl();
//        new AddUserControl();
//        new AdminLoginControl();
        new ManageCheckinControl();
    }
}
