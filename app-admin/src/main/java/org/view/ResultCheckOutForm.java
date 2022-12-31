package org.view;

import org.model.CheckInEntity;
import org.utils.DateUtils;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.text.ParseException;

public class ResultCheckOutForm extends JFrame {
    private JPanel panelCenter = new JPanel(new GridLayout(1,1));

    public ResultCheckOutForm(CheckInEntity checkIn) throws HeadlessException  {
        this.setTitle("Result");
        this.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width  - this.getSize().width) / 2 - 300, (Toolkit.getDefaultToolkit().getScreenSize().height - this.getSize().height) / 2 - 200);

        JTextArea jTextArea = new JTextArea(12, 1);
        jTextArea.append("  " + "Id: " + checkIn.getUserId()+ "\n");
        jTextArea.append("  " + "Checkin at: " + " " + DateUtils.sdtf.format(checkIn.getCheckin()) + ",\t" + validCheckinLate(checkIn)  + "\n");
        jTextArea.append("  " + "Checkout at: " +     DateUtils.sdtf.format(checkIn.getCheckout()) + ",\t" + validCheckoutEarly(checkIn)+ "\n");
        jTextArea.append("  " + "Go out times: " + checkIn.goOutTimes() +  "\n");

        if (checkIn.getGoIn1() != null) {
            jTextArea.append("  " + "Go out 1: " + DateUtils.sdtf.format(checkIn.getGoOut1()) + "\n");
            jTextArea.append("  " + "Go in 1: " + " " + DateUtils.sdtf.format(checkIn.getGoIn1()) + "\n");
        }
        if (checkIn.getGoIn2() != null) {
            jTextArea.append("  " + "Go out 2: " + DateUtils.sdtf.format(checkIn.getGoOut2()) + "\n");
            jTextArea.append("  " + "Go in 2: " + " " + DateUtils.sdtf.format(checkIn.getGoIn2())+ "\n");
        }
        if (checkIn.getGoIn3() != null) {
            jTextArea.append("  " + "Go out 3: " + DateUtils.sdtf.format(checkIn.getGoOut3()) + "\n");
            jTextArea.append("  " + "Go in 3: " + " " +  DateUtils.sdtf.format(checkIn.getGoIn3()) + "\n");
        }
        jTextArea.append("  " + "Total go out time: " + validGoOutTime(checkIn) + "\n");
        jTextArea.append("  " + "Total work time: " + "  " +  validWorkingTime(checkIn) + "\n");

        jTextArea.setEditable(false);
        jTextArea.setFont(jTextArea.getFont().deriveFont(20f));
        panelCenter.add(jTextArea);
        this.add(panelCenter, BorderLayout.CENTER);
        this.setSize(600, 400);
        this.setVisible(true);
    }

    private String validCheckinLate(CheckInEntity checkIn) {
        Long lateTime = checkIn.getCheckinLate();
        if (lateTime < 0)
            return "on time";

        Long hour = lateTime / 3600;
        Long minute = lateTime / 60 % 60;
        Long second = lateTime % 60;

        return hour > 0
                ? String.format("Late: %02d:%02d:%02d", hour, minute, second)
                : String.format("Late: %02d:%02d",  minute, second);
    }

    private String validCheckoutEarly(CheckInEntity checkIn) {
        Long lateTime = checkIn.getCheckoutEarly();
        if (lateTime < 0)
            return "on time";

        Long hour = lateTime / 3600;
        Long minute = lateTime / 60 % 60;
        Long second = lateTime % 60;

        return hour > 0
                ? String.format("Early: %02d:%02d:%02d", hour, minute, second)
                : String.format("Early: %02d:%02d",  minute, second);
    }

    private String validGoOutTime(CheckInEntity checkIn) {
        Long time = checkIn.getGoOutTime();
        if (time < 0 || time == null)
            return "";

        Long hour = time / 3600;
        Long minute = time / 60 % 60;
        Long second = time % 60;

        return hour > 0
                ? String.format("%02d:%02d:%02d", hour, minute, second)
                : String.format("%02d:%02d",  minute, second);
    }

    private String validWorkingTime(CheckInEntity checkIn) {
        Long time = checkIn.getWorkTime();
        if (time <= 0)
            return "";

        Long hour = time / 3600;
        Long minute = time / 60 % 60;
        Long second = time % 60;

        return hour > 0
                ? String.format("%02d:%02d:%02d", hour, minute, second)
                : String.format("%02d:%02d",  minute, second);
    }
}
