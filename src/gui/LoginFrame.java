package gui;

import dao.HrDao;
import dao.ParticipantsDao;
import dao.UserDao;
import pojo.CurrentUser;
import pojo.LoginPojo;
import pojo.UserPojo;

import java.sql.SQLException;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Neel_Esh
 */
public class LoginFrame extends javax.swing.JFrame {

    
    private String userId;
    private String password;
    public LoginFrame() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    private String validateUser()
    {
        if(jrbAdmin.isSelected())
            return "Admin";
        else if(jrbHr.isSelected())
            return "Hr";
        else if(jrbUser.isSelected())
            return "Pt";
        else
            return null;             
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        txtMail = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        btnSignUp = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        txtPassword = new javax.swing.JPasswordField();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jrbAdmin = new javax.swing.JRadioButton();
        jrbHr = new javax.swing.JRadioButton();
        jrbUser = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        btnLogin = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(243, 246, 254));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtMail.setBackground(new java.awt.Color(173, 192, 234));
        txtMail.setFont(new java.awt.Font("Heiti TC", 1, 14)); // NOI18N
        txtMail.setBorder(null);
        txtMail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMailActionPerformed(evt);
            }
        });
        jPanel1.add(txtMail, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 265, 400, 30));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 440, 420, 20));

        btnSignUp.setBackground(new java.awt.Color(173, 192, 234));
        btnSignUp.setText("Sign up");
        btnSignUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSignUpActionPerformed(evt);
            }
        });
        jPanel1.add(btnSignUp, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 550, 160, 30));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 520, 420, 10));

        txtPassword.setBackground(new java.awt.Color(173, 192, 234));
        txtPassword.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txtPassword.setBorder(null);
        jPanel1.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 385, 400, 30));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/tg_image_4018958162.png"))); // NOI18N
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 380, -1, -1));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/tg_image_4018958162.png"))); // NOI18N
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 260, -1, -1));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 560, -1, -1));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/homePage.jpg"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 120, 610, 440));

        jLabel6.setFont(new java.awt.Font("Heiti SC", 1, 18)); // NOI18N
        jLabel6.setText("Email or User Id :");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 220, -1, -1));

        jLabel4.setFont(new java.awt.Font("Heiti SC", 1, 18)); // NOI18N
        jLabel4.setText("Select User Type :-");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 460, -1, -1));

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 560, -1, -1));

        jrbAdmin.setBackground(new java.awt.Color(243, 246, 254));
        buttonGroup1.add(jrbAdmin);
        jrbAdmin.setText("Admin");
        jPanel1.add(jrbAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 485, 100, -1));

        jrbHr.setBackground(new java.awt.Color(243, 246, 254));
        buttonGroup1.add(jrbHr);
        jrbHr.setText("Company HR");
        jrbHr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbHrActionPerformed(evt);
            }
        });
        jPanel1.add(jrbHr, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 485, 130, -1));

        jrbUser.setBackground(new java.awt.Color(243, 246, 254));
        buttonGroup1.add(jrbUser);
        jrbUser.setText("User");
        jPanel1.add(jrbUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 485, 80, -1));

        jLabel7.setFont(new java.awt.Font("Heiti SC", 1, 18)); // NOI18N
        jLabel7.setText("Password :");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 340, -1, -1));

        btnLogin.setBackground(new java.awt.Color(173, 192, 234));
        btnLogin.setText("Login ");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        jPanel1.add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 550, 160, 30));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/transparent logo.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 180, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtMailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMailActionPerformed

    private void jrbHrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbHrActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jrbHrActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        
        if(!validateInputs())
        {
            JOptionPane.showMessageDialog(null,"Please Fill all values","Error",JOptionPane.ERROR_MESSAGE);
            return;
        }
        else
        {
            UserPojo user=new UserPojo();
            user.setUserId(userId.toUpperCase().trim());
            user.setPassword(password);
            String type=validateUser();
            
            if(type!=null)
            {
                user.setType(type);
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Please Select user Type","Error",JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            try
            {
                if(UserDao.validateUser(user))
                {
                    if(CurrentUser.getType().equals("Admin"))
                    {
                        JOptionPane.showMessageDialog(null,"Welcome Admin, "+CurrentUser.getName(),"Success",JOptionPane.INFORMATION_MESSAGE);
                        new AdminOptionFrame().setVisible(true);
                        this.dispose();
                    }
                    else if(CurrentUser.getType().equals("Hr"))
                    {
                        JOptionPane.showMessageDialog(null,"Welcome Hr, "+CurrentUser.getName(),"Success",JOptionPane.INFORMATION_MESSAGE);
                        new HrOptionFrame().setVisible(true);
                        this.dispose();
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"Welcome User, "+CurrentUser.getName(),"Success",JOptionPane.INFORMATION_MESSAGE);
                        new ParticipantsOptionFrame().setVisible(true);
                        this.dispose();
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Wrong UserId or Password or UserType or Not an active user","Error",JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
            catch(SQLException ex)
            {
                JOptionPane.showMessageDialog(null,"DB-error Login unsucessful","Error",JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
                return;
            }
            
        }

    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnSignUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignUpActionPerformed
        // TODO add your handling code here:
        new SignUpFrame().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnSignUpActionPerformed

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
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginFrame().setVisible(true);
            }
        });
    }

    public boolean validateInputs()
    {
        
        userId=txtMail.getText();
        char[] pwd=txtPassword.getPassword();
        if(userId.isEmpty()|| pwd.length==0)
               return false;
        password=String.valueOf(pwd);
        return true;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnSignUp;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JRadioButton jrbAdmin;
    private javax.swing.JRadioButton jrbHr;
    private javax.swing.JRadioButton jrbUser;
    private javax.swing.JTextField txtMail;
    private javax.swing.JPasswordField txtPassword;
    // End of variables declaration//GEN-END:variables
}