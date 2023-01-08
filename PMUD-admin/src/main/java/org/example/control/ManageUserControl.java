package org.example.control;

import lombok.SneakyThrows;
import org.example.model.CheckInEntity;
import org.example.model.UserEntity;
import org.example.model.req.FindUserReq;
import org.example.service.CheckInService;
import org.example.service.UserService;
import org.example.view.ManageUserForm;

import javax.swing.*;
import java.awt.event.*;
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
        manageUserForm.findListener(new FindListener());
        manageUserForm.exitListener(new ExitListener());
        manageUserForm.changePasswordListener(new ChangePasswordListener());
        manageUserForm.logoutListener(new LogOutListener());
    }

    public void refillData() throws  SQLException {
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
                JOptionPane.showMessageDialog(null, "Vui lòng chọn một dòng");
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
                JOptionPane.showMessageDialog(null, "Vui lòng chọn một dòng");
            } else {
                int userId = (Integer) manageUserForm.table.getValueAt(selectedRow, 1);
                CheckInEntity checkIn = CheckInService.findByUserIdAndCheckInToday(userId);

                if (checkIn == null) {
                    JOptionPane.showMessageDialog(null, "Nhân viên chưa checkin");
                    return;
                }
                if (checkIn.getCheckout() == null) {
                    UserService.reCheckin(userId);
                    JOptionPane.showMessageDialog(null, "Cho phép thành công");
                    return;
                }
                JOptionPane.showMessageDialog(null, "Nhân viên đã checkout");
            }
        }
    }

    class ManageCheckinListener extends MouseAdapter {
        @SneakyThrows
        @Override
        public void mouseClicked(MouseEvent e) {
            new ManageCheckInControl();
            manageUserForm.dispatchEvent(new WindowEvent(manageUserForm, WindowEvent.WINDOW_CLOSING));
        }
    }

    class FindListener implements ActionListener {
        @SneakyThrows
        @Override
        public void actionPerformed(ActionEvent e) {
            clearData();
            refillData(manageUserForm.findUser());
        }

        private void refillData() throws SQLException {
            refillData(null);
        }

        private void refillData(FindUserReq req) throws SQLException {
            listUser = UserService.findUsers(req);
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

    class ExitListener extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            System.exit(0);
        }
    }

    class ChangePasswordListener extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            ChangePasswordControl changePasswordControl = new ChangePasswordControl();
            manageUserForm.setAllBtn(false);
            changePasswordControl.changePasswordForm.exitListener(new ExitFormListener());
        }
    }

    class ExitFormListener extends WindowAdapter {
        @Override
        public void windowClosing(WindowEvent e) {
            manageUserForm.setAllBtn(true);
        }
    }

    class LogOutListener extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            new LoginControl();
            manageUserForm.dispatchEvent(new WindowEvent(manageUserForm, WindowEvent.WINDOW_CLOSING));
        }
    }
}



