package org.example.control;

import org.example.model.UserEntity;
import org.example.service.UserService;
import org.example.view.AddUserForm;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddUserControl {
    public AddUserForm addUserForm = new AddUserForm();

    public AddUserControl() {
        addUserForm.addListener(new AddListener());
    }

    class AddListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            UserEntity req = addUserForm.getInfor();
            if (req.getPassword().equals("") || req.getFullName().equals("") || req.getPhone().equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter all required information");
                return;
            }
            if (req.getPassword().length() > 100) {
                JOptionPane.showMessageDialog(null, "Too long password");
                return;
            }
            if (req.getFullName().length() > 100) {
                JOptionPane.showMessageDialog(null, "Too long full name");
                return;
            }
            if (req.getPhone().length() > 12) {
                JOptionPane.showMessageDialog(null, "Too long phone");
                return;
            }
            if (req.getPhone().length() < 10) {
                JOptionPane.showMessageDialog(null, "Too short phone");
                return;
            }
            try {
                Long.parseLong(req.getPhone());
                UserService.create(req);
                JOptionPane.showMessageDialog(null, "Add success");
            } catch (Exception e2) {
                e2.printStackTrace();
                JOptionPane.showMessageDialog(null, "Phone must contain only number");
            }
        }
    }
}
