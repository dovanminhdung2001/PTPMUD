package org.example.view;/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author NgoThuan
 */
public class kqcheckout extends javax.swing.JFrame {

    /**
     * Creates new form kqcheckout
     */
    public kqcheckout() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        centerPanel = new javax.swing.JPanel();
        checkinAtPanel = new javax.swing.JPanel();
        checkinAt1 = new javax.swing.JLabel();
        checkinAtLbl = new javax.swing.JLabel();
        checkoutAt = new javax.swing.JPanel();
        checkoutAt1 = new javax.swing.JLabel();
        checkoutAtLbl = new javax.swing.JLabel();
        totalWorkTimePanel = new javax.swing.JPanel();
        totalWorkTime1 = new javax.swing.JLabel();
        totalWorkTimeLbl = new javax.swing.JLabel();
        totalGoOutTimePanel = new javax.swing.JPanel();
        totalGoOutTime1 = new javax.swing.JLabel();
        totalGoOutTimeLbl = new javax.swing.JLabel();
        goOutPanel = new javax.swing.JPanel();
        goOut1 = new javax.swing.JLabel();
        time1 = new javax.swing.JLabel();
        goOutTimesLbl = new javax.swing.JLabel();
        checkinLatePanel = new javax.swing.JPanel();
        checkinLateLbl = new javax.swing.JLabel();
        checkinLate1 = new javax.swing.JLabel();
        CheckoutEarlyPanel = new javax.swing.JPanel();
        CheckoutEarly1 = new javax.swing.JLabel();
        CheckoutEarlyLbl = new javax.swing.JLabel();
        idPanel = new javax.swing.JPanel();
        id1 = new javax.swing.JLabel();
        idLbl = new javax.swing.JLabel();
        exitLbl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        centerPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        checkinAtPanel.setBackground(new java.awt.Color(159, 121, 238));
        checkinAtPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        checkinAt1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        checkinAt1.setForeground(new java.awt.Color(255, 255, 255));
        checkinAt1.setText("Checkin At:");
        checkinAtPanel.add(checkinAt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 14, -1, -1));

        checkinAtLbl.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        checkinAtLbl.setForeground(new java.awt.Color(255, 255, 255));
        checkinAtLbl.setText("2022-02-22 12-12-12");
        checkinAtPanel.add(checkinAtLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));

        centerPanel.add(checkinAtPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(229, 6, 290, 130));

        checkoutAt.setBackground(new java.awt.Color(102, 205, 0));
        checkoutAt.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        checkoutAt1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        checkoutAt1.setForeground(new java.awt.Color(255, 255, 255));
        checkoutAt1.setText("Checkout At:");
        checkoutAt.add(checkoutAt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 14, -1, -1));

        checkoutAtLbl.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        checkoutAtLbl.setForeground(new java.awt.Color(255, 255, 255));
        checkoutAtLbl.setText("2022-02-22 12-12-12");
        checkoutAt.add(checkoutAtLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 80, -1, -1));

        centerPanel.add(checkoutAt, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 6, 300, 130));

        totalWorkTimePanel.setBackground(new java.awt.Color(0, 191, 255));
        totalWorkTimePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        totalWorkTime1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        totalWorkTime1.setForeground(new java.awt.Color(255, 255, 255));
        totalWorkTime1.setText("Total Work Time:");
        totalWorkTimePanel.add(totalWorkTime1, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 14, -1, -1));

        totalWorkTimeLbl.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        totalWorkTimeLbl.setForeground(new java.awt.Color(255, 255, 255));
        totalWorkTimeLbl.setText("12:12");
        totalWorkTimePanel.add(totalWorkTimeLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(254, 80, -1, -1));

        centerPanel.add(totalWorkTimePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 370, 130));

        totalGoOutTimePanel.setBackground(new java.awt.Color(224, 102, 225));
        totalGoOutTimePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        totalGoOutTime1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        totalGoOutTime1.setForeground(new java.awt.Color(255, 255, 255));
        totalGoOutTime1.setText("Total go out time:");
        totalGoOutTimePanel.add(totalGoOutTime1, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 14, -1, -1));

        totalGoOutTimeLbl.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        totalGoOutTimeLbl.setForeground(new java.awt.Color(255, 255, 255));
        totalGoOutTimeLbl.setText("12:12");
        totalGoOutTimePanel.add(totalGoOutTimeLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 80, -1, -1));

        centerPanel.add(totalGoOutTimePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 290, 450, 130));

        goOutPanel.setBackground(new java.awt.Color(255, 105, 180));
        goOutPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        goOut1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        goOut1.setForeground(new java.awt.Color(255, 255, 255));
        goOut1.setText("Go out ");
        goOutPanel.add(goOut1, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 14, -1, 50));

        time1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        time1.setForeground(new java.awt.Color(255, 255, 255));
        time1.setText("0");
        goOutPanel.add(time1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 80, 20, -1));

        goOutTimesLbl.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        goOutTimesLbl.setForeground(new java.awt.Color(255, 255, 255));
        goOutTimesLbl.setText("times:");
        goOutPanel.add(goOutTimesLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        centerPanel.add(goOutPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 146, 220, 134));

        checkinLatePanel.setBackground(new java.awt.Color(238, 118, 33));
        checkinLatePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        checkinLateLbl.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        checkinLateLbl.setForeground(new java.awt.Color(255, 255, 255));
        checkinLateLbl.setText("12:12:12");
        checkinLatePanel.add(checkinLateLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, -1, -1));

        checkinLate1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        checkinLate1.setForeground(new java.awt.Color(255, 255, 255));
        checkinLate1.setText("Checkin Late:");
        checkinLatePanel.add(checkinLate1, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 14, -1, -1));

        centerPanel.add(checkinLatePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(229, 146, 290, 134));

        CheckoutEarlyPanel.setBackground(new java.awt.Color(0, 191, 255));
        CheckoutEarlyPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        CheckoutEarly1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        CheckoutEarly1.setForeground(new java.awt.Color(255, 255, 255));
        CheckoutEarly1.setText("Check out Early:");
        CheckoutEarlyPanel.add(CheckoutEarly1, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 14, -1, -1));

        CheckoutEarlyLbl.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        CheckoutEarlyLbl.setForeground(new java.awt.Color(255, 255, 255));
        CheckoutEarlyLbl.setText("00:00");
        CheckoutEarlyPanel.add(CheckoutEarlyLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 90, -1, -1));

        centerPanel.add(CheckoutEarlyPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 146, 300, 134));

        idPanel.setBackground(new java.awt.Color(0, 191, 255));
        idPanel.setPreferredSize(new java.awt.Dimension(70, 134));
        idPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        id1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        id1.setForeground(new java.awt.Color(255, 255, 255));
        id1.setText("Id:");
        idPanel.add(id1, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 14, -1, -1));

        idLbl.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        idLbl.setForeground(new java.awt.Color(255, 255, 255));
        idLbl.setText("02");
        idPanel.add(idLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, -1, -1));

        centerPanel.add(idPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 6, 220, 130));

        exitLbl.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        exitLbl.setForeground(new java.awt.Color(51, 51, 51));
        exitLbl.setText("X");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(centerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(exitLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(exitLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(centerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(kqcheckout.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(kqcheckout.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(kqcheckout.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(kqcheckout.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new kqcheckout().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CheckoutEarly1;
    private javax.swing.JLabel CheckoutEarlyLbl;
    private javax.swing.JPanel CheckoutEarlyPanel;
    private javax.swing.JPanel centerPanel;
    private javax.swing.JLabel checkinAt1;
    private javax.swing.JLabel checkinAtLbl;
    private javax.swing.JPanel checkinAtPanel;
    private javax.swing.JLabel checkinLate1;
    private javax.swing.JLabel checkinLateLbl;
    private javax.swing.JPanel checkinLatePanel;
    private javax.swing.JPanel checkoutAt;
    private javax.swing.JLabel checkoutAt1;
    private javax.swing.JLabel checkoutAtLbl;
    private javax.swing.JLabel exitLbl;
    private javax.swing.JLabel goOut1;
    private javax.swing.JPanel goOutPanel;
    private javax.swing.JLabel goOutTimesLbl;
    private javax.swing.JLabel id1;
    private javax.swing.JLabel idLbl;
    private javax.swing.JPanel idPanel;
    private javax.swing.JLabel time1;
    private javax.swing.JLabel totalGoOutTime1;
    private javax.swing.JLabel totalGoOutTimeLbl;
    private javax.swing.JPanel totalGoOutTimePanel;
    private javax.swing.JLabel totalWorkTime1;
    private javax.swing.JLabel totalWorkTimeLbl;
    private javax.swing.JPanel totalWorkTimePanel;
    // End of variables declaration//GEN-END:variables
}
