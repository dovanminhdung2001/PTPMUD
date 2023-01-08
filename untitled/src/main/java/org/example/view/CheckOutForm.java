package org.example.view;

import org.example.model.UserEntity;
import org.example.utils.DateUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.text.ParseException;
import java.util.Date;

public class CheckOutForm extends JFrame {
    public JPanel panelCenter = new JPanel(new GridLayout(2,1));
    public JPanel panelBottom = new JPanel(new FlowLayout());
    public JLabel inforLbl = (JLabel) panelCenter.add("", new JLabel(" " + "id: "));
    public JLabel checkinAtLbl = (JLabel) panelCenter.add("", new JLabel(" " + "Checkin at: "));
    public JButton goOutBtn = (JButton) panelBottom.add("", new JButton("go out"));
    public JButton goInBtn = (JButton) panelBottom.add("", new JButton("go in"));
    public JButton checkoutBtn = (JButton) panelBottom.add("", new JButton("check out"));

    public CheckOutForm() throws HeadlessException {
        this.setTitle("Welcome");
        this.setSize(280, 150);
        this.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width  - this.getSize().width) / 2, (Toolkit.getDefaultToolkit().getScreenSize().height - this.getSize().height) / 2);

        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        this.add(panelBottom, BorderLayout.SOUTH);
        this.add(panelCenter, BorderLayout.CENTER);

        this.setVisible(true);
    }

    public void setInforLbl (UserEntity user) {
        inforLbl.setText(" " + "id: " + user.getId() + "    " + user.getFullName());
    }

    public void setCheckinAtLbl (Date checkin) throws ParseException {
        checkinAtLbl.setText(" " + "Checkin at: " + DateUtils.sdtf.format(checkin));
    }

    public void setGoOutBtn(Boolean status) {
        goOutBtn.setEnabled(status);
    }

    public void setGoInBtn(Boolean status) {
        goInBtn.setEnabled(status);
    }

    public void setCheckoutBtn(Boolean status) {
        goInBtn.setEnabled(status);
    }

    public void setGoOutListener(ActionListener listener) {
        goOutBtn.addActionListener(listener);
    }

    public void setGoInListener(ActionListener listener) {
        goInBtn.addActionListener(listener);
    }

    public void setCheckoutListener(ActionListener listener) {
        checkoutBtn.addActionListener(listener);
    }

    public void addExitListener(WindowAdapter adapter) {
        this.addWindowListener(adapter);
    }
}
