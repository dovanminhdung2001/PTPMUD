package org.example.controller;

import lombok.SneakyThrows;
import org.example.model.UserEntity;
import org.example.service.CheckInService;
import org.example.service.UserService;
import org.example.view.CheckInForm;
import org.example.view.CheckOutForm;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class CheckInController {
    CheckInForm checkInForm = new CheckInForm();

    public CheckInController() {
        checkInForm.addCheckinListener(new CheckInListener());
    }

    class CheckInListener implements ActionListener {
        @SneakyThrows
        @Override
        public void actionPerformed(ActionEvent e) {
            String[] infor = checkInForm.getInfor();
            if ("" == (infor[0]) || "".equals(infor[1])) {
                JOptionPane.showMessageDialog(null, "please enter id and password");
            } else {
                try {
                    UserEntity user = UserService.find(Integer.parseInt(infor[0]));
                    if (user == null || !user.getPassword().equals(infor[1])) {
                        JOptionPane.showMessageDialog(null, "id or password is wrong");
                    } else if (UserService.isLogging(user.getId())) {
                        JOptionPane.showMessageDialog(null, "this account is logging in other device");
                    } else {
                        if (CheckInService.findByUserIdAndCheckInToday(user.getId()) == null)
                            CheckInService.checkIn(user);
                        CheckOutController form = new CheckOutController(user);
                        checkInForm.dispatchEvent(new WindowEvent(checkInForm, WindowEvent.WINDOW_CLOSING));
                    }
                } catch (Exception exception) {
                    System.out.println(exception);
                    JOptionPane.showMessageDialog(null, "id must be integer");
                }
            }
        }
    }
}
