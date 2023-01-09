package org.example.control;

import com.mysql.cj.protocol.x.Notice;
import lombok.SneakyThrows;
import org.example.model.CheckInEntity;
import org.example.model.dto.CheckInDTO;
import org.example.model.req.FilterCheckinReq;
import org.example.service.CheckInService;
import org.example.utils.DateUtils;
import org.example.utils.Excel.Nv_Day;
import org.example.utils.Excel.Nv_s_Day;
import org.example.view.ManageCheckinForm;

import javax.swing.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ManageCheckInControl {
    ManageCheckinForm manageCheckinForm = new ManageCheckinForm();
    List<CheckInDTO> listCheckin = new ArrayList<>();
    FilterCheckinReq req = new FilterCheckinReq("", "", "");

    public ManageCheckInControl() throws SQLException, ParseException {
        refillData(req);
        manageCheckinForm.manageUserListener(new ManageUserListener());
        manageCheckinForm.findListener(new FindCheckinListener());
        manageCheckinForm.exitListener(new ExitListener());
        manageCheckinForm.logoutListener(new LogOutListener());
        manageCheckinForm.changePasswordListener(new ChangePasswordListener());
        manageCheckinForm.exportListener(new ExportExcel());
        manageCheckinForm.disableExportListener(new DisableExportListener());
        manageCheckinForm.enableExportListener(new EnableExportListener());
    }

    private void refillData(FilterCheckinReq req) throws SQLException, ParseException {
        listCheckin = CheckInService.findByUserIdAndCheckInBetween(req);
        for (CheckInDTO dto : listCheckin) {
            Object[] data = {
                    dto.getUserId(),
                    dto.getUsername(),
                    dto.getCheckin(),
                    dto.getCheckout(),
                    dto.getCheckinLate().equals("     00:-1") ? "" : dto.getCheckinLate(),
                    dto.getCheckoutEarly().equals("     00:-1") ? "" : dto.getCheckoutEarly(),
                    dto.getGoOutAmount(),
                    dto.getGoOutTime(),
                    dto.getWorkTime()
            };
            manageCheckinForm.tableModel.addRow(data);
        }
    }

    private void clearData() {
        for (int i = manageCheckinForm.tableModel.getRowCount(); i > 0; i--) {
            manageCheckinForm.tableModel.removeRow(0);
        }
    }

    class ManageUserListener extends MouseAdapter {
        @SneakyThrows
        @Override
        public void mouseClicked(MouseEvent e) {
            new ManageUserControl();
            manageCheckinForm.dispatchEvent(new WindowEvent(manageCheckinForm, WindowEvent.WINDOW_CLOSING));
        }
    }

    class FindCheckinListener implements ActionListener {
        @SneakyThrows
        @Override
        public void actionPerformed(ActionEvent e) {
            FilterCheckinReq req = manageCheckinForm.getFilterCheckinRequest();

            if (req.getFrom().equals("") ^ req.getTo().equals("")) {
                JOptionPane.showMessageDialog(null, "Vui lòng nhập đủ hai trường");
                return;
            }

            if (req.getFrom().equals("")) {
                clearData();
                refillData(req);
                return;
            }

            try {
                DateUtils.sdf.parse(req.getFrom());
                DateUtils.sdf.parse(req.getTo());
                clearData();
                refillData(req);
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(null, "Ngày không đúng định dạng");
                exception.printStackTrace();
            }
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
            manageCheckinForm.setAllBtn(false);
            changePasswordControl.changePasswordForm.exitListener(new ExitFormListener());
        }
    }

    class ExitFormListener extends WindowAdapter {
        @Override
        public void windowClosing(WindowEvent e) {
            manageCheckinForm.setAllBtn(true);
        }
    }

    class LogOutListener extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            new LoginControl();
            manageCheckinForm.dispatchEvent(new WindowEvent(manageCheckinForm, WindowEvent.WINDOW_CLOSING));
        }
    }

    class DisableExportListener extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            manageCheckinForm.setEnableExportBtn(false);
        }
    }

    class EnableExportListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            manageCheckinForm.setEnableExportBtn(true);
        }
    }

    class ExportExcel implements ActionListener {
        @SneakyThrows
        @Override
        public void actionPerformed(ActionEvent e) {
            req = manageCheckinForm.getFilterCheckinRequest();

            if (manageCheckinForm.tableModel.getRowCount() == 0) {
                JOptionPane.showMessageDialog(null, "Không có dữ liệu", "", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (!req.getFrom().equals("")) {
                req.setFrom(DateUtils.sdf.format(DateUtils.sdf.parse(req.getFrom())));
            } else {
                req.setFrom(DateUtils.todayStr());
            }
            if (!req.getTo().equals("")) {
                req.setTo(DateUtils.sdf.format(DateUtils.sdf.parse(req.getTo())));
            } else {
                req.setTo(DateUtils.tomorrowStr());
            }

            if (req.getId().equals("") && findByOneDay(req)) {
                List<CheckInDTO> list = CheckInService.findByUserIdAndCheckInBetween(req);
                String filePath = Nv_s_Day.export(req, list);
                JOptionPane.showMessageDialog(null, "Thành công, xem file tại: " + filePath);
                return;
            }

            if (findByOneDay(req)) {
                CheckInDTO dto = CheckInService.findByUserIdAndCheckInBetween(req).get(0);
                String filePath = Nv_Day.export(req, dto);
                JOptionPane.showMessageDialog(null, "Thành công, xem file tại: " + filePath);
                return;
            }

            if (!findByOneDay(req)) {
                if (!validReq(req)) {
                    JOptionPane.showMessageDialog(null, "Khoảng thời gian quá dài", "", JOptionPane.ERROR_MESSAGE);
                } else {
                    List<CheckInEntity> list = CheckInService.findByUserIdAndCheckInBetween2(req);
                    System.out.println(list.size());
                }
            }
        }
    }

    private boolean validReq(FilterCheckinReq req) throws ParseException {
        Long to = DateUtils.sdf.parse(req.getTo()).getTime() / 1000;
        Long from = DateUtils.sdf.parse(req.getFrom()).getTime() / 100;

        return  to - from < 3600L * 24 * 365 * 2;
    }

    private boolean findByOneDay(FilterCheckinReq req) throws ParseException {
        Date from = DateUtils.sdf.parse(req.getFrom());
        Date to = DateUtils.sdf.parse(req.getTo());

        return to.getTime() - from.getTime() == 86400000L;  // 24h
    }
}
