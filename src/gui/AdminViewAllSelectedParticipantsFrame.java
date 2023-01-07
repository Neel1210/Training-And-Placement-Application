/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import dao.HrDao;
import dao.JobDao;
import dao.ParticipantsDao;
import dao.ResultsDao;
import pojo.CurrentUser;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Neel_Esh
 */
public class AdminViewAllSelectedParticipantsFrame extends javax.swing.JFrame {

    /**
     * Creates new form AdminViewAllSelectedParticipantsFrame
     */
    int per=5;
    DefaultTableModel model;
    public AdminViewAllSelectedParticipantsFrame() {
        initComponents();
        model=(DefaultTableModel)allPtTbl.getModel();
        this.setLocationRelativeTo(null);
        nameLbl.setText(CurrentUser.name);
        setCompanyNameJCbx();
        insertData();
    }
    
    void setCompanyNameJCbx()
    {
        try
        {
            ResultSet rs=HrDao.getAllCompanyName();
            int i=0;
            companyNameJCBx.removeAllItems();
            while(rs.next())
            {
                companyNameJCBx.insertItemAt(rs.getString(1),i);
                i++;
            }
            if(i==0)
                companyNameJCBx.insertItemAt("No-Company",0);
            companyNameJCBx.setSelectedIndex(0);
            
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null,"DB-error while Loading data","Error",JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
        
    }
    
    void setJobIdJCbx()
    {
        try
        {
            ResultSet rs=JobDao.getAllJobByCompanyName((String)companyNameJCBx.getSelectedItem());
            int i=0;
            jobIdJCBx.removeAllItems();
            while(rs.next())
            {
                jobIdJCBx.insertItemAt(rs.getString(1),i);
                i++;
            }
            if(i==0)
                jobIdJCBx.insertItemAt("No-Job-Id",0);
            jobIdJCBx.setSelectedIndex(0);
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null,"DB-error while Loading data","Error",JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
        
    }
    
    void insertData()
    {
        try
        {
            int ii=0;
            ResultSet rs=ResultsDao.getAllQualifiedParticipantIdByCompanyName((String)companyNameJCBx.getSelectedItem(),per,(String)jobIdJCBx.getSelectedItem());
            while(rs.next())
            {
                
                ResultSet rs1=ParticipantsDao.viewParticipantsById1(rs.getString(1));
                int flag=0;
                for(int i=ii;rs1.next();i++)
                {   
                    ii++;
                    flag=flag+1;
                    for(int j=0;j<4;j++)
                    {
                        allPtTbl.setValueAt(rs1.getString(j+1),i,j);
                    }
                }
                if(flag==0)
                {
                    JOptionPane.showMessageDialog(null,"No one applied for your company yet !!!","SomeThing Went Wrong ",JOptionPane.WARNING_MESSAGE);
                    return;
                }
            }    
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null,"DB-error while Loading data","Error",JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }
    
    int getJCBResult()
    {
        if(perJCBx.getSelectedIndex()==0)
            return 5;
        else if(perJCBx.getSelectedIndex()==1)
            return 49;
        else
            return 74;
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
        backBtn = new javax.swing.JButton();
        nameLbl = new javax.swing.JLabel();
        UpperSeperator = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        logOutBtn = new javax.swing.JButton();
        AddNewHrLBL = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        nameLbl1 = new javax.swing.JLabel();
        DipperSeperator = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        allPtTbl = new javax.swing.JTable();
        jobIdJCBx = new javax.swing.JComboBox<>();
        perJCBx = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        companyNameJCBx = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(243, 246, 254));
        jPanel1.setMinimumSize(new java.awt.Dimension(1080, 720));
        jPanel1.setPreferredSize(new java.awt.Dimension(1080, 720));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        AddNewHrLBL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/viewAllParticipants.png"))); // NOI18N
        AddNewHrLBL.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel1.add(AddNewHrLBL, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 380, 210, 220));

        jLabel4.setFont(new java.awt.Font("Noteworthy", 1, 24)); // NOI18N
        jLabel4.setText("Welcome , ");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 265, 110, 40));

        nameLbl1.setFont(new java.awt.Font("Noteworthy", 1, 18)); // NOI18N
        nameLbl1.setText("All Qualified Participants -");
        jPanel1.add(nameLbl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 360, 220, 30));
        jPanel1.add(DipperSeperator, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 650, 1030, 20));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/transparent logo.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 180, -1));

        allPtTbl.setBackground(new java.awt.Color(173, 192, 234));
        allPtTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"", "", "", null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Participants Id", "Name", "Skills", "Qualifications"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        allPtTbl.setRowSelectionAllowed(false);
        allPtTbl.setShowGrid(true);
        allPtTbl.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(allPtTbl);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 400, 740, 230));

        jobIdJCBx.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "<50%", "<75%" }));
        jobIdJCBx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jobIdJCBxActionPerformed(evt);
            }
        });
        jPanel1.add(jobIdJCBx, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 360, 130, -1));

        perJCBx.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "<50%", "<75%" }));
        perJCBx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                perJCBxActionPerformed(evt);
            }
        });
        jPanel1.add(perJCBx, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 360, 70, -1));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Job-Id");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 340, 50, -1));

        jLabel6.setText("Percent <");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 340, -1, -1));

        jLabel7.setText("Company Name");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 340, -1, -1));

        companyNameJCBx.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "<50%", "<75%" }));
        companyNameJCBx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                companyNameJCBxActionPerformed(evt);
            }
        });
        jPanel1.add(companyNameJCBx, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 360, 130, -1));

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

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        // TODO add your handling code here:
        new AdminOptionFrame().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backBtnActionPerformed

    private void logOutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logOutBtnActionPerformed
        // TODO add your handling code here:
        new LoginFrame().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_logOutBtnActionPerformed

    private void jobIdJCBxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jobIdJCBxActionPerformed
        // TODO add your handling code here:
        per=getJCBResult();
        model.setRowCount(0);
        model.setRowCount(13);
        insertData();
    }//GEN-LAST:event_jobIdJCBxActionPerformed

    private void perJCBxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_perJCBxActionPerformed
        // TODO add your handling code here:
        per=getJCBResult();
        model.setRowCount(0);
        model.setRowCount(13);
        insertData();
    }//GEN-LAST:event_perJCBxActionPerformed

    private void companyNameJCBxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_companyNameJCBxActionPerformed
        // TODO add your handling code here:
        setJobIdJCbx();
    }//GEN-LAST:event_companyNameJCBxActionPerformed

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
            java.util.logging.Logger.getLogger(AdminViewAllSelectedParticipantsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminViewAllSelectedParticipantsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminViewAllSelectedParticipantsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminViewAllSelectedParticipantsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminViewAllSelectedParticipantsFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AddNewHrLBL;
    private javax.swing.JSeparator DipperSeperator;
    private javax.swing.JSeparator UpperSeperator;
    private javax.swing.JTable allPtTbl;
    private javax.swing.JButton backBtn;
    private javax.swing.JComboBox<String> companyNameJCBx;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JComboBox<String> jobIdJCBx;
    private javax.swing.JButton logOutBtn;
    private javax.swing.JLabel nameLbl;
    private javax.swing.JLabel nameLbl1;
    private javax.swing.JComboBox<String> perJCBx;
    // End of variables declaration//GEN-END:variables
}
