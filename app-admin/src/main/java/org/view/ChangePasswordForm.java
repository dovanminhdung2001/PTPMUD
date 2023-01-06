package org.view;

import org.model.req.ChangePasswordReq;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ChangePasswordForm extends JFrame {
    private JPanel panelCenter = new JPanel(new GridLayout(3, 1, 10, 10));
    private JPanel panelLeft = new JPanel(new GridLayout(3, 1, 10, 10));
    private JPanel panelBottom = new JPanel(new FlowLayout());
    private JLabel oldPassLbl = (JLabel) panelLeft.add("", new JLabel("Old pass" + " "));
    private JLabel newPassLbl = (JLabel) panelLeft.add("", new JLabel("New pass" + " "));
    private JLabel repeatLbl = (JLabel)  panelLeft.add("", new JLabel("Repeat "));
    private JTextField oldPwTxt = (JTextField) panelCenter.add("", new JTextField());
    private JTextField newPwTxt = (JTextField) panelCenter.add("", new JTextField());
    private JTextField rePwTxt = (JTextField) panelCenter.add("", new JTextField());
    private JButton changePasswordBtn = (JButton) panelBottom.add("", new JButton("Change"  ));
    private JButton cancelBtn = (JButton) panelBottom.add(new JButton("Cancel"));
    public ChangePasswordForm() throws HeadlessException {
        this.setTitle("Change password");
        this.setSize(320, 200);
        this.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width  - this.getSize().width) / 2, (Toolkit.getDefaultToolkit().getScreenSize().height - this.getSize().height) / 2);

        panelBottom.add(new JLabel("      " + "      "), 0);

        this.add(panelLeft, BorderLayout.WEST);
        this.add(panelCenter, BorderLayout.CENTER);
        this.add(panelBottom, BorderLayout.SOUTH);

        this.setVisible(true);
    }

    public ChangePasswordReq getChangePasswordReq() {
        return new ChangePasswordReq(
             (oldPwTxt.getText()),
             (newPwTxt.getText()),
             (rePwTxt.getText())
        );
    }

    public void changePasswordListener (ActionListener listener) {
        changePasswordBtn.addActionListener(listener);
    }

    public void cancelListener (ActionListener listener) {
        cancelBtn.addActionListener(listener);
    }
}
