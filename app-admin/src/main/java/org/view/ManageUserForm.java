package org.view;

import org.model.req.FindUserReq;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;

public class ManageUserForm extends JFrame {
    private String[] column = {"", "Id", "Password", "Full name", "Phone"};
    private JPanel panelTop = new JPanel(new GridLayout(1, 9));
    private JPanel panelCenter = new JPanel(new GridLayout(1,1));
    private JPanel panelBottom = new JPanel(new GridLayout(1, 5));
    public DefaultTableModel tableModel = new DefaultTableModel(column, 0) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    public JTable table = new JTable(tableModel);
    public JLabel idLbl = (JLabel) panelTop.add(new JLabel("Id"));
    public JTextField idTxt = (JTextField) panelTop.add(new JTextField());
    public JLabel nameLbl = (JLabel) panelTop.add(new JLabel("Name"));
    public JTextField nameTxt = (JTextField) panelTop.add(new JTextField());
    public JLabel phoneLbl = (JLabel) panelTop.add(new JLabel("Phone"));
    public JTextField phoneTxt = (JTextField) panelTop.add(new JTextField());
    public JButton findBtn = (JButton) panelTop.add(new JButton("Find"));
    public JButton addBtn = (JButton) panelBottom.add("", new JButton("Create"));
    public JButton updateBtn = (JButton) panelBottom.add("", new JButton("Update"));
    public JButton deleteBtn = (JButton) panelBottom.add("", new JButton("Delete"));
    public JButton reCheckinBtn = (JButton) panelBottom.add("", new JButton("Re-checkin"));
    public JButton mangeCheckInBtn = (JButton) panelBottom.add("", new JButton("Mange checkin"));
    public ManageUserForm() throws HeadlessException {
        this.setTitle("Manage user");
        this.setSize(900, 550);
        this.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width  - this.getSize().width) / 2, (Toolkit.getDefaultToolkit().getScreenSize().height - this.getSize().height) / 2);

        nameLbl.setHorizontalAlignment(SwingConstants.CENTER);
        idLbl.setHorizontalAlignment(SwingConstants.CENTER);
        phoneLbl.setHorizontalAlignment(SwingConstants.CENTER);

        panelTop.add(new JLabel(),6);
        panelTop.add(new JLabel(),8);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( SwingConstants.CENTER );
        table.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(SwingConstants.RIGHT);
        for (int i = 1; i < column.length; i++) {
            table.getColumnModel().getColumn(i).setCellRenderer( rightRenderer );
        }

        JScrollPane jScrollPane = new JScrollPane(table);
        panelCenter.add(jScrollPane);

        this.add(panelTop, BorderLayout.NORTH);
        this.add(panelCenter, BorderLayout.CENTER);
        this.add(panelBottom, BorderLayout.SOUTH);

        this.setVisible(true);
    }

    public FindUserReq findUser() {
        return new FindUserReq(idTxt.getText(), nameTxt.getText(), phoneTxt.getText());
    }

    public void setAllBtn(boolean status) {
        addBtn.setEnabled(status);
        updateBtn.setEnabled(status);
        deleteBtn.setEnabled(status);
        reCheckinBtn.setEnabled(status);
        mangeCheckInBtn.setEnabled(status);
        findBtn.setEnabled(status);
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

    public void findListener(ActionListener listener) {
        findBtn.addActionListener(listener);
    }
}
