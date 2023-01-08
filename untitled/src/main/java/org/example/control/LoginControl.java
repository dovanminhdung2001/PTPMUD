package org.example.control;

import org.example.model.UserEntity;
import org.example.model.req.LoginReq;
import org.example.service.CheckInService;
import org.example.service.UserService;
import org.example.view.LoginForm;

import javax.swing.*;
import java.awt.event.*;

public class LoginControl {
    LoginForm loginForm = new LoginForm();

    public LoginControl() {
        loginForm.seePasswordListener(new SeePasswordListener());
        loginForm.unSeePasswordListener(new UnSeePasswordListener());
        loginForm.exitListener(new ExitListener());
        loginForm.loginListener(new LoginListener());
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
        @Override
        public void actionPerformed(ActionEvent e) {
            LoginReq req = loginForm.getInfor();
            if (req.getId().equals("") || req.getPassword().equals("")) {
                JOptionPane.showMessageDialog(null, "please enter id and password");
            } else if (req.getId().length() > 10) {
                JOptionPane.showMessageDialog(null, "id too long");
            } else if (req.getPassword().length() > 100) {
                JOptionPane.showMessageDialog(null, "password too long");
            } else {
                try {
                    UserEntity user = UserService.find(Integer.parseInt(req.getId()));
                    if (user == null || !user.getPassword().equals(req.getPassword())) {
                        JOptionPane.showMessageDialog(null, "id or password is wrong");
                    } else if (UserService.isLogging(user.getId())) {
                        JOptionPane.showMessageDialog(null, "this account is logging in other device");
                    } else {
                        if (CheckInService.findByUserIdAndCheckInToday(user.getId()) == null)
                            CheckInService.checkIn(user);
                        new CheckOutController(user);
                        loginForm.dispatchEvent(new WindowEvent(loginForm, WindowEvent.WINDOW_CLOSING));
                    }
                } catch (Exception exception) {
                    System.out.println(exception);
                    JOptionPane.showMessageDialog(null, "id must be integer");
                }
            }
        }
    }
}
