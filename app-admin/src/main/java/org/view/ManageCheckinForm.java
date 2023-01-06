package org.view;

import org.model.req.FilterCheckinReq;
import org.service.UserService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.SQLException;
import java.util.ArrayList;

public class ManageCheckinForm extends JFrame {
    private String[] column = {"User id", "Name", "Checkin", "Go out 1", "Go in 1", "Go out 2", "Go in 2", "Go out 3", "Go in 3", "Checkout", "Checkin late", "Checkout early", "Go out turns", "Go out time", "Work time"};
    private JPanel panelTop =  new JPanel(new GridLayout(2, 8, 10, 10));
    private JPanel panelBottom = new JPanel(new GridLayout(1, 5));
    private JPanel panelCenter = new JPanel(new GridLayout(1,1));
    private JLabel fromLbl = (JLabel) panelTop.add(new JLabel("from"));
    private JLabel toLbl = (JLabel) panelTop.add( new JLabel("to"));
    private JLabel idLbl = (JLabel) panelTop.add(new JLabel("Id"));
    private JTextField fromTxt = (JTextField) panelTop.add(new JTextField());
    private JTextField toTxt = (JTextField) panelTop.add(new JTextField());
    private ArrayList<Integer> listId = UserService.findAllId();
    private JComboBox<Integer> idCbb ;

    public JButton findBtn = (JButton) panelTop.add(new JButton("Find"));
    public JButton exportBtn = (JButton) panelTop.add("", new JButton("Export"));
    public JButton manageUserBtn = (JButton) panelTop.add("", new JButton("Manage user"));
    public DefaultTableModel tableModel = new DefaultTableModel(column, 0) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    public JTable table = new JTable(tableModel);
    public ManageCheckinForm() throws HeadlessException, SQLException {
        this.setTitle("Manage checkin");
        this.setSize(Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height);

        panelTop.add(new JLabel(), 0);
        panelTop.add(new JLabel(), 4);
        panelTop.add(new JLabel(), 5);
        panelTop.add(new JLabel(), 6);
        panelTop.add(new JLabel(), 7);
        panelTop.add(new JLabel(), 8);
        listId.add(0, null);
        idCbb = new JComboBox(listId.toArray());
        panelTop.add(idCbb, 11);
        panelTop.add(new JLabel(), 15);

        JScrollPane j = new JScrollPane(table);
        panelCenter.add(j);

        setPlaceHolder();

        this.add(panelTop, BorderLayout.NORTH);
        this.add(panelCenter, BorderLayout.CENTER);
        this.add(panelBottom, BorderLayout.SOUTH);
        this.setVisible(true);
    }

    public FilterCheckinReq getFilterCheckinRequest() {
        String from = fromTxt.getText().equals("yyyy-MM-dd") ? "" : fromTxt.getText();
        String to = toTxt.getText().equals("yyyy-MM-dd") ? "" : toTxt.getText();

        return new FilterCheckinReq(
            from,
            to,
            idCbb.getSelectedItem() == null ? "" : String.valueOf(idCbb.getSelectedItem())
        );
    }

    public void findListener (ActionListener listener) {
        findBtn.addActionListener(listener);
    }

    public void exportListener (ActionListener listener) {
        exportBtn.addActionListener(listener);
    }

    public void manageUserListener (ActionListener listener) {
        manageUserBtn.addActionListener(listener);
    }

    private void setPlaceHolder() {
        toTxt.setForeground(Color.GRAY);
        toTxt.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (toTxt.getText().equals("yyyy-MM-dd")) {
                    toTxt.setText("");
                    toTxt.setForeground(Color.BLACK);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (toTxt.getText().equals("") || toTxt.getText() == null) {
                    toTxt.setForeground(Color.GRAY);
                    toTxt.setText("yyyy-MM-dd");
                }
            }
        });
        fromTxt.setForeground(Color.GRAY);
        fromTxt.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (fromTxt.getText().equals("yyyy-MM-dd")) {
                    fromTxt.setText("");
                    fromTxt.setForeground(Color.BLACK);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (fromTxt.getText().equals("") || fromTxt.getText() == null) {
                    fromTxt.setForeground(Color.GRAY);
                    fromTxt.setText("yyyy-MM-dd");
                }
            }
        });
    }
}
