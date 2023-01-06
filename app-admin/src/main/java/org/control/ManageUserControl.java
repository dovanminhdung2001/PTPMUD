package org.control;

import lombok.SneakyThrows;
import org.model.CheckInEntity;
import org.model.UserEntity;
import org.service.AdminService;
import org.service.CheckInService;
import org.service.UserService;
import org.view.ManageUserForm;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ManageUserControl {
    ManageUserForm manageUserForm = new ManageUserForm();
    List<UserEntity> listUser = new ArrayList<>();
    public ManageUserControl() throws SQLException, ClassNotFoundException {
        refillData();
        manageUserForm.addListener(new CreateListener());
        manageUserForm.updateListener(new UpdateListener());
        manageUserForm.deleteListener(new DeleteListener());
        manageUserForm.reCheckinListener(new ReCheckinListener());
        manageUserForm.manageCheckinListener(new ManageCheckinListener());
    }

    public void refillData() throws ClassNotFoundException, SQLException {
        listUser = UserService.findAll();
        int i=0;
        for (UserEntity u : listUser) {
            Object[] data = {
                    ++i,
                    u.getId(),
                    u.getPassword(),
                    u.getFullName(),
                    u.getPhone()
            };
            manageUserForm.tableModel.addRow(data);
        }
    }

    public void clearData() {
        for (int i = manageUserForm.tableModel.getRowCount(); i > 0; i--) {
            manageUserForm.tableModel.removeRow(0);
        }
    }

    class CreateListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            AddUserControl addUserControl = new AddUserControl();
            manageUserForm.setAllBtn(false);
            addUserControl.addUserForm.exitListener(new ReloadListener());
        }
    }

    class UpdateListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int selectedRow = manageUserForm.table.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(null, "Must select one row");
            } else {
                UserEntity user = new UserEntity(
                        (Integer) manageUserForm.tableModel.getValueAt(selectedRow, 1),
                        (String) manageUserForm.tableModel.getValueAt(selectedRow, 2),
                        (String) manageUserForm.tableModel.getValueAt(selectedRow, 3),
                        (String) manageUserForm.tableModel.getValueAt(selectedRow, 4)
                );
                UpdateUserControl updateUserControl = new UpdateUserControl(user);
                manageUserForm.setAllBtn(false);
                updateUserControl.updateUserForm.addExitListener(new ReloadListener());
            }
        }
    }

    class DeleteListener implements ActionListener {
        @SneakyThrows
        @Override
        public void actionPerformed(ActionEvent e) {
            int selectedRow = manageUserForm.table.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(null, "Must select one row");
            } else {
                int dialogButton = JOptionPane.YES_NO_OPTION;
                int dialogResult = JOptionPane.showConfirmDialog (null, "All employee data will be completely deleted, are you sure you want to delete it?","Warning",dialogButton);
                if (dialogResult == JOptionPane.YES_OPTION) {
                    UserService.delete((Integer) manageUserForm.table.getValueAt(selectedRow, 1));
                    JOptionPane.showMessageDialog(null, "Delete success");
                    clearData();
                    refillData();
                }
            }
        }
    }

    class ReCheckinListener implements ActionListener {
        @SneakyThrows
        @Override
        public void actionPerformed(ActionEvent e) {
            int selectedRow = manageUserForm.table.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(null, "Must select one row");
            } else {
                int userId = (Integer) manageUserForm.table.getValueAt(selectedRow, 1);
                CheckInEntity checkIn = CheckInService.findByUserIdAndCheckInToday(userId);

                if (checkIn == null) {
                    JOptionPane.showMessageDialog(null, "User not checkin yet");
                    return;
                }
                if (checkIn.getCheckout() == null) {
                    int row = UserService.reCheckin(userId);
                    JOptionPane.showMessageDialog(null, String.valueOf(row));
                    return;
                }
                JOptionPane.showMessageDialog(null, "User already checkout");
            }
        }
    }

    class ManageCheckinListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    class ReloadListener extends WindowAdapter {
        @SneakyThrows
        @Override
        public void windowClosing(WindowEvent e) {
            clearData();
            refillData();
            manageUserForm.setAllBtn(true);
        }
    }
}
