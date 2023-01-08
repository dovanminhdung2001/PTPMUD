package org.example.control;

import lombok.SneakyThrows;
import org.example.model.AdminEntity;
import org.example.model.UserEntity;
import org.example.service.AdminService;
import org.example.service.CheckInService;
import org.example.service.UserService;
import org.example.utils.EmailUtils;
import org.example.view.LoginForm;

import javax.swing.*;
import java.awt.event.*;
import java.sql.SQLException;

public class LoginControl {
    LoginForm loginForm = new LoginForm();

    public LoginControl() {
        loginForm.seePasswordListener(new SeePasswordListener());
        loginForm.unSeePasswordListener(new UnSeePasswordListener());
        loginForm.exitListener(new ExitListener());
        loginForm.loginListener(new LoginListener());
        loginForm.resetPasswordListener(new ResetPasswordListener());
    }

    class SeePasswordListener extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            loginForm.passwordTxt.setEchoChar((char)0);
            loginForm.seePasswordIconLbl.setVisible(false);
            loginForm.seePasswordIconLbl.setEnabled(false);
            loginForm.unSeePasswordIconLbl.setEnabled(true);
            loginForm.unSeePasswordIconLbl.setEnabled(true);
        }
    }

    class UnSeePasswordListener extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            loginForm.passwordTxt.setEchoChar((char)8226);
            loginForm.seePasswordIconLbl.setVisible(true);
            loginForm.seePasswordIconLbl.setEnabled(true);
            loginForm.unSeePasswordIconLbl.setEnabled(false);
            loginForm.unSeePasswordIconLbl.setEnabled(false);
        }
    }

    class ExitListener extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            System.exit(0);
        }
    }

    class LoginListener implements ActionListener {
        @SneakyThrows
        @Override
        public void actionPerformed(ActionEvent e) {
            AdminEntity req = loginForm.getInfor();
            if (validData(req)) {
                new ManageUserControl();
                loginForm.dispatchEvent(new WindowEvent(loginForm, WindowEvent.WINDOW_CLOSING));
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

    class ResetPasswordListener extends MouseAdapter {
        @SneakyThrows
        @Override
        public void mouseClicked(MouseEvent e) {

            if (! loginForm.sentEmail) {
                String newPassword = String.valueOf((int) (Math.random() * 10000000));
                AdminService.changePassword(newPassword);
                EmailUtils.sendEmailNewPassword(newPassword);
                loginForm.sentEmail = true;
            }
            JOptionPane.showMessageDialog(null, "Đã reset lại, vui lòng kiểm tra email");
        }
    }
}
