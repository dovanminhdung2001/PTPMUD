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
                JOptionPane.showMessageDialog(null, "Vui lòng nhập đủ các trường");
            } else if (req.getId().length() > 9) {
                JOptionPane.showMessageDialog(null, "Mã nhân viên quá dài");
            } else if (req.getPassword().length() > 100) {
                JOptionPane.showMessageDialog(null, "Mật khẩu quá dài");
            } else {
                try {
                    UserEntity user = UserService.find(Integer.parseInt(req.getId()));
                    if (user == null || !user.getPassword().equals(req.getPassword())) {
                        JOptionPane.showMessageDialog(null, "Sai mã nhân viên hoặc mật khẩu");
                    } else if (UserService.isLogging(user.getId())) {
                        JOptionPane.showMessageDialog(null, "Tài khoản đang đăng nhập ở thiết bị khác");
                    } else {
                        if (CheckInService.findByUserIdAndCheckInToday(user.getId()) == null) {
                            CheckInService.checkIn(user);
                        } else  {
                            CheckInService.reCheckIn(user.getId());
                        }
                        new CheckOutController(user);
                        loginForm.dispatchEvent(new WindowEvent(loginForm, WindowEvent.WINDOW_CLOSING));
                    }
                } catch (Exception exception) {
                    System.out.println(exception);
                    JOptionPane.showMessageDialog(null, "Mã nhân viên phải là số nguyên");
                }
            }
        }
    }
}
