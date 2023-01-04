package org.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;

public class ManageUserForm extends JFrame {
    private String[] column = {"Id", "Password", "Full name", "Phone"};
    private JPanel panelCenter = new JPanel(new GridLayout(1,1));
    private JPanel panelBottom = new JPanel(new GridLayout(1, 5));
    public DefaultTableModel tableModel = new DefaultTableModel(column, 0) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    public JTable table = new JTable(tableModel);
    public JButton addBtn = (JButton) panelBottom.add("", new JButton("Create"));
    public JButton updateBtn = (JButton) panelBottom.add("", new JButton("Update"));
    public JButton deleteBtn = (JButton) panelBottom.add("", new JButton("Delete"));
    public JButton reCheckinBtn = (JButton) panelBottom.add("", new JButton("Re-checkin"));
    public JButton mangeCheckInBtn = (JButton) panelBottom.add("", new JButton("Mange checkin"));
    public ManageUserForm() throws HeadlessException {
        this.setTitle("Manage user");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(900, 550);
        this.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width  - this.getSize().width) / 2, (Toolkit.getDefaultToolkit().getScreenSize().height - this.getSize().height) / 2);

        JScrollPane jScrollPane = new JScrollPane(table);
        panelCenter.add(jScrollPane);

        this.add(panelCenter, BorderLayout.CENTER);
        this.add(panelBottom, BorderLayout.SOUTH);

        this.setVisible(true);
    }

    public void addListener (ActionListener listener) {
        addBtn.addActionListener(listener);
    }

    public void updateListener (ActionListener listener) {
        updateBtn.addActionListener(listener);
    }

    public void deleteListener (ActionListener listener) {
        deleteBtn.addActionListener(listener);
    }

    public void reCheckinListener (ActionListener listener) {
        reCheckinBtn.addActionListener(listener);
    }

    public void manageCheckinListener (ActionListener listener) {
        mangeCheckInBtn.addActionListener(listener);
    }
}
