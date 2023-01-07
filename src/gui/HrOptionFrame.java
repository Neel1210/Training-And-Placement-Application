/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import pojo.CurrentUser;

/**
 *
 * @author Neel_Esh
 */
public class HrOptionFrame extends javax.swing.JFrame {

    /**
     * Creates new form HrOptionFrame
     */
    public HrOptionFrame() {
        initComponents();
        this.setLocationRelativeTo(null);
        nameLbl.setText(CurrentUser.getName());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        viewAllParticipnatsBtn = new javax.swing.JButton();
        viewAllQualifiedParticipantsBtn = new javax.swing.JButton();
        jobModuleBtn = new javax.swing.JButton();
        logOutBtn = new javax.swing.JButton();
        nameLbl = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        viewAllOpenJobsBtn = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(243, 246, 254));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        viewAllParticipnatsBtn.setBackground(new java.awt.Color(173, 192, 234));
        viewAllParticipnatsBtn.setText("View All Participants");
        viewAllParticipnatsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewAllParticipnatsBtnActionPerformed(evt);
            }
        });
        jPanel1.add(viewAllParticipnatsBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 410, 300, 40));

        viewAllQualifiedParticipantsBtn.setBackground(new java.awt.Color(173, 192, 234));
        viewAllQualifiedParticipantsBtn.setText("View Test Result");
        viewAllQualifiedParticipantsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewAllQualifiedParticipantsBtnActionPerformed(evt);
            }
        });
        jPanel1.add(viewAllQualifiedParticipantsBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 500, 300, 40));

        jobModuleBtn.setBackground(new java.awt.Color(173, 192, 234));
        jobModuleBtn.setText("Job Module");
        jobModuleBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jobModuleBtnActionPerformed(evt);
            }
        });
        jPanel1.add(jobModuleBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 330, 300, 40));

        logOutBtn.setBackground(new java.awt.Color(173, 192, 234));
        logOutBtn.setText("Logout");
        logOutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logOutBtnActionPerformed(evt);
            }
        });
        jPanel1.add(logOutBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 660, 110, -1));

        nameLbl.setFont(new java.awt.Font("Noteworthy", 1, 24)); // NOI18N
        nameLbl.setText("Neelesh");
        jPanel1.add(nameLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 265, 190, 40));

        jLabel2.setFont(new java.awt.Font("Noteworthy", 1, 24)); // NOI18N
        jLabel2.setText("Welcome , ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 265, 110, 40));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, 970, 10));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/worlp-map-in-black-h9i.png"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 290, 590, 360));

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/World-Map.png"))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 970, 200));

        viewAllOpenJobsBtn.setBackground(new java.awt.Color(173, 192, 234));
        viewAllOpenJobsBtn.setText("View All Open Jobs");
        viewAllOpenJobsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewAllOpenJobsBtnActionPerformed(evt);
            }
        });
        jPanel1.add(viewAllOpenJobsBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 600, 300, 40));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/transparent logo.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 180, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1080, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void viewAllParticipnatsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewAllParticipnatsBtnActionPerformed
        // TODO add your handling code here:
        new HrViewAllParticipantsFrame().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_viewAllParticipnatsBtnActionPerformed

    private void viewAllQualifiedParticipantsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewAllQualifiedParticipantsBtnActionPerformed
        // TODO add your handling code here:
        new HrViewAllQualifiedParticipantsFrame().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_viewAllQualifiedParticipantsBtnActionPerformed

    private void jobModuleBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jobModuleBtnActionPerformed
        // TODO add your handling code here:
        new HrJobOptionFrame().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jobModuleBtnActionPerformed

    private void logOutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logOutBtnActionPerformed
        // TODO add your handling code here:
        new LoginFrame().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_logOutBtnActionPerformed

    private void viewAllOpenJobsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewAllOpenJobsBtnActionPerformed
        // TODO add your handling code here:
        new HrViewAllOpenJobFrame().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_viewAllOpenJobsBtnActionPerformed

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
            java.util.logging.Logger.getLogger(HrOptionFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HrOptionFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HrOptionFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HrOptionFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HrOptionFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton jobModuleBtn;
    private javax.swing.JButton logOutBtn;
    private javax.swing.JLabel nameLbl;
    private javax.swing.JButton viewAllOpenJobsBtn;
    private javax.swing.JButton viewAllParticipnatsBtn;
    private javax.swing.JButton viewAllQualifiedParticipantsBtn;
    // End of variables declaration//GEN-END:variables
}