package org.example.view;

import org.example.model.UserEntity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;

public class AddUserForm extends JFrame{
    private JPanel panelCenter = new JPanel(new GridLayout(3, 1, 10, 10));
    private JPanel panelLeft = new JPanel(new GridLayout(3, 1, 10, 10));
    private JPanel panelBottom = new JPanel(new FlowLayout());
    private JLabel passwordLbl = (JLabel) panelLeft.add("", new JLabel("Mật khẩu" ));
    private JLabel fullNameLbl = (JLabel) panelLeft.add("", new JLabel("Tên đầy đủ" + " "));
    private JLabel phoneLbl = (JLabel)  panelLeft.add("", new JLabel("SĐT"));
    private JTextField passwordTxt = (JTextField) panelCenter.add("", new JTextField());
    private JTextField fullNameTxt = (JTextField) panelCenter.add("", new JTextField());
    private JTextField phoneTxt = (JTextField) panelCenter.add("", new JTextField());
    private JButton addBtn = (JButton) panelBottom.add("", new JButton("Thêm"));

    public AddUserForm() throws HeadlessException {
        this.setTitle("Thêm nhân viên");
        this.setSize(300, 200);
        this.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width  - this.getSize().width) / 2, (Toolkit.getDefaultToolkit().getScreenSize().height - this.getSize().height) / 2);

        panelBottom.add(new JLabel("       " + "       "), 0);

        this.add(panelLeft, BorderLayout.WEST);
        this.add(panelCenter, BorderLayout.CENTER);
        this.add(panelBottom, BorderLayout.SOUTH);

        this.setVisible(true);
    }

    public UserEntity getInfor() {
        return new UserEntity(
                null,
                passwordTxt.getText(),
                fullNameTxt.getText(),
                phoneTxt.getText()
        );
    }

    public void addListener(ActionListener listener) {
        addBtn.addActionListener(listener);
    }

    public void exitListener(WindowAdapter windowAdapter) {
        this.addWindowListener(windowAdapter);
    }
}
