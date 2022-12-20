package org.example.view;

import org.example.model.AdminEntity;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionListener;

public class AdminLoginForm extends JFrame {
    private JPanel panelCenter = new JPanel(new GridLayout(3, 1, 10, 10));
    private JPanel panelLeft = new JPanel(new GridLayout(3, 1, 10, 10));
    private JLabel usernameLbl = (JLabel) panelLeft.add("",new JLabel("  " + "Username" + "  "));
    private JLabel passwordLbl = (JLabel) panelLeft.add("",new JLabel("  " + "Password" + "  "));
    private JTextField usernameTxt = (JTextField) panelCenter.add("", new JTextField());
    private JPasswordField passwordTxt = (JPasswordField) panelCenter.add("", new JPasswordField());
    private JButton loginBtn = (JButton) panelCenter.add("", new JButton("Login"));

    public AdminLoginForm() throws HeadlessException {
        this.setTitle("Admin login");
        this.setSize(300, 200);
        this.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width  - this.getSize().width) / 2, (Toolkit.getDefaultToolkit().getScreenSize().height - this.getSize().height) / 2);

        panelLeft.add(new JLabel());

        this.add(panelLeft, BorderLayout.WEST);
        this.add(panelCenter, BorderLayout.CENTER);

        this.setVisible(true);
    }

    public AdminEntity getInfor() {
        return new AdminEntity(usernameTxt.getText(), String.valueOf(passwordTxt.getPassword()));
    }

    public void addLoginListener(ActionListener listener) {
        loginBtn.addActionListener(listener);
    }
}
