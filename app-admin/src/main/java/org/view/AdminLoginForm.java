package org.view;

import org.model.AdminEntity;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionListener;

public class AdminLoginForm extends JFrame {
    private JPanel panelCenter = new JPanel(new GridLayout(3, 1, 10, 10));
    private JPanel panelLeft = new JPanel(new GridLayout(3, 1, 10, 10));
    private JPanel panelBottom = new JPanel(new FlowLayout());
    private JLabel usernameLbl = (JLabel) panelLeft.add("",new JLabel("  " + "Username" + "  "));
    private JLabel passwordLbl = (JLabel) panelLeft.add("",new JLabel("  " + "Password" + "  "));
    private JTextField usernameTxt = (JTextField) panelCenter.add("", new JTextField());
    private JPasswordField passwordTxt = (JPasswordField) panelCenter.add("", new JPasswordField());
    private JButton loginBtn = (JButton) panelBottom.add("", new JButton("     " + "Login" + "     "));
    private JButton changePassword = (JButton) panelBottom.add("", new JButton("Change pass"));
    private JButton resetPassword = (JButton) panelBottom.add("", new JButton(" " + "Reset pass" + " "));

    public AdminLoginForm() throws HeadlessException {
        this.setTitle("Admin login");
        this.setSize(350, 200);
        this.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width  - this.getSize().width) / 2, (Toolkit.getDefaultToolkit().getScreenSize().height - this.getSize().height) / 2);

        panelLeft.add(new JLabel());

        this.add(panelLeft, BorderLayout.WEST);
        this.add(panelCenter, BorderLayout.CENTER);
        this.add(panelBottom, BorderLayout.SOUTH);

        this.setVisible(true);
    }

    public AdminEntity getInfor() {
        return new AdminEntity(usernameTxt.getText(), String.valueOf(passwordTxt.getPassword()));
    }

    public void loginListener(ActionListener listener) {
        loginBtn.addActionListener(listener);
    }

    public void disableResetBtn() {
        resetPassword.setEnabled(false);
    }

    public void changePasswordListener(ActionListener listener) {
        changePassword.addActionListener(listener);
    }

    public void resetPasswordListener(ActionListener listener) {
        resetPassword.addActionListener(listener);
    }
}
