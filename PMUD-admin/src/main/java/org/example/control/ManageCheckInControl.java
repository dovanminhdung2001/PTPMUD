package org.example.control;

import lombok.SneakyThrows;
import org.example.model.dto.CheckInDTO;
import org.example.model.req.FilterCheckinReq;
import org.example.service.CheckInService;
import org.example.utils.DateUtils;
import org.example.view.ManageCheckinForm;

import javax.swing.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class ManageCheckInControl {
    ManageCheckinForm manageCheckinForm = new ManageCheckinForm();
    List<CheckInDTO> listCheckin = new ArrayList<>();

    public ManageCheckInControl() throws SQLException, ParseException {
        refillData(new FilterCheckinReq("", "", ""));
        manageCheckinForm.manageUserListener(new ManageUserListener());
        manageCheckinForm.findListener(new FindCheckinListener());
        manageCheckinForm.exitListener(new ExitListener());
    }

    private void refillData(FilterCheckinReq req) throws SQLException, ParseException {
        listCheckin = CheckInService.findByUserIdAndCheckInBetween(req);
        for (CheckInDTO dto : listCheckin) {
            Object[] data = {
                    dto.getUserId(),
                    dto.getUsername(),
                    dto.getCheckin(),
                    dto.getCheckout(),
                    dto.getCheckinLate(),
                    dto.getCheckoutEarly(),
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
                JOptionPane.showMessageDialog(null, "Please enter both of from date and to date");
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
                JOptionPane.showMessageDialog(null, "Input date invalid format");
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

    class ExportExcel implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }
}
