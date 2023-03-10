package org.example.view;

import org.example.model.req.FindUserReq;
import org.example.netbean.AbsoluteConstraints;
import org.example.netbean.AbsoluteLayout;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

public class ManageUserForm extends JFrame{
    private JPanel panelLeft = new JPanel();
    private JPanel panelRight = new JPanel();
    private JLabel MyDataLbl = new JLabel();
    private JLabel changePasswordLbl = new JLabel();
    private JButton createBtn = new JButton();
    private JButton deleteBtn = new JButton();
    private JLabel exitLbl = new JLabel();
    private JButton findBtn = new JButton();
    private JLabel idLbl = new JLabel();
    private JTextField idTxt = new JTextField();
    private JScrollPane jScrollPane1 = new JScrollPane();
    private JLabel logoLbl = new JLabel();
    private JLabel logoutLbl = new JLabel();
    private JLabel manageCheckinLbl = new JLabel();
    private JLabel mangeUserLbl = new JLabel();
    private JLabel nameLbl = new JLabel();
    private JTextField nameTxt = new JTextField();
    private JLabel phoneLbl = new JLabel();
    private JTextField phoneTxt = new JTextField();
    private JButton reCheckinBtn = new JButton();
    private String[] column = {"", "Mã NV", "Mật khẩu", "Tên", "Số điện thoại"};
    public DefaultTableModel tableModel = new DefaultTableModel(column, 0) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    public JTable table = new JTable(tableModel);
    private JButton updateBtn = new JButton();

    public ManageUserForm() throws HeadlessException {
        setUndecorated(true);
        getContentPane().setLayout(new AbsoluteLayout());

        panelLeft.setBackground(new Color(51, 153, 255));
        panelLeft.setForeground(new Color(255, 255, 255));
        panelLeft.setLayout(new AbsoluteLayout());

        panelRight.setLayout(new AbsoluteLayout());

        logoLbl.setFont(new Font("SansSerif", 1, 18)); // NOI18N
        logoLbl.setForeground(new Color(255, 255, 255));
        logoLbl.setIcon(new ImageIcon(("src/main/java/org/example/icon/logo.png"))); // NOI18N
        logoLbl.setText("Manager");
        panelLeft.add(logoLbl, new AbsoluteConstraints(6, 20, 188, -1));

        mangeUserLbl.setBackground(new Color(255, 255, 255));
        mangeUserLbl.setFont(new Font("SansSerif", 0, 18)); // NOI18N
        mangeUserLbl.setForeground(new Color(255, 255, 255));
        mangeUserLbl.setIcon(new ImageIcon(("src/main/java/org/example/icon/8.png"))); // NOI18N
        mangeUserLbl.setText("Quản lý nhân viên");
        panelLeft.add(mangeUserLbl, new AbsoluteConstraints(6, 105, 188, -1));

        manageCheckinLbl.setFont(new Font("SansSerif", 0, 18)); // NOI18N
        manageCheckinLbl.setForeground(new Color(255, 255, 255));
        manageCheckinLbl.setIcon(new ImageIcon(("src/main/java/org/example/icon/1.png"))); // NOI18N
        manageCheckinLbl.setText("Quản lý checkin");
        manageCheckinLbl.setCursor(new Cursor(Cursor.HAND_CURSOR));
        panelLeft.add(manageCheckinLbl, new AbsoluteConstraints(22, 141, 172, -1));

        MyDataLbl.setFont(new Font("SansSerif", 1, 18)); // NOI18N
        MyDataLbl.setForeground(new Color(255, 255, 255));
        MyDataLbl.setText("Cá nhân");
        panelLeft.add(MyDataLbl, new AbsoluteConstraints(22, 229, 172, -1));

        changePasswordLbl.setFont(new Font("SansSerif", 0, 18)); // NOI18N
        changePasswordLbl.setForeground(new Color(255, 255, 255));
        changePasswordLbl.setIcon(new ImageIcon(("src/main/java/org/example/icon/2.png"))); // NOI18N
        changePasswordLbl.setText("Đổi mật khẩu");
        changePasswordLbl.setCursor(new Cursor(Cursor.HAND_CURSOR));
        panelLeft.add(changePasswordLbl, new AbsoluteConstraints(22, 302, 172, -1));

        logoutLbl.setFont(new Font("SansSerif", 0, 18)); // NOI18N
        logoutLbl.setForeground(new Color(255, 255, 255));
        logoutLbl.setIcon(new ImageIcon(("src/main/java/org/example/icon/9.png"))); // NOI18N
        logoutLbl.setText("Đăng xuất");
        logoutLbl.setCursor(new Cursor(Cursor.HAND_CURSOR));
        panelLeft.add(logoutLbl, new AbsoluteConstraints(22, 344, 172, -1));

        table.setFont(new Font("Segoe UI", 0, 18));
        table.setCursor(new Cursor(Cursor.HAND_CURSOR));
        table.setFocusable(false);
        table.setRowHeight(25);
        table.setSelectionBackground(new Color(204, 255, 255));
        table.getTableHeader().setReorderingAllowed(false);
        table.getTableHeader().setFont(new Font("Segoe UI", 0, 18));
        jScrollPane1.setViewportView(table);
        panelRight.add(jScrollPane1, new AbsoluteConstraints(6, 120, 1010, 550));

        exitLbl.setIcon(new ImageIcon(("src/main/java/org/example/icon/menu.png"))); // NOI18N
        exitLbl.setCursor(new Cursor(Cursor.HAND_CURSOR));
        panelRight.add(exitLbl, new AbsoluteConstraints(990, 15, -1, -1));

        idLbl.setFont(new Font("SansSerif", 0, 18)); // NOI18N
        idLbl.setText("Mã NV");
        panelRight.add(idLbl, new AbsoluteConstraints(20, 21, -1, -1));

        nameLbl.setFont(new Font("SansSerif", 0, 18)); // NOI18N
        nameLbl.setText("Tên");
        panelRight.add(nameLbl, new AbsoluteConstraints(230, 21, -1, -1));

        phoneLbl.setFont(new Font("SansSerif", 0, 18)); // NOI18N
        phoneLbl.setText("SĐT");
        panelRight.add(phoneLbl, new AbsoluteConstraints(415, 21, -1, -1));

        idTxt.setBorder(null);
        panelRight.add(idTxt, new AbsoluteConstraints(80, 15, 100, 35));

        nameTxt.setBorder(null);
        panelRight.add(nameTxt, new AbsoluteConstraints(275, 15, 100, 35));

        phoneTxt.setBorder(null);
        panelRight.add(phoneTxt, new AbsoluteConstraints(464, 15, 100, 35));

        createBtn.setFont(new Font("SansSerif", 0, 18)); // NOI18N
        createBtn.setText("Thêm");
        panelRight.add(createBtn, new AbsoluteConstraints(20, 68, -1, -1));

        updateBtn.setFont(new Font("SansSerif", 0, 18)); // NOI18N
        updateBtn.setText("Sửa");
        panelRight.add(updateBtn, new AbsoluteConstraints(189, 68, -1, -1));

        deleteBtn.setFont(new Font("SansSerif", 0, 18)); // NOI18N
        deleteBtn.setText("Xóa");
        panelRight.add(deleteBtn, new AbsoluteConstraints(352, 68, -1, -1));

        findBtn.setIcon(new ImageIcon(("src/main/java/org/example/icon/search.png"))); // NOI18N
        findBtn.setBorder(BorderFactory.createCompoundBorder());
        panelRight.add(findBtn, new AbsoluteConstraints(658, 15, 44, -1));

        reCheckinBtn.setFont(new Font("SansSerif", 0, 18)); // NOI18N
        reCheckinBtn.setText("Re-checkin");
        panelRight.add(reCheckinBtn, new AbsoluteConstraints(517, 68, -1, -1));

        getContentPane().add(panelLeft, new AbsoluteConstraints(0, 0, 200, 720));
        getContentPane().add(panelRight, new AbsoluteConstraints(200, 0, 1710, 1010));

        setSize(1264, 712);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public FindUserReq findUser() {
        return new FindUserReq(idTxt.getText(), nameTxt.getText(), phoneTxt.getText());
    }

    public void setAllBtn(boolean status) {
        createBtn.setEnabled(status);
        updateBtn.setEnabled(status);
        deleteBtn.setEnabled(status);
        reCheckinBtn.setEnabled(status);
        manageCheckinLbl.setEnabled(status);
        findBtn.setEnabled(status);
        changePasswordLbl.setEnabled(status);
        logoutLbl.setEnabled(status);
    }

    public void addListener (ActionListener listener) {
        createBtn.addActionListener(listener);
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

    public void manageCheckinListener (MouseAdapter adapter) {
        manageCheckinLbl.addMouseListener(adapter);
    }

    public void findListener(ActionListener listener) {
        findBtn.addActionListener(listener);
    }

    public void exitListener(MouseAdapter adapter) { exitLbl.addMouseListener(adapter);}

    public void changePasswordListener(MouseAdapter adapter) {
        changePasswordLbl.addMouseListener(adapter);
    }

    public void logoutListener(MouseAdapter adapter) {
        logoutLbl.addMouseListener(adapter);
    }
}
