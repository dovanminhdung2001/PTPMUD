package org.control;

import lombok.SneakyThrows;
import org.model.dto.CheckInDTO;
import org.model.req.FilterCheckinReq;
import org.service.CheckInService;
import org.utils.DateUtils;
import org.view.ManageCheckinForm;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class ManageCheckinControl {
    ManageCheckinForm manageCheckinForm = new ManageCheckinForm();
    List<CheckInDTO> listCheckin = new ArrayList<>();

    public ManageCheckinControl() throws SQLException, ParseException {
        refillData(new FilterCheckinReq("", "", ""));
        manageCheckinForm.manageUserListener(new ManageUserListener());
        manageCheckinForm.findListener(new FindCheckinListener());
    }

    private void refillData(FilterCheckinReq req) throws SQLException, ParseException {
        listCheckin = CheckInService.findByUserIdAndCheckInBetween(req);
        for (CheckInDTO dto : listCheckin) {
            Object[] data = {
                    dto.getUserId(),
                    dto.getUsername(),
                    dto.getCheckin(),
                    dto.getGoOut1(),
                    dto.getGoIn1(),
                    dto.getGoIn2(),
                    dto.getGoIn2(),
                    dto.getGoOut3(),
                    dto.getGoIn3(),
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

    class ManageUserListener implements ActionListener {
        @SneakyThrows
        @Override
        public void actionPerformed(ActionEvent e) {
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

    class ExportExcel implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }
}
