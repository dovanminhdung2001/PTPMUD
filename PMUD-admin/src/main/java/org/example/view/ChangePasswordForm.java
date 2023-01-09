package org.example.view;

import org.example.model.req.ChangePasswordReq;
import org.example.netbean.AbsoluteConstraints;
import org.example.netbean.AbsoluteLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.WindowAdapter;

public class ChangePasswordForm extends JFrame {

    private JPanel panelLeft = new JPanel();
    private JPanel panelRight = new JPanel();
    private JLabel imageLbl = new JLabel();
    private JLabel exitLbl = new JLabel();
    private JLabel changePasswordLbl = new JLabel();
    private JLabel usernameLbl = new JLabel();
    private JTextField usernameTxt = new JTextField();
    private JLabel usernameIconLbl = new JLabel();
    private JLabel _usernameLbl = new JLabel();
    private JLabel passwordLbl = new JLabel();
    private JTextField passwordTxt = new JTextField();
    private JLabel passwordIconLbl = new JLabel();
    private JLabel _passwordLbl = new JLabel();
    private JLabel confirmLbl = new JLabel();
    private JTextField confirmTxt = new JTextField();
    private JLabel confirmIconLbl = new JLabel();
    private JLabel _confirmLbl = new JLabel();
    private JButton changeBtn = new JButton();

    public ChangePasswordForm() throws HeadlessException {
        setTitle("Đổi mật khẩu");
        getContentPane().setLayout(new AbsoluteLayout());
        setUndecorated(true);

        panelLeft.setBackground(new Color(255, 255, 255));
        panelLeft.setLayout(new AbsoluteLayout());

        panelRight.setBackground(new Color(25, 118, 211));
        panelRight.setLayout(new AbsoluteLayout());

        imageLbl.setIcon(new ImageIcon("src/main/java/org/example/icon/bg-login.png")); // NOI18N
        panelLeft.add(imageLbl, new AbsoluteConstraints(0, 35, 500, 340));

        exitLbl.setForeground(new Color(255, 255, 255));
        exitLbl.setHorizontalAlignment(SwingConstants.CENTER);
        exitLbl.setText("X");
        exitLbl.setCursor(new Cursor(Cursor.HAND_CURSOR));
        panelRight.add(exitLbl, new AbsoluteConstraints(380, 0, 40, 29));

        changePasswordLbl.setFont(new Font("Segoe UI", 0, 32)); // NOI18N
        changePasswordLbl.setForeground(new Color(255, 255, 255));
        changePasswordLbl.setHorizontalAlignment(SwingConstants.CENTER);
        changePasswordLbl.setText("Đổi mật khẩu");
        panelRight.add(changePasswordLbl, new AbsoluteConstraints(0, 47, 420, 41));

        usernameLbl.setFont(new Font("Segoe UI", 0, 13)); // NOI18N
        usernameLbl.setForeground(new Color(199, 226, 255));
        usernameLbl.setText("Mật khẩu cũ");
        panelRight.add(usernameLbl, new AbsoluteConstraints(30, 120, 341, -1));

        confirmTxt.setFont(confirmTxt.getFont().deriveFont(confirmTxt.getFont().getSize()+2f));
        confirmTxt.setForeground(new Color(51, 51, 51));
        confirmTxt.setBorder(null);
        panelRight.add(confirmTxt, new AbsoluteConstraints(40, 280, 240, 30));

        usernameIconLbl.setHorizontalAlignment(SwingConstants.CENTER);
        usernameIconLbl.setIcon(new ImageIcon(("src/main/java/org/example/icon/9.png"))); // NOI18N
        panelRight.add(usernameIconLbl, new AbsoluteConstraints(330, 130, 40, 39));

        _confirmLbl.setForeground(new Color(255, 255, 255));
        _confirmLbl.setText("_________________________________________");
        panelRight.add(_confirmLbl, new AbsoluteConstraints(30, 290, 290, 39));

        _passwordLbl.setForeground(new Color(255, 255, 255));
        _passwordLbl.setText("_________________________________________");
        panelRight.add(_passwordLbl, new AbsoluteConstraints(30, 220, 290, 40));

        confirmIconLbl.setHorizontalAlignment(SwingConstants.CENTER);
        confirmIconLbl.setIcon(new ImageIcon(("src/main/java/org/example/icon/password.png"))); // NOI18N
        confirmIconLbl.setCursor(new Cursor(Cursor.HAND_CURSOR)); 
        panelRight.add(confirmIconLbl, new AbsoluteConstraints(330, 280, 40, 40));

        confirmLbl.setFont(new Font("Segoe UI", 0, 13)); // NOI18N
        confirmLbl.setForeground(new Color(199, 226, 255));
        confirmLbl.setText("Nhập lại");
        panelRight.add(confirmLbl, new AbsoluteConstraints(30, 260, 341, -1));

        usernameTxt.setFont(usernameTxt.getFont().deriveFont(usernameTxt.getFont().getSize()+2f));
        usernameTxt.setForeground(new Color(51, 51, 51));
        usernameTxt.setBorder(null);
        panelRight.add(usernameTxt, new AbsoluteConstraints(39, 140, 240, 30));

        passwordTxt.setFont(passwordTxt.getFont().deriveFont(passwordTxt.getFont().getSize()+2f));
        passwordTxt.setForeground(new Color(51, 51, 51));
        passwordTxt.setBorder(null);
        panelRight.add(passwordTxt, new AbsoluteConstraints(40, 210, 240, 30));

        _usernameLbl.setForeground(new Color(255, 255, 255));
        _usernameLbl.setText("_________________________________________");
        panelRight.add(_usernameLbl, new AbsoluteConstraints(30, 150, 290, 39));

        passwordIconLbl.setHorizontalAlignment(SwingConstants.CENTER);
        passwordIconLbl.setIcon(new ImageIcon(("src/main/java/org/example/icon/confirm-lock-4318470-3594591.png"))); // NOI18N
        passwordIconLbl.setCursor(new Cursor(Cursor.HAND_CURSOR));
        panelRight.add(passwordIconLbl, new AbsoluteConstraints(330, 200, 40, 40));

        passwordLbl.setFont(new Font("Segoe UI", 0, 13)); // NOI18N
        passwordLbl.setForeground(new Color(199, 226, 255));
        passwordLbl.setText("Mật khẩu mới");
        panelRight.add(passwordLbl, new AbsoluteConstraints(30, 190, 341, -1));

        changeBtn.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
        changeBtn.setForeground(new Color(25, 118, 211));
        changeBtn.setText("Đổi mật khẩu");
        changeBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        panelRight.add(changeBtn, new AbsoluteConstraints(40, 350, 341, 40));
        
        getContentPane().add(panelRight, new AbsoluteConstraints(500, 0, 420, 440));
        getContentPane().add(panelLeft, new AbsoluteConstraints(0, 0, 500, 440));

        setSize(916, 438);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public ChangePasswordReq getInfor() {
        return new ChangePasswordReq(
            usernameTxt.getText(),
            passwordTxt.getText(),
            confirmTxt.getText()
        );
    }

    public void changePasswordListener (ActionListener actionListener) {
        changeBtn.addActionListener(actionListener);
    }

    public void exitListener(MouseAdapter adapter) {
        exitLbl.addMouseListener(adapter);
    }
    public void exitListener(WindowAdapter windowAdapter) {
        this.addWindowListener(windowAdapter);
    }
}
