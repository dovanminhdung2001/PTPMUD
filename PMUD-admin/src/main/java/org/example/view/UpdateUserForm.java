package org.example.view;

import org.example.model.UserEntity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;

public class UpdateUserForm extends JFrame {
    private JPanel panelCenter = new JPanel(new GridLayout(4, 1, 10, 10));
    private JPanel panelLeft = new JPanel(new GridLayout(4, 1, 10, 10));
    private JPanel panelBottom = new JPanel(new FlowLayout());
    private JLabel idLbl = (JLabel) panelLeft.add("", new JLabel("Id"));
    private JLabel passwordLbl = (JLabel) panelLeft.add("", new JLabel("Password" ));
    private JLabel fullNameLbl = (JLabel) panelLeft.add("", new JLabel("Full name" + " "));
    private JLabel phoneLbl = (JLabel)  panelLeft.add("", new JLabel("Phone"));
    private JTextField idTxt = (JTextField) panelCenter.add("", new JTextField());
    private JTextField passwordTxt = (JTextField) panelCenter.add("", new JTextField());
    private JTextField fullNameTxt = (JTextField) panelCenter.add("", new JTextField());
    private JTextField phoneTxt = (JTextField) panelCenter.add("", new JTextField());
    private JButton changeBtn = (JButton) panelBottom.add("", new JButton("Change"));

    public UpdateUserForm(UserEntity user) throws HeadlessException {
        this.setTitle("Change user");
        this.setSize(300, 230);
        this.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width  - this.getSize().width) / 2, (Toolkit.getDefaultToolkit().getScreenSize().height - this.getSize().height) / 2);

        panelBottom.add(new JLabel("       " + "       "), 0);

        idTxt.setEditable(false);
        idTxt.setText(String.valueOf(user.getId()));
        passwordTxt.setText(user.getPassword());
        fullNameTxt.setText(user.getFullName());
        phoneTxt.setText(user.getPhone());

        this.add(panelLeft, BorderLayout.WEST);
        this.add(panelCenter, BorderLayout.CENTER);
        this.add(panelBottom, BorderLayout.SOUTH);

        this.setVisible(true);
    }

    public UserEntity getInfor() {

        return new UserEntity(
                Integer.valueOf(idTxt.getText()),
                passwordTxt.getText(),
                fullNameTxt.getText(),
                phoneTxt.getText()
        );
    }

    public void updateListener (ActionListener listener) {
        changeBtn.addActionListener(listener);
    }

    public void addExitListener(WindowAdapter windowAdapter) {
        this.addWindowListener(windowAdapter);
    }
}
