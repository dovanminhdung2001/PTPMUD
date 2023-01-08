package org.example.control;

import org.example.model.UserEntity;
import org.example.service.UserService;
import org.example.view.UpdateUserForm;

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
                JOptionPane.showMessageDialog(null, "Vui lòng nhập đủ các trường");
                return;
            }
            if (req.getPassword().length() > 100) {
                JOptionPane.showMessageDialog(null, "Mật khẩu quá dài");
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
