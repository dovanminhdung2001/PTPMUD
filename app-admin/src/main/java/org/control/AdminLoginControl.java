package org.control;

import lombok.SneakyThrows;
import org.model.AdminEntity;
import org.service.AdminService;
import org.utils.EmailUtils;
import org.view.AdminLoginForm;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

public class AdminLoginControl {
    AdminLoginForm adminLoginForm = new AdminLoginForm();

    public AdminLoginControl() {
        adminLoginForm.loginListener(new LoginListener());
        adminLoginForm.changePasswordListener(new ChangePasswordListener());
        adminLoginForm.resetPasswordListener(new ResetPasswordListener());
    }

    class LoginListener implements ActionListener {
        @SneakyThrows
        @Override
        public void actionPerformed(ActionEvent e) {
            AdminEntity req = adminLoginForm.getInfor();
            if (validData(req)) {
                new ManageUserControl();
                adminLoginForm.dispatchEvent(new WindowEvent(adminLoginForm, WindowEvent.WINDOW_CLOSING));
            }
        }

        private boolean validData(AdminEntity req) throws SQLException {
            if (req.getUsername().equals("") || req.getPassword().equals("")) {
                JOptionPane.showMessageDialog(null, "Please username and password");
                return false;
            }
            if (req.getUsername().length() > 100) {
                JOptionPane.showMessageDialog(null, "Too long username");
                return false;
            }
            if (req.getPassword().length() > 100) {
                JOptionPane.showMessageDialog(null, "Too long password");
                return false;
            }
            if (AdminService.find(req) == null) {
                JOptionPane.showMessageDialog(null, "Wrong username - password");
                return false;
            }
            return true;
        }
    }

    class ChangePasswordListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            new ChangePasswordControl();
            adminLoginForm.dispatchEvent(new WindowEvent(adminLoginForm, WindowEvent.WINDOW_CLOSING));
        }
    }

    class ResetPasswordListener implements ActionListener {
        @SneakyThrows
        @Override
        public void actionPerformed(ActionEvent e) {
            adminLoginForm.disableResetBtn();
            String newPassword = String.valueOf((int) (Math.random() * 10000000));
            AdminService.changePassword(newPassword);
            EmailUtils.sendEmailNewPassword(newPassword);
            JOptionPane.showMessageDialog(null, "Password changed, please check your email");
        }
    }
}
