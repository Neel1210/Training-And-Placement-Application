/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import dao.HrDao;
import dao.UserDao;
import pojo.UserPojo;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import pojo.CurrentUser;

/**
 *
 * @author Neel_Esh
 */
public class AdminModifyHrFrame extends javax.swing.JFrame {

    /**
     * Creates new form AdminModifyHrFrame
     */
    UserPojo user;
    public AdminModifyHrFrame() {
        
        initComponents();
        this.setLocationRelativeTo(null);
        nameLbl.setText(CurrentUser.getName());
    }
    
    boolean validateInputs()
    {
        if(newPwdTxt.getText().equalsIgnoreCase(cnfPwdTxt.getText()))
            return true;
        return false;
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
        userIdTxt = new javax.swing.JTextField();
        hrIdTxt = new javax.swing.JTextField();
        cnfPwdTxt = new javax.swing.JPasswordField();
        newPwdTxt = new javax.swing.JPasswordField();
        modifyHrBtn = new javax.swing.JButton();
        backBtn = new javax.swing.JButton();
        nameLbl = new javax.swing.JLabel();
        UpperSeperator = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        logOutBtn = new javax.swing.JButton();
        AddNewHrLBL = new javax.swing.JLabel();
        passBar = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        passLbl = new javax.swing.JLabel();
        mailLbl = new javax.swing.JLabel();
        mailBar = new javax.swing.JLabel();
        hrNameLbl = new javax.swing.JLabel();
        mobileBar = new javax.swing.JLabel();
        cnfPassLbl = new javax.swing.JLabel();
        cnfPassBar = new javax.swing.JLabel();
        DipperSeperator = new javax.swing.JSeparator();
        MobLbl1 = new javax.swing.JLabel();
        HrLbl = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(243, 246, 254));
        jPanel1.setMinimumSize(new java.awt.Dimension(1080, 720));
        jPanel1.setPreferredSize(new java.awt.Dimension(1080, 720));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        userIdTxt.setBackground(new java.awt.Color(173, 192, 234));
        userIdTxt.setFont(new java.awt.Font("Heiti TC", 1, 18)); // NOI18N
        userIdTxt.setBorder(null);
        userIdTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userIdTxtActionPerformed(evt);
            }
        });
        jPanel1.add(userIdTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 395, 310, 30));

        hrIdTxt.setEditable(false);
        hrIdTxt.setBackground(new java.awt.Color(173, 192, 234));
        hrIdTxt.setFont(new java.awt.Font("Heiti TC", 1, 18)); // NOI18N
        hrIdTxt.setBorder(null);
        hrIdTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hrIdTxtActionPerformed(evt);
            }
        });
        jPanel1.add(hrIdTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 395, 310, 30));

        cnfPwdTxt.setBackground(new java.awt.Color(173, 192, 234));
        cnfPwdTxt.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        cnfPwdTxt.setBorder(null);
        jPanel1.add(cnfPwdTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(705, 565, 300, 30));

        newPwdTxt.setBackground(new java.awt.Color(173, 192, 234));
        newPwdTxt.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        newPwdTxt.setBorder(null);
        jPanel1.add(newPwdTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 565, 300, 30));

        modifyHrBtn.setBackground(new java.awt.Color(173, 192, 234));
        modifyHrBtn.setText("Modify Changes of HR");
        modifyHrBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifyHrBtnActionPerformed(evt);
            }
        });
        jPanel1.add(modifyHrBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 670, 250, 30));

        backBtn.setBackground(new java.awt.Color(173, 192, 234));
        backBtn.setText("Back");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });
        jPanel1.add(backBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 670, 110, -1));

        nameLbl.setFont(new java.awt.Font("Noteworthy", 1, 24)); // NOI18N
        nameLbl.setText("Neelesh");
        jPanel1.add(nameLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 265, 190, 40));
        jPanel1.add(UpperSeperator, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, 970, 10));

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/World-Map.png"))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 970, 200));

        logOutBtn.setBackground(new java.awt.Color(173, 192, 234));
        logOutBtn.setText("Logout");
        logOutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logOutBtnActionPerformed(evt);
            }
        });
        jPanel1.add(logOutBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 670, 110, -1));

        AddNewHrLBL.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AddNewHrLBL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/modify-emp.png"))); // NOI18N
        AddNewHrLBL.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel1.add(AddNewHrLBL, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 380, 210, 220));

        passBar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        passBar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/TextFieldPic.png"))); // NOI18N
        jPanel1.add(passBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 560, 340, 40));

        jLabel4.setFont(new java.awt.Font("Noteworthy", 1, 24)); // NOI18N
        jLabel4.setText("Welcome , ");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 265, 110, 40));

        passLbl.setFont(new java.awt.Font("Noteworthy", 1, 18)); // NOI18N
        passLbl.setText("New Password");
        jPanel1.add(passLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 530, 120, 30));

        mailLbl.setFont(new java.awt.Font("Noteworthy", 1, 18)); // NOI18N
        mailLbl.setText("Hr id");
        jPanel1.add(mailLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 360, 110, 30));

        mailBar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mailBar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/TextFieldPic.png"))); // NOI18N
        jPanel1.add(mailBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 390, 340, 40));

        hrNameLbl.setFont(new java.awt.Font("Noteworthy", 1, 18)); // NOI18N
        jPanel1.add(hrNameLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 460, 210, 30));

        mobileBar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mobileBar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/TextFieldPic.png"))); // NOI18N
        jPanel1.add(mobileBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 390, 340, 40));

        cnfPassLbl.setFont(new java.awt.Font("Noteworthy", 1, 18)); // NOI18N
        cnfPassLbl.setText("Confirm Password");
        jPanel1.add(cnfPassLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 530, 150, 30));

        cnfPassBar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cnfPassBar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/TextFieldPic.png"))); // NOI18N
        jPanel1.add(cnfPassBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 560, 340, 40));
        jPanel1.add(DipperSeperator, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 650, 1030, 20));

        MobLbl1.setFont(new java.awt.Font("Noteworthy", 1, 18)); // NOI18N
        MobLbl1.setText("User id");
        jPanel1.add(MobLbl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 360, 110, 30));

        HrLbl.setFont(new java.awt.Font("Noteworthy", 1, 18)); // NOI18N
        HrLbl.setText("Hr Name -");
        jPanel1.add(HrLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 460, 90, 30));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 492, 310, 10));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/transparent logo.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 180, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void userIdTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userIdTxtActionPerformed
        // TODO add your handling code here:6
        try
        {
            user=UserDao.getDetailsByUserId(userIdTxt.getText().toUpperCase().trim());
            if(user==null)
            {
                JOptionPane.showMessageDialog(null,"DB-Error while retreving data","Error",JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            userIdTxt.setText(user.getUserId());
            hrIdTxt.setText(user.getId());
            hrNameLbl.setText(user.getName());
            return;
        }
       catch(SQLException ex)
       {
           JOptionPane.showMessageDialog(null,"DB-Error while retreving data","Error",JOptionPane.INFORMATION_MESSAGE);
           ex.printStackTrace();
       }
       catch(NullPointerException ex)
       {    
           JOptionPane.showMessageDialog(null,"DB-Error while retreving data","Error",JOptionPane.INFORMATION_MESSAGE);
           ex.printStackTrace();
       }
    }//GEN-LAST:event_userIdTxtActionPerformed

    private void hrIdTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hrIdTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hrIdTxtActionPerformed

    private void modifyHrBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifyHrBtnActionPerformed
        // TODO add your handling code here:
        if(validateInputs())
        {   
            
            user.setPassword(cnfPwdTxt.getText());
            try
            {
                if(HrDao.modifyHr(user))
                {
                    JOptionPane.showMessageDialog(null,"Changes Done successfully","Success",JOptionPane.INFORMATION_MESSAGE);
                    userIdTxt.setText("");
                    hrIdTxt.setText("");
                    hrNameLbl.setText("");
                    cnfPwdTxt.setText("");
                    newPwdTxt.setText("");
                    return;
                }
            }
            catch(SQLException ex)   
            {
                JOptionPane.showMessageDialog(null,"Changes Done successfully","Success",JOptionPane.INFORMATION_MESSAGE);
                ex.printStackTrace();
            }
            
        }
    }//GEN-LAST:event_modifyHrBtnActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        // TODO add your handling code here:
        new AdminHrModule().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backBtnActionPerformed

    private void logOutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logOutBtnActionPerformed
        // TODO add your handling code here:
        new LoginFrame().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_logOutBtnActionPerformed

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
            java.util.logging.Logger.getLogger(AdminModifyHrFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminModifyHrFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminModifyHrFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminModifyHrFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminModifyHrFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AddNewHrLBL;
    private javax.swing.JSeparator DipperSeperator;
    private javax.swing.JLabel HrLbl;
    private javax.swing.JLabel MobLbl1;
    private javax.swing.JSeparator UpperSeperator;
    private javax.swing.JButton backBtn;
    private javax.swing.JLabel cnfPassBar;
    private javax.swing.JLabel cnfPassLbl;
    private javax.swing.JPasswordField cnfPwdTxt;
    private javax.swing.JTextField hrIdTxt;
    private javax.swing.JLabel hrNameLbl;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton logOutBtn;
    private javax.swing.JLabel mailBar;
    private javax.swing.JLabel mailLbl;
    private javax.swing.JLabel mobileBar;
    private javax.swing.JButton modifyHrBtn;
    private javax.swing.JLabel nameLbl;
    private javax.swing.JPasswordField newPwdTxt;
    private javax.swing.JLabel passBar;
    private javax.swing.JLabel passLbl;
    private javax.swing.JTextField userIdTxt;
    // End of variables declaration//GEN-END:variables
}
