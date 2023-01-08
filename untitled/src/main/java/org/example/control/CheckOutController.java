package org.example.control;

import lombok.SneakyThrows;
import org.example.model.CheckInEntity;
import org.example.model.UserEntity;
import org.example.service.CheckInService;
import org.example.view.CheckOutForm;
import org.example.view.ResultCheckOutForm;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;

public class CheckOutController {
    CheckOutForm checkOutForm = new CheckOutForm();
    CheckInEntity checkIn;

    UserEntity userInfor;
    public CheckOutController(UserEntity user) throws SQLException, ParseException, ClassNotFoundException {
        checkOutForm.setGoOutListener(new GoOutListener());
        checkOutForm.setGoInListener(new GoInListener());
        checkOutForm.setCheckoutListener(new CheckoutListener());

        userInfor = user;
        checkOutForm.setInforLbl(user);
        checkIn = CheckInService.findByUserIdAndCheckInToday(user.getId());
        checkOutForm.setCheckinAtLbl(checkIn.getCheckin());
        int goInTimes = checkIn.goInTimes();
        int goOutTimes = checkIn.goOutTimes();
        if (checkIn.getCheckout() != null) {
            checkOutForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            checkOutForm.goOutBtn.setEnabled(false);
            checkOutForm.goInBtn.setEnabled(false);
            checkOutForm.checkoutBtn.setEnabled(false);
        } else if (goInTimes == 3 && goOutTimes == 3) {
            checkOutForm.goOutBtn.setEnabled(false);
            checkOutForm.goInBtn.setEnabled(false);
            checkOutForm.checkoutBtn.setEnabled(true);
        } else if (goInTimes == goOutTimes) {
            checkOutForm.goOutBtn.setEnabled(true);
            checkOutForm.goInBtn.setEnabled(false);
            checkOutForm.checkoutBtn.setEnabled(true);
        } else if (goInTimes < goOutTimes) {
            checkOutForm.goOutBtn.setEnabled(false);
            checkOutForm.goInBtn.setEnabled(true);
            checkOutForm.checkoutBtn.setEnabled(false);
        }
    }

    class GoOutListener implements ActionListener {
        @SneakyThrows
        @Override
        public void actionPerformed(ActionEvent e) {
            CheckInService.goOut(userInfor.getId());
            checkOutForm.goOutBtn.setEnabled(false);
            checkOutForm.goInBtn.setEnabled(true);
            checkOutForm.checkoutBtn.setEnabled(false);
        }
    }

    class GoInListener implements ActionListener {
        @SneakyThrows
        @Override
        public void actionPerformed(ActionEvent e) {
            CheckInService.goIn(userInfor.getId());
            checkIn = CheckInService.findByUserIdAndCheckInToday(userInfor.getId());
            checkOutForm.goInBtn.setEnabled(false);
            if (checkIn.goOutTimes() == 3) {
                checkOutForm.goOutBtn.setEnabled(false);
                checkOutForm.checkoutBtn.setEnabled(checkIn.getCheckout() == null);
            } else {
                checkOutForm.goOutBtn.setEnabled(true);
                checkOutForm.checkoutBtn.setEnabled(checkIn.getCheckout() == null);
            }
        }
    }

    class CheckoutListener implements ActionListener {
        @SneakyThrows
        @Override
        public void actionPerformed(ActionEvent e) {
            checkOutForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            CheckInService.checkOut(userInfor.getId());
            checkOutForm.goInBtn.setEnabled(false);
            checkOutForm.goOutBtn.setEnabled(false);
            checkOutForm.checkoutBtn.setEnabled(false);
            new ResultCheckOutForm(CheckInService.findByUserIdAndCheckInToday(checkIn.getUserId()));
        }
    }
}
