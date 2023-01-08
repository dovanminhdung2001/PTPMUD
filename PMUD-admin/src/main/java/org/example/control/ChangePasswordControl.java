package org.example.control;

import lombok.SneakyThrows;
import org.example.model.AdminEntity;
import org.example.model.req.ChangePasswordReq;
import org.example.service.AdminService;
import org.example.view.ChangePasswordForm;

import javax.swing.*;
import java.awt.event.*;
import java.sql.SQLException;

public class ChangePasswordControl {
    public ChangePasswordForm changePasswordForm = new ChangePasswordForm();

    public ChangePasswordControl() {
        changePasswordForm.changePasswordListener(new ChangePasswordListener());
        changePasswordForm.exitListener(new ExitListener());
    }

    class ChangePasswordListener implements ActionListener {
        @SneakyThrows
        @Override
        public void actionPerformed(ActionEvent e) {
            ChangePasswordReq req = changePasswordForm.getInfor();
            validReq(req);
        }


        private void validReq(ChangePasswordReq req) throws SQLException {
            if (req.getOldPass().equals("") || req.getNewPass().equals("") || req.getRepeat().equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter all information");
                return ;
            }
            if (req.getNewPass().length() > 100) {
                JOptionPane.showMessageDialog(null, "New password is too long");
                return  ;
            }
            if (!req.getRepeat().equals(req.getNewPass())) {
                JOptionPane.showMessageDialog(null, "Repeat incorrect");
                return  ;
            }
            if (req.getOldPass().length() > 100 || req.getRepeat().length() > 100) {
                JOptionPane.showMessageDialog(null, "Input too long");
                return  ;
            }
            AdminEntity admin = AdminService.find(new AdminEntity("addz", req.getOldPass()));
            if (admin == null) {
                JOptionPane.showMessageDialog(null, "Wrong password");
                return  ;
            }
            AdminService.changePassword(req.getNewPass());
            JOptionPane.showMessageDialog(null, "Success");
        }
    }

    class ExitListener extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            changePasswordForm.dispatchEvent(new WindowEvent(changePasswordForm, WindowEvent.WINDOW_CLOSING));
        }
    }
}
