package org.example.view;

import org.example.model.CheckInEntity;
import org.example.utils.DateUtils;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.text.ParseException;

public class ResultCheckOutForm extends JFrame {
    private JPanel panelCenter = new JPanel(new GridLayout(1,1));

    public ResultCheckOutForm(CheckInEntity checkIn) throws HeadlessException  {
        this.setTitle("Result");
        this.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width  - this.getSize().width) / 2, (Toolkit.getDefaultToolkit().getScreenSize().height - this.getSize().height) / 2);

        System.out.println(checkIn.totalGoOutMilliSecond());
        System.out.println(checkIn.totalWorkMilliSecond());

        JTextArea jTextArea = new JTextArea(12, 1);
        jTextArea.append("  " + "Id: " + checkIn.getUserId()+ "\n");
        jTextArea.append("  " + "Checkin at: " + " " + DateUtils.sdtf.format(checkIn.getCheckin()) + "\n");
        jTextArea.append("  " + "Checkout at: " + DateUtils.sdtf.format(checkIn.getCheckout()) + "\n");
        jTextArea.append("  " + "Go out times: " + checkIn.goOutTimes() + "\n");

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
        jTextArea.append("  " + "Total go out time: " + checkIn.totalGoOutStr() + "\n");
        jTextArea.append("  " + "Total work time: " + "  " + checkIn.totalWorkStr() + "\n");

        jTextArea.setEditable(false);
        jTextArea.setFont(jTextArea.getFont().deriveFont(20f));
        panelCenter.add(jTextArea);
        this.add(panelCenter, BorderLayout.CENTER);
        this.setSize(350, 400);
        this.setVisible(true);
    }
}
