/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import dao.HrDao;
import dao.JobDao;
import pojo.CurrentUser;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Neel_Esh
 */
public class HrEditQuizFrame extends javax.swing.JFrame {

    /**
     * Creates new form HrEditQuizFrame
     */
    DefaultTableModel model;
    String companyName;
    public HrEditQuizFrame() {
        initComponents();
        nameLbl.setText(CurrentUser.name);
        model=(DefaultTableModel)AllJobTbl.getModel();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        insertData();
    }
    
    void insertData()
    {
        try
        {
            companyName=HrDao.getCompanyNameById(CurrentUser.id.trim());
            ResultSet rs=JobDao.getAllOpenJobByCompanyName(companyName);
            int flag=0;
            for(int i=0;rs.next();i++)
            {   
                flag=flag+1;
                for(int j=0;j<4;j++)
                {
                   AllJobTbl.setValueAt(rs.getString(j+1),i,j);
                }
            }
            if(flag==0)
            {
                JOptionPane.showMessageDialog(null,"No record on your Email","SomeThing Went Wrong ",JOptionPane.WARNING_MESSAGE);
                
            }
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null,"DB-error while Loading data","Error",JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }      
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
        editQuizBtn = new javax.swing.JButton();
        backBtn = new javax.swing.JButton();
        nameLbl = new javax.swing.JLabel();
        UpperSeperator = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        logOutBtn = new javax.swing.JButton();
        AddNewHrLBL = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        nameLbl1 = new javax.swing.JLabel();
        DipperSeperator = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        AllJobTbl = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(243, 246, 254));
        jPanel1.setMinimumSize(new java.awt.Dimension(1080, 720));
        jPanel1.setPreferredSize(new java.awt.Dimension(1080, 720));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        editQuizBtn.setBackground(new java.awt.Color(173, 192, 234));
        editQuizBtn.setText("Edit Quiz");
        editQuizBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editQuizBtnActionPerformed(evt);
            }
        });
        jPanel1.add(editQuizBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 670, 250, 30));

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
        AddNewHrLBL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/new/setQuiz.png"))); // NOI18N
        AddNewHrLBL.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel1.add(AddNewHrLBL, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 380, 210, 220));

        jLabel4.setFont(new java.awt.Font("Noteworthy", 1, 24)); // NOI18N
        jLabel4.setText("Welcome , ");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 265, 110, 40));

        nameLbl1.setFont(new java.awt.Font("Noteworthy", 1, 18)); // NOI18N
        nameLbl1.setText("All Job's -");
        jPanel1.add(nameLbl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 360, 110, 30));
        jPanel1.add(DipperSeperator, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 650, 1030, 20));

        AllJobTbl.setBackground(new java.awt.Color(173, 192, 234));
        AllJobTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, "", ""},
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
                "Job-Id", "Job Title", "Skills", "Status"
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
        AllJobTbl.setShowGrid(true);
        AllJobTbl.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(AllJobTbl);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 390, 720, 230));

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

    private void editQuizBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editQuizBtnActionPerformed
        // TODO add your handling code here:
        int row=AllJobTbl.getSelectedRow();
        if(row!=-1)
        {
            String jobId=(String)AllJobTbl.getValueAt(row,0).toString().trim();
            int status=Integer.parseInt((String)AllJobTbl.getValueAt(row,3).toString().trim());
            if(status==1)
            {  
                new HrEditQuizFrame1(jobId).setVisible(true);
                this.dispose();
            }
            else if(status==0)
            {
                JOptionPane.showMessageDialog(null,"Please select Quiz first","Error",JOptionPane.ERROR_MESSAGE);
                return;
            }
            else
            {
                JOptionPane.showMessageDialog(null,"The job is Closed now !!!","Error",JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Please select any row","Error",JOptionPane.ERROR_MESSAGE);
            return;
        }
    }//GEN-LAST:event_editQuizBtnActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        // TODO add your handling code here:
        new HrJobOptionFrame().setVisible(true);
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
            java.util.logging.Logger.getLogger(HrEditQuizFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HrEditQuizFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HrEditQuizFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HrEditQuizFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HrEditQuizFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AddNewHrLBL;
    private javax.swing.JTable AllJobTbl;
    private javax.swing.JSeparator DipperSeperator;
    private javax.swing.JSeparator UpperSeperator;
    private javax.swing.JButton backBtn;
    private javax.swing.JButton editQuizBtn;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton logOutBtn;
    private javax.swing.JLabel nameLbl;
    private javax.swing.JLabel nameLbl1;
    // End of variables declaration//GEN-END:variables
}