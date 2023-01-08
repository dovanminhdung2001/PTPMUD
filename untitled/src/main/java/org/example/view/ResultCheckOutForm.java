package org.example.view;

import org.example.model.CheckInEntity;
import org.example.netbean.AbsoluteConstraints;
import org.example.netbean.AbsoluteLayout;
import org.example.utils.DateUtils;

import javax.swing.*;
import java.util.Date;

public class ResultCheckOutForm extends JFrame {
    private JLabel CheckoutEarly1 = new JLabel();
    private JLabel CheckoutEarlyLbl = new JLabel();
    private JPanel CheckoutEarlyPanel = new JPanel();
    private JPanel centerPanel = new JPanel();
    private JLabel checkinAt1 = new JLabel();
    private JLabel checkinAtLbl = new JLabel();
    private JPanel checkinAtPanel = new JPanel();
    private JLabel checkinLate1 = new JLabel();
    private JLabel checkinLateLbl = new JLabel();
    private JPanel checkinLatePanel = new JPanel();
    private JPanel checkoutAtPanel = new JPanel();
    private JLabel checkoutAt1 = new JLabel();
    private JLabel checkoutAtLbl = new JLabel();
    private JLabel goOut1 = new JLabel();
    private JPanel goOutPanel = new JPanel();
    private JLabel goOutTimesLbl = new JLabel();
    private JLabel id1 = new JLabel();
    private JLabel idLbl = new JLabel();
    private JPanel idPanel = new JPanel();
    private JLabel exitLbl = new JLabel();
    private JLabel time1 = new JLabel();
    private JLabel totalGoOutTime1 = new JLabel();
    private JLabel totalGoOutTimeLbl = new JLabel();
    private JPanel totalGoOutTimePanel = new JPanel();
    private JLabel totalWorkTime1 = new JLabel();
    private JLabel totalWorkTimeLbl = new JLabel();
    private JPanel totalWorkTimePanel = new JPanel();
    public ResultCheckOutForm(CheckInEntity checkIn){ 

         setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
         getContentPane().setLayout(new AbsoluteLayout());

         centerPanel.setLayout(new AbsoluteLayout());

         checkinAtPanel.setBackground(new java.awt.Color(159, 121, 238));
         checkinAtPanel.setLayout(new AbsoluteLayout());

         checkinAt1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
         checkinAt1.setForeground(new java.awt.Color(255, 255, 255));
         checkinAt1.setText("Checkin:");
         checkinAtPanel.add(checkinAt1, new AbsoluteConstraints(18, 14, -1, -1));

         checkinAtLbl.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
         checkinAtLbl.setForeground(new java.awt.Color(255, 255, 255));
         checkinAtLbl.setText(DateUtils.sdtf.format(checkIn.getCheckin()));
         checkinAtPanel.add(checkinAtLbl, new AbsoluteConstraints(30, 80, -1, -1));

         centerPanel.add(checkinAtPanel, new AbsoluteConstraints(230, 10, 290, 130));

         checkoutAtPanel.setBackground(new java.awt.Color(102, 205, 0));
         checkoutAtPanel.setLayout(new AbsoluteLayout());

         checkoutAt1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
         checkoutAt1.setForeground(new java.awt.Color(255, 255, 255));
         checkoutAt1.setText("Checkout:");
         checkoutAtPanel.add(checkoutAt1, new AbsoluteConstraints(18, 14, -1, -1));

         checkoutAtLbl.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
         checkoutAtLbl.setForeground(new java.awt.Color(255, 255, 255));
         checkoutAtLbl.setText(DateUtils.sdtf.format(checkIn.getCheckout()));
         checkoutAtPanel.add(checkoutAtLbl, new AbsoluteConstraints(24, 80, -1, -1));

         centerPanel.add(checkoutAtPanel, new AbsoluteConstraints(530, 10, 300, 130));

         totalWorkTimePanel.setBackground(new java.awt.Color(0, 191, 255));
         totalWorkTimePanel.setLayout(new AbsoluteLayout());

         totalWorkTime1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
         totalWorkTime1.setForeground(new java.awt.Color(255, 255, 255));
         totalWorkTime1.setText("Thời gian làm:");
         totalWorkTimePanel.add(totalWorkTime1, new AbsoluteConstraints(18, 14, -1, -1));

         totalWorkTimeLbl.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
         totalWorkTimeLbl.setForeground(new java.awt.Color(255, 255, 255));
         totalWorkTimeLbl.setText(checkIn.totalWorkStr());
         totalWorkTimePanel.add(totalWorkTimeLbl, new AbsoluteConstraints(254, 80, -1, -1));

         centerPanel.add(totalWorkTimePanel, new AbsoluteConstraints(0, 290, 370, 130));

         totalGoOutTimePanel.setBackground(new java.awt.Color(224, 102, 225));
         totalGoOutTimePanel.setLayout(new AbsoluteLayout());

         totalGoOutTime1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
         totalGoOutTime1.setForeground(new java.awt.Color(255, 255, 255));
         totalGoOutTime1.setText("Thời gian ra ngoài:");
         totalGoOutTimePanel.add(totalGoOutTime1, new AbsoluteConstraints(18, 14, -1, -1));

         totalGoOutTimeLbl.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
         totalGoOutTimeLbl.setForeground(new java.awt.Color(255, 255, 255));
         totalGoOutTimeLbl.setText(checkIn.totalGoOutStr());
         totalGoOutTimePanel.add(totalGoOutTimeLbl, new AbsoluteConstraints(350, 80, -1, -1));

         centerPanel.add(totalGoOutTimePanel, new AbsoluteConstraints(380, 290, 450, 130));

         goOutPanel.setBackground(new java.awt.Color(255, 105, 180));
         goOutPanel.setLayout(new AbsoluteLayout());

         goOut1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
         goOut1.setForeground(new java.awt.Color(255, 255, 255));
         goOut1.setText("Số lần ra");
         goOutPanel.add(goOut1, new AbsoluteConstraints(18, 14, -1, 50));

         goOutTimesLbl.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
         goOutTimesLbl.setForeground(new java.awt.Color(255, 255, 255));
         goOutTimesLbl.setText("ngoài:");
         goOutPanel.add(goOutTimesLbl, new AbsoluteConstraints(20, 70, -1, -1));

         time1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
         time1.setForeground(new java.awt.Color(255, 255, 255));
         time1.setText(String.valueOf(checkIn.getGoOutAmount()));
         goOutPanel.add(time1, new AbsoluteConstraints(180, 80, 20, -1));

         centerPanel.add(goOutPanel, new AbsoluteConstraints(0, 150, 220, 134));

         checkinLatePanel.setBackground(new java.awt.Color(238, 118, 33));
         checkinLatePanel.setLayout(new AbsoluteLayout());

         checkinLateLbl.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
         checkinLateLbl.setForeground(new java.awt.Color(255, 255, 255));
         checkinLateLbl.setText(DateUtils.secondToHms(checkIn.getCheckinLate()));
         checkinLatePanel.add(checkinLateLbl, new AbsoluteConstraints(170, 80, -1, -1));

         checkinLate1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
         checkinLate1.setForeground(new java.awt.Color(255, 255, 255));
         checkinLate1.setText("Checkin muộn:");
         checkinLatePanel.add(checkinLate1, new AbsoluteConstraints(18, 14, -1, -1));

         centerPanel.add(checkinLatePanel, new AbsoluteConstraints(230, 150, 290, 134));

         CheckoutEarlyPanel.setBackground(new java.awt.Color(0, 191, 255));
         CheckoutEarlyPanel.setLayout(new AbsoluteLayout());

         CheckoutEarly1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
         CheckoutEarly1.setForeground(new java.awt.Color(255, 255, 255));
         CheckoutEarly1.setText("Checkout sớm:");
         CheckoutEarlyPanel.add(CheckoutEarly1, new AbsoluteConstraints(18, 14, -1, -1));

         CheckoutEarlyLbl.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
         CheckoutEarlyLbl.setForeground(new java.awt.Color(255, 255, 255));
         CheckoutEarlyLbl.setText(DateUtils.secondToHms(checkIn.getCheckoutEarly()));
         CheckoutEarlyPanel.add(CheckoutEarlyLbl, new AbsoluteConstraints(200, 90, -1, -1));

         centerPanel.add(CheckoutEarlyPanel, new AbsoluteConstraints(530, 150, 300, 134));

         idPanel.setBackground(new java.awt.Color(0, 191, 255));
         idPanel.setPreferredSize(new java.awt.Dimension(70, 134));
         idPanel.setLayout(new AbsoluteLayout());

         id1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
         id1.setForeground(new java.awt.Color(255, 255, 255));
         id1.setText("Mã:");
         idPanel.add(id1, new AbsoluteConstraints(18, 14, -1, -1));

         idLbl.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
         idLbl.setForeground(new java.awt.Color(255, 255, 255));
         idLbl.setText("02");
         idPanel.add(idLbl, new AbsoluteConstraints(170, 80, -1, -1));

         centerPanel.add(idPanel, new AbsoluteConstraints(0, 10, 220, 130));

         getContentPane().add(centerPanel, new AbsoluteConstraints(0, 5, -1, 460));

         setSize(850, 468);
         setLocationRelativeTo(null);
         setVisible(true);
   }
}
