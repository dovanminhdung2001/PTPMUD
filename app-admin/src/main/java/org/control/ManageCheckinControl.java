package org.control;

import lombok.SneakyThrows;
import org.view.ManageCheckinForm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

public class ManageCheckinControl {
    ManageCheckinForm manageCheckinForm = new ManageCheckinForm();


    public ManageCheckinControl() throws SQLException {
        manageCheckinForm.manageUserListener(new ManageUserListener());

    }


    class ManageUserListener implements ActionListener {
        @SneakyThrows
        @Override
        public void actionPerformed(ActionEvent e) {
            new ManageUserControl();
            manageCheckinForm.dispatchEvent(new WindowEvent(manageCheckinForm, WindowEvent.WINDOW_CLOSING));
        }
    }

}
