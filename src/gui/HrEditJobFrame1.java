/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import dao.JobDao;
import pojo.CurrentUser;
import pojo.JobPojo;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Neel_Esh
 */
public class HrEditJobFrame1 extends javax.swing.JFrame {

    /**
     * Creates new form EditJobFrame1
     */
    public HrEditJobFrame1() {
        initComponents();
        this.setLocationRelativeTo(null);
        
    }
    public HrEditJobFrame1(JobPojo job)
    {
        initComponents();
        this.setLocationRelativeTo(null);
        nameLbl.setText(CurrentUser.name);
        insertData(job);
        
    }
    void insertData(JobPojo job)
    {
        jobIdLbl.setText(job.getJobId());
        jobTitleTxt.setText(job.getJobTitle());
        companyNameTxt.setText(job.getHrId());
        String[] tags=job.getTags().split(",");
        skill1Txt.setText(tags[0]);
        skill2Txt.setText(tags[1]);
        skill3Txt.setText(tags[2]);
        skill4Txt.setText(tags[3]);
   }
    boolean validateInputs()
    {
        if(jobTitleTxt.getText().equals("") || companyNameTxt.getText().equals("") || skill1Txt.getText().equals("")|| skill2Txt.getText().equals("")|| skill3Txt.getText().equals("")|| skill4Txt.getText().equals(""))
            return false;
        return true;         
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
        jLabel10 = new javax.swing.JLabel();
        skill4Txt = new javax.swing.JTextField();
        jobTitleTxt = new javax.swing.JTextField();
        nameLbl = new javax.swing.JLabel();
        companyNameTxt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        backBtn = new javax.swing.JButton();
        logOutBtn = new javax.swing.JButton();
        editJobBtn = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        DipperSeperator1 = new javax.swing.JSeparator();
        DipperSeperator2 = new javax.swing.JSeparator();
        skill1Txt = new javax.swing.JTextField();
        skill2Txt = new javax.swing.JTextField();
        skill3Txt = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        DipperSeperator3 = new javax.swing.JSeparator();
        jobIdLbl = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(243, 246, 254));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Noteworthy", 1, 16)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Company Name ");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 400, 110, 30));

        skill4Txt.setBackground(new java.awt.Color(173, 192, 234));
        skill4Txt.setFont(new java.awt.Font("Heiti TC", 1, 18)); // NOI18N
        skill4Txt.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.darkGray, java.awt.Color.gray));
        jPanel1.add(skill4Txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 590, 190, 30));

        jobTitleTxt.setBackground(new java.awt.Color(173, 192, 234));
        jobTitleTxt.setFont(new java.awt.Font("Heiti TC", 1, 18)); // NOI18N
        jobTitleTxt.setBorder(null);
        jPanel1.add(jobTitleTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 445, 310, 30));

        nameLbl.setFont(new java.awt.Font("Noteworthy", 1, 24)); // NOI18N
        nameLbl.setText("Neelesh");
        jPanel1.add(nameLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 265, 190, 40));

        companyNameTxt.setEditable(false);
        companyNameTxt.setBackground(new java.awt.Color(173, 192, 234));
        companyNameTxt.setFont(new java.awt.Font("Heiti TC", 1, 18)); // NOI18N
        companyNameTxt.setBorder(null);
        jPanel1.add(companyNameTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 445, 310, 30));

        jLabel2.setFont(new java.awt.Font("Noteworthy", 1, 16)); // NOI18N
        jLabel2.setText("Skills Required :-");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 490, 130, 30));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, 970, 10));

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/World-Map.png"))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 970, 200));

        backBtn.setBackground(new java.awt.Color(173, 192, 234));
        backBtn.setText("Back");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });
        jPanel1.add(backBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 670, 110, -1));

        logOutBtn.setBackground(new java.awt.Color(173, 192, 234));
        logOutBtn.setText("Logout");
        logOutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logOutBtnActionPerformed(evt);
            }
        });
        jPanel1.add(logOutBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 670, 110, -1));

        editJobBtn.setBackground(new java.awt.Color(173, 192, 234));
        editJobBtn.setText("Edit Job");
        editJobBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editJobBtnActionPerformed(evt);
            }
        });
        jPanel1.add(editJobBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 670, 250, 30));

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/TextFieldPic.png"))); // NOI18N
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 440, 340, 40));

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/TextFieldPic.png"))); // NOI18N
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 440, 340, 40));

        jLabel4.setFont(new java.awt.Font("Noteworthy", 1, 24)); // NOI18N
        jLabel4.setText("Welcome , ");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 265, 110, 40));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/JobPng.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 320, 290, 320));
        jPanel1.add(DipperSeperator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 650, 1030, 20));
        jPanel1.add(DipperSeperator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 520, 700, 20));

        skill1Txt.setBackground(new java.awt.Color(173, 192, 234));
        skill1Txt.setFont(new java.awt.Font("Heiti TC", 1, 18)); // NOI18N
        skill1Txt.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.darkGray, java.awt.Color.gray));
        jPanel1.add(skill1Txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 540, 190, 30));

        skill2Txt.setBackground(new java.awt.Color(173, 192, 234));
        skill2Txt.setFont(new java.awt.Font("Heiti TC", 1, 18)); // NOI18N
        skill2Txt.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.darkGray, java.awt.Color.gray));
        jPanel1.add(skill2Txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 540, 190, 30));

        skill3Txt.setBackground(new java.awt.Color(173, 192, 234));
        skill3Txt.setFont(new java.awt.Font("Heiti TC", 1, 18)); // NOI18N
        skill3Txt.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.darkGray, java.awt.Color.gray));
        jPanel1.add(skill3Txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 590, 190, 30));

        jLabel7.setFont(new java.awt.Font("Noteworthy", 1, 16)); // NOI18N
        jLabel7.setText("Job Title");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 410, 80, 20));
        jPanel1.add(DipperSeperator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 400, 700, 10));

        jobIdLbl.setFont(new java.awt.Font("Noteworthy", 1, 16)); // NOI18N
        jPanel1.add(jobIdLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 370, 150, 30));

        jLabel9.setFont(new java.awt.Font("Noteworthy", 1, 16)); // NOI18N
        jLabel9.setText("Job - ID :");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 370, 70, 30));

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

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        // TODO add your handling code here:
        new HrEditJobFrame().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backBtnActionPerformed

    private void logOutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logOutBtnActionPerformed
        // TODO add your handling code here:
        new LoginFrame().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_logOutBtnActionPerformed

    private void editJobBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editJobBtnActionPerformed
        // TODO add your handling code here:
        if(validateInputs())
        {
            JobPojo job=new JobPojo();
            job.setHrId(companyNameTxt.getText().trim());
            job.setJobId(jobIdLbl.getText().trim());
            job.setJobTitle(jobTitleTxt.getText().trim());
            String skills=skill1Txt.getText().trim()+","+skill2Txt.getText().trim()+","+skill3Txt.getText().trim()+","+skill4Txt.getText().trim();
            System.out.println(skills);
            job.setTags(skills);
            
            try
            {
                if(JobDao.editJob(job))
                {
                    JOptionPane.showMessageDialog(null,"Job Edited SuccessFully","Done",JOptionPane.INFORMATION_MESSAGE);
                    new HrEditJobFrame().setVisible(true);
                    this.dispose();
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Something went wrong\nwhile editing a job","Error",JOptionPane.WARNING_MESSAGE);
                    return;
                }
            }
            catch(SQLException ex)
            {
                JOptionPane.showMessageDialog(null,"Error While editing a job","DB_Error",JOptionPane.INFORMATION_MESSAGE);
                ex.printStackTrace();
                return;
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Please fill all fields","Warning",JOptionPane.WARNING_MESSAGE);
            return;
        }
    }//GEN-LAST:event_editJobBtnActionPerformed

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
            java.util.logging.Logger.getLogger(HrEditJobFrame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HrEditJobFrame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HrEditJobFrame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HrEditJobFrame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HrEditJobFrame1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSeparator DipperSeperator1;
    private javax.swing.JSeparator DipperSeperator2;
    private javax.swing.JSeparator DipperSeperator3;
    private javax.swing.JButton backBtn;
    private javax.swing.JTextField companyNameTxt;
    private javax.swing.JButton editJobBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel jobIdLbl;
    private javax.swing.JTextField jobTitleTxt;
    private javax.swing.JButton logOutBtn;
    private javax.swing.JLabel nameLbl;
    private javax.swing.JTextField skill1Txt;
    private javax.swing.JTextField skill2Txt;
    private javax.swing.JTextField skill3Txt;
    private javax.swing.JTextField skill4Txt;
    // End of variables declaration//GEN-END:variables
}
