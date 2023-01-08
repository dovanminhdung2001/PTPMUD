package org.example.view;

import org.example.model.AdminEntity;
import org.example.netbean.AbsoluteConstraints;
import org.example.netbean.AbsoluteLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

public class LoginForm extends JFrame {
    private JPanel panelLoginLeft = new JPanel();
    private JPanel panelLoginRight = new JPanel();

    public JLabel leftIconLbl = new JLabel();
    public JLabel _usernameLbl  = new JLabel();
    public JLabel _passwordLbl = new JLabel();
    public JLabel exitLbl = new JLabel();
    public JLabel usernameLbl = new JLabel();
    public JButton loginBtn = new JButton();
    public JLabel loginLbl = new JLabel();
    public JLabel passwordLbl = new JLabel();
    public JPasswordField passwordTxt = new JPasswordField();
    public JLabel seePasswordIconLbl = new JLabel();
    public JLabel unSeePasswordIconLbl = new JLabel();
    public JLabel userIconLbl = new JLabel();
    public JTextField usernameTxt = new JTextField();
    public JLabel forgetLbl = new JLabel();
    public Boolean sentEmail = false;
    public LoginForm() throws HeadlessException {
        setTitle("Đăng nhập");
        setUndecorated(true);
        getContentPane().setLayout(new AbsoluteLayout());

        panelLoginLeft.setBackground(new Color(255, 255, 255));
        panelLoginLeft.setLayout(new AbsoluteLayout());

        panelLoginRight.setBackground(new Color(25, 118, 211));
        panelLoginRight.setLayout(new AbsoluteLayout());

        leftIconLbl.setIcon(new ImageIcon("src/main/java/org/example/icon/bg-login.png")); // NOI18N
        panelLoginLeft.add(leftIconLbl, new AbsoluteConstraints(0, 35, 500, 340));

        exitLbl.setForeground(new Color(255, 255, 255));
        exitLbl.setHorizontalAlignment(SwingConstants.CENTER);
        exitLbl.setText("X");
        exitLbl.setCursor(new Cursor(Cursor.HAND_CURSOR));
        panelLoginRight.add(exitLbl, new AbsoluteConstraints(380, 0, 40, 29));

        loginLbl.setFont(new Font("Segoe UI", 0, 32)); // NOI18N
        loginLbl.setForeground(new Color(255, 255, 255));
        loginLbl.setHorizontalAlignment(SwingConstants.CENTER);
        loginLbl.setText("Đăng nhập");
        panelLoginRight.add(loginLbl, new AbsoluteConstraints(0, 47, 420, 41));

        usernameLbl.setFont(new Font("Segoe UI", 0, 13)); // NOI18N
        usernameLbl.setForeground(new Color(199, 226, 255));
        usernameLbl.setText("Tài khoản");
        panelLoginRight.add(usernameLbl, new AbsoluteConstraints(34, 123, 341, -1));

        usernameTxt.setFont(usernameTxt.getFont().deriveFont(usernameTxt.getFont().getSize()+2f));
//        usernameTxt.setForeground(new java.awt.Color(255, 255, 255));
        usernameTxt.setBorder(null);

        panelLoginRight.add(usernameTxt, new AbsoluteConstraints(39, 140, 240, 30));

        _usernameLbl.setForeground(new Color(255, 255, 255));
        _usernameLbl.setText("_________________________________________");
        panelLoginRight.add(_usernameLbl, new AbsoluteConstraints(34, 147, 290, 39));

        userIconLbl.setHorizontalAlignment(SwingConstants.CENTER);
        userIconLbl.setIcon(new ImageIcon(("src/main/java/org/example/icon/icons8_user_20px_1.png"))); // NOI18N
        panelLoginRight.add(userIconLbl, new AbsoluteConstraints(335, 147, 40, 39));

        passwordLbl.setFont(new Font("Segoe UI", 0, 13)); // NOI18N
        passwordLbl.setForeground(new Color(199, 226, 255));
        passwordLbl.setText("Mật khẩu");
        panelLoginRight.add(passwordLbl, new AbsoluteConstraints(34, 192, 341, -1));

        passwordTxt.setFont(passwordTxt.getFont().deriveFont(passwordTxt.getFont().getSize()+2f));
//        passwordTxt.setForeground(new java.awt.Color(255, 255, 255));
        passwordTxt.setBorder(null);
        passwordTxt.setCaretColor(new Color(255, 255, 255));
        panelLoginRight.add(passwordTxt, new AbsoluteConstraints(40, 210, 240, 30));

        _passwordLbl.setForeground(new Color(255, 255, 255));
        _passwordLbl.setText("_________________________________________");
        panelLoginRight.add(_passwordLbl, new AbsoluteConstraints(34, 216, 290, 40));

        seePasswordIconLbl.setHorizontalAlignment(SwingConstants.CENTER);
        seePasswordIconLbl.setIcon(new ImageIcon(("src/main/java/org/example/icon/icons8_invisible_20px_1.png"))); // NOI18N
        seePasswordIconLbl.setCursor(new Cursor(Cursor.HAND_CURSOR));
        panelLoginRight.add(seePasswordIconLbl, new AbsoluteConstraints(335, 216, 40, 40));

        unSeePasswordIconLbl.setHorizontalAlignment(SwingConstants.CENTER);
        unSeePasswordIconLbl.setIcon(new ImageIcon(("src/main/java/org/example/icon/icons8_eye_20px_1.png"))); // NOI18N
        unSeePasswordIconLbl.setCursor(new Cursor(Cursor.HAND_CURSOR));
        panelLoginRight.add(unSeePasswordIconLbl, new AbsoluteConstraints(335, 216, 40, 40));

        loginBtn.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
        loginBtn.setForeground(new Color(25, 118, 211));
        loginBtn.setText("Đăng nhập");
        loginBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        panelLoginRight.add(loginBtn, new AbsoluteConstraints(34, 306, 341, 40));

        forgetLbl.setFont(new Font("Segoe UI", 2, 12)); // NOI18N
        forgetLbl.setForeground(new Color(255, 255, 255));
        forgetLbl.setText("Quên mật khẩu ?");
        forgetLbl.setCursor(new Cursor(Cursor.HAND_CURSOR));
        panelLoginRight.add(forgetLbl, new AbsoluteConstraints(34, 247, 120, 41));

        getContentPane().add(panelLoginRight, new AbsoluteConstraints(500, 0, 420, 440));
        getContentPane().add(panelLoginLeft, new AbsoluteConstraints(0, 0, 500, 440));

        setSize(new Dimension(916, 438));
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public AdminEntity getInfor () {
        return new AdminEntity(
                usernameTxt.getText(),
                String.valueOf(passwordTxt.getPassword())
        );
    }

    public void seePasswordListener (MouseAdapter adapter) {
        seePasswordIconLbl.addMouseListener(adapter);
    }

    public void unSeePasswordListener (MouseAdapter adapter) {
        unSeePasswordIconLbl.addMouseListener(adapter);
    }

    public void exitListener (MouseAdapter adapter) {
        exitLbl.addMouseListener(adapter);
    }

    public void loginListener (ActionListener listener) {
        loginBtn.addActionListener(listener);
    }

    public void resetPasswordListener (MouseAdapter adapter) {
        forgetLbl.addMouseListener(adapter);
    }
}
