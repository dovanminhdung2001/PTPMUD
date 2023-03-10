package org.control;

import org.model.UserEntity;
import org.service.UserService;
import org.view.UpdateUserForm;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateUserControl {
    public UpdateUserForm updateUserForm ;

    public UpdateUserControl(UserEntity user) {
        updateUserForm = new UpdateUserForm(user);
        updateUserForm.updateListener(new UpdateListener());
    }

    class UpdateListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            UserEntity req = updateUserForm.getInfor();
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
            if (req.getPhone().length() > 13) {
                JOptionPane.showMessageDialog(null, "Too long phone");
                return;
            }
            if (req.getPhone().length() < 9) {
                JOptionPane.showMessageDialog(null, "Too short phone");
                return;
            }
            try {
                Integer.parseInt(req.getPhone());
                UserService.update(req);
                JOptionPane.showMessageDialog(null, "Update success");
            } catch (Exception e2) {
                e2.printStackTrace();
                JOptionPane.showMessageDialog(null, "Phone must contain only number");
            }
        }
    }
}
