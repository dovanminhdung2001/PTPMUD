package org.example.view;

import org.example.model.req.FilterCheckinReq;
import org.example.netbean.AbsoluteConstraints;
import org.example.netbean.AbsoluteLayout;
import org.example.service.UserService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.sql.SQLException;
import java.util.ArrayList;

public class ManageCheckinForm extends JFrame {
    private JPanel panelLeft = new JPanel();
    private JPanel panelRight = new JPanel();
    private JLabel LogoLbl = new JLabel();
    private JLabel changePasswordLbl = new JLabel();
    private JLabel exitLbl = new JLabel();
    private JButton exportBtn = new JButton();
    private JButton findBtn = new JButton();
    private JLabel fromLbl = new JLabel();
    private JTextField fromTxt = new JTextField("yyyy-MM-dd");
    private JLabel idLbl = new JLabel();
    private JScrollPane jScrollPane1 = new JScrollPane();
    private JLabel logOutLbl = new JLabel();
    private JLabel manageCheckinLbl = new JLabel();
    private JLabel manageUserLbl = new JLabel();
    private JLabel myDataLbl = new JLabel();
    private String[] column = {
            "Mã NV", "Tên", "Checkin ", "Checkout", "Checkin muộn", "Checkout sớm", "Lần ra ngoài", "Thời gian ra ngoài", "Thời gian làm việc"
    };
    public DefaultTableModel tableModel = new DefaultTableModel(column, 0) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    public JTable table = new JTable(tableModel);
    private JLabel toLbl = new JLabel();
    private JTextField toTxt = new JTextField("yyyy-MM-dd");
    private ArrayList<Integer> listId = UserService.findAllId();
    private JComboBox<Integer> idCbb = new JComboBox<>();

    public ManageCheckinForm() throws HeadlessException, SQLException {
        setUndecorated(true);
        getContentPane().setLayout(new AbsoluteLayout());

        setPlaceHolder();

        panelLeft.setBackground(new Color(51, 153, 255));
        panelLeft.setForeground(new Color(255, 255, 255));
        panelLeft.setLayout(new AbsoluteLayout());

        panelRight.setLayout(new AbsoluteLayout());

        LogoLbl.setFont(new Font("SansSerif", 1, 18)); // NOI18N
        LogoLbl.setForeground(new Color(255, 255, 255));
        LogoLbl.setIcon(new ImageIcon(("src/main/java/org/example/icon/logo.png"))); // NOI18N
        LogoLbl.setText("Manager");
        panelLeft.add(LogoLbl, new AbsoluteConstraints(6, 20, 188, -1));

        manageUserLbl.setFont(new Font("SansSerif", 0, 18)); // NOI18N
        manageUserLbl.setForeground(new Color(255, 255, 255));
        manageUserLbl.setIcon(new ImageIcon(("src/main/java/org/example/icon/8.png"))); // NOI18N
        manageUserLbl.setText("Quản lý nhân viên");
        manageUserLbl.setCursor(new Cursor(Cursor.HAND_CURSOR));
        panelLeft.add(manageUserLbl, new AbsoluteConstraints(22, 105, 172, -1));

        manageCheckinLbl.setFont(new Font("SansSerif", 0, 18)); // NOI18N
        manageCheckinLbl.setForeground(new Color(255, 255, 255));
        manageCheckinLbl.setIcon(new ImageIcon(("src/main/java/org/example/icon/1.png"))); // NOI18N
        manageCheckinLbl.setText("Quản lý checkin");
        manageCheckinLbl.setCursor(new Cursor(Cursor.HAND_CURSOR));
        panelLeft.add(manageCheckinLbl, new AbsoluteConstraints(6, 141, 188, -1));

        logOutLbl.setFont(new Font("SansSerif", 0, 18)); // NOI18N
        logOutLbl.setForeground(new Color(255, 255, 255));
        logOutLbl.setIcon(new ImageIcon(("src/main/java/org/example/icon/9.png"))); // NOI18N
        logOutLbl.setText("Đăng xuất");
        logOutLbl.setCursor(new Cursor(Cursor.HAND_CURSOR));
        panelLeft.add(logOutLbl, new AbsoluteConstraints(22, 344, 172, -1));

        changePasswordLbl.setFont(new Font("SansSerif", 0, 18)); // NOI18N
        changePasswordLbl.setForeground(new Color(255, 255, 255));
        changePasswordLbl.setIcon(new ImageIcon(("src/main/java/org/example/icon/2.png"))); // NOI18N
        changePasswordLbl.setText("Đổi mật khẩu");
        changePasswordLbl.setCursor(new Cursor(Cursor.HAND_CURSOR));
        panelLeft.add(changePasswordLbl, new AbsoluteConstraints(22, 302, 172, -1));

        myDataLbl.setFont(new Font("SansSerif", 1, 18)); // NOI18N
        myDataLbl.setForeground(new Color(255, 255, 255));
        myDataLbl.setText("Cá nhân");
        panelLeft.add(myDataLbl, new AbsoluteConstraints(22, 229, 172, -1));

        table.setFocusable(false);
        table.setRowHeight(25);
        table.setSelectionBackground(new Color(153, 102, 255));
        jScrollPane1.setViewportView(table);
        panelRight.add(jScrollPane1, new AbsoluteConstraints(6, 67, 1052, 600));

        exitLbl.setIcon(new ImageIcon(("src/main/java/org/example/icon/menu.png"))); // NOI18N
        exitLbl.setCursor(new Cursor(Cursor.HAND_CURSOR));
        panelRight.add(exitLbl, new AbsoluteConstraints(990, 15, -1, -1));

        idLbl.setFont(new Font("SansSerif", 0, 18)); // NOI18N
        idLbl.setText("Id");
        panelRight.add(idLbl, new AbsoluteConstraints(6, 21, -1, -1));

        fromLbl.setFont(new Font("SansSerif", 0, 18)); // NOI18N
        fromLbl.setText("From");
        panelRight.add(fromLbl, new AbsoluteConstraints(206, 21, -1, -1));

        toLbl.setFont(new Font("SansSerif", 0, 18)); // NOI18N
        toLbl.setText("To");
        panelRight.add(toLbl, new AbsoluteConstraints(457, 21, -1, -1));

        fromTxt.setBorder(null);
        panelRight.add(fromTxt, new AbsoluteConstraints(259, 15, 180, 35));

        toTxt.setBorder(null);
        panelRight.add(toTxt, new AbsoluteConstraints(491, 15, 180, 35));

        idCbb.setFont(new Font("SansSerif", 0, 18)); // NOI18N
        listId.add(0, null);
        idCbb = new JComboBox(listId.toArray());
        panelRight.add(idCbb, new AbsoluteConstraints(32, 16, 150, -1));

        findBtn.setIcon(new ImageIcon(("src/main/java/org/example/icon/search.png"))); // NOI18N
        panelRight.add(findBtn, new AbsoluteConstraints(700, 15, -1, 40));

        exportBtn.setIcon(new ImageIcon(("src/main/java/org/example/icon/export-big.png"))); // NOI18N
        exportBtn.setText("Xuất excel");
        panelRight.add(exportBtn, new AbsoluteConstraints(778, 15, -1, -1));

        getContentPane().add(panelLeft, new AbsoluteConstraints(0, 0, 200, 1010));
        getContentPane().add(panelRight, new AbsoluteConstraints(200, 0, 1710, 1010));

        setSize(1264, 712);
        setLocationRelativeTo(null);
        setVisible(true);
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

    public void setAllBtn(boolean status) {
        logOutLbl.setEnabled(status);
        changePasswordLbl.setEnabled(status);
        findBtn.setEnabled(status);
        manageUserLbl.setEnabled(status);
    }

    public void setEnableExportBtn(boolean status) {
        exportBtn.setEnabled(status);
    }

    public void findListener (ActionListener listener) {
        findBtn.addActionListener(listener);
    }

    public void exportListener (ActionListener listener) {
        exportBtn.addActionListener(listener);
    }

    public void manageUserListener (MouseAdapter adapter) {
        manageUserLbl.addMouseListener(adapter);
    }

    public void logoutListener (MouseAdapter adapter) {
        logOutLbl.addMouseListener(adapter);
    }

    public void exitListener (MouseAdapter adapter) {
        exitLbl.addMouseListener(adapter);
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

    public void changePasswordListener(MouseAdapter adapter) {
        changePasswordLbl.addMouseListener(adapter);
    }

    public void disableExportListener(MouseAdapter adapter) {
        idCbb.addMouseListener(adapter);
        fromTxt.addMouseListener(adapter);
        toTxt.addMouseListener(adapter);
    }

    public void enableExportListener(ActionListener listener) {
        findBtn.addActionListener(listener);
    }
}
