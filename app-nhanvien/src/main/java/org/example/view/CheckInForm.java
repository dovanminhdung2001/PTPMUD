package org.example.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowListener;

public class CheckInForm extends JFrame{
    private JPanel panelCenter = new JPanel(new GridLayout(3, 1, 10, 10));
    private JPanel panelLeft = new JPanel(new GridLayout(3, 1, 10, 10));
    private JLabel idLbl = (JLabel) panelLeft.add("",new JLabel("  " + "Id" + "  "));
    private JLabel passwordLbl = (JLabel) panelLeft.add("",new JLabel("  " + "Password" + "  "));
    private JTextField idTxt = (JTextField) panelCenter.add("", new JTextField());
    private JPasswordField passwordTxt = (JPasswordField) panelCenter.add("", new JPasswordField());
    private JButton checkinBtn = (JButton) panelCenter.add("", new JButton("Checkin"));

    public CheckInForm() throws HeadlessException {
        this.setTitle("User Checkin");
        this.setSize(300, 200);
        this.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width  - this.getSize().width) / 2, (Toolkit.getDefaultToolkit().getScreenSize().height - this.getSize().height) / 2);

        panelLeft.add(new JLabel());

        this.add(panelLeft, BorderLayout.WEST);
        this.add(panelCenter, BorderLayout.CENTER);
        this.setVisible(true);
    }

    public String[] getInfor() {
        return new String[] {idTxt.getText(), String.valueOf(passwordTxt.getPassword())};
    }

    public void setCheckinBtn(Boolean status) {
        checkinBtn.setEnabled(status);
    }

    public void addCheckinListener(ActionListener listener) {
        checkinBtn.addActionListener(listener);
    }

    public void addExitListener(WindowAdapter adapter) {
        this.addWindowListener(adapter);
    }

    public void notCheckoutYetListener(WindowListener adapter) {
        this.addWindowListener(adapter);
    }
}
