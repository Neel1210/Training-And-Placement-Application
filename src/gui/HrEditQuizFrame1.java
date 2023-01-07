/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import dao.JobDao;
import dao.QuestionsDao;
import pojo.QuestionPojo;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Neel_Esh
 */
public class HrEditQuizFrame1 extends javax.swing.JFrame {

    /**
     * Creates new form HrEditOptionFrame1
     */
    
    List<QuestionPojo> list;
    QuestionPojo que;
    private String jobId;
    int counter=0,total=0;
    
    public HrEditQuizFrame1() {
        initComponents();
        queLbl.setText(""+(counter+1));
        this.setLocationRelativeTo(null);
    }
    
    public HrEditQuizFrame1(String jobId) {
        initComponents();
        this.jobId=jobId;
        queLbl.setText(""+(counter+1));
        this.setLocationRelativeTo(null); 
        getQuizInList();
    }

    boolean validateInput()
    {
        if(queTxt.getText().equals("") || op1Txt.getText().equals("") || op2Txt.getText().equals("") || op3Txt.getText().equals("") || op4Txt.getText().equals("") || correctOp.getSelectedIndex()==0)
            return false;
        return true;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        op4Txt = new javax.swing.JTextField();
        op1Txt = new javax.swing.JTextField();
        op2Txt = new javax.swing.JTextField();
        op3Txt = new javax.swing.JTextField();
        discardBtn = new javax.swing.JButton();
        queLbl = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        queTxt = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        correctOp = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        queBackBtn = new javax.swing.JButton();
        queNextBtn = new javax.swing.JButton();
        submitBtn = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(243, 246, 254));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        op4Txt.setBackground(new java.awt.Color(173, 192, 234));
        op4Txt.setFont(new java.awt.Font("Heiti TC", 1, 14)); // NOI18N
        op4Txt.setBorder(null);
        jPanel1.add(op4Txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 495, 300, 30));

        op1Txt.setBackground(new java.awt.Color(173, 192, 234));
        op1Txt.setFont(new java.awt.Font("Heiti TC", 1, 14)); // NOI18N
        op1Txt.setBorder(null);
        jPanel1.add(op1Txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 415, 300, 30));

        op2Txt.setBackground(new java.awt.Color(173, 192, 234));
        op2Txt.setFont(new java.awt.Font("Heiti TC", 1, 14)); // NOI18N
        op2Txt.setBorder(null);
        jPanel1.add(op2Txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 415, 300, 30));

        op3Txt.setBackground(new java.awt.Color(173, 192, 234));
        op3Txt.setFont(new java.awt.Font("Heiti TC", 1, 14)); // NOI18N
        op3Txt.setBorder(null);
        jPanel1.add(op3Txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 495, 300, 30));

        discardBtn.setBackground(new java.awt.Color(173, 192, 234));
        discardBtn.setText("Discard Paper");
        discardBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                discardBtnActionPerformed(evt);
            }
        });
        jPanel1.add(discardBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 660, 140, -1));

        queLbl.setFont(new java.awt.Font("Noteworthy", 1, 24)); // NOI18N
        jPanel1.add(queLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 230, 40, 40));

        jLabel2.setFont(new java.awt.Font("Noteworthy", 1, 24)); // NOI18N
        jLabel2.setText("Correct Option -");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 570, 180, 40));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 550, 980, 10));

        queTxt.setBackground(new java.awt.Color(173, 192, 234));
        queTxt.setColumns(20);
        queTxt.setFont(new java.awt.Font("Heiti TC", 1, 14)); // NOI18N
        queTxt.setRows(5);
        queTxt.setAutoscrolls(false);
        queTxt.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.darkGray, java.awt.Color.gray));
        jScrollPane1.setViewportView(queTxt);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 240, 860, 90));

        jLabel4.setFont(new java.awt.Font("Noteworthy", 1, 24)); // NOI18N
        jLabel4.setText("Que .");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, 60, 40));

        correctOp.setBackground(new java.awt.Color(173, 192, 234));
        correctOp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Choose correct Option", "Option 1", "Option 2", "Option 3", "Option 4" }));
        jPanel1.add(correctOp, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 580, 300, 30));

        jLabel5.setFont(new java.awt.Font("Noteworthy", 1, 14)); // NOI18N
        jLabel5.setText("Option 4 ");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 495, 60, 30));

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/TextFieldPic.png"))); // NOI18N
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 490, 350, 40));

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/TextFieldPic.png"))); // NOI18N
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 410, 350, 40));

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/TextFieldPic.png"))); // NOI18N
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 410, 350, 40));

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/TextFieldPic.png"))); // NOI18N
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 490, 350, 40));

        queBackBtn.setBackground(new java.awt.Color(173, 192, 234));
        queBackBtn.setText("Previous");
        queBackBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                queBackBtnActionPerformed(evt);
            }
        });
        jPanel1.add(queBackBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 660, 140, -1));

        queNextBtn.setBackground(new java.awt.Color(173, 192, 234));
        queNextBtn.setText("Next");
        queNextBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                queNextBtnActionPerformed(evt);
            }
        });
        jPanel1.add(queNextBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 660, 140, -1));

        submitBtn.setBackground(new java.awt.Color(173, 192, 234));
        submitBtn.setText("Submit");
        submitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitBtnActionPerformed(evt);
            }
        });
        jPanel1.add(submitBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 660, 140, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/transparent logo.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, 50));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 215, 970, 10));

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/World-Map.png"))); // NOI18N
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 990, 170));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 640, 980, 10));
        jPanel1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 390, 980, 10));

        jLabel7.setFont(new java.awt.Font("Noteworthy", 1, 24)); // NOI18N
        jLabel7.setText("Options -");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 350, 150, 40));

        jLabel8.setFont(new java.awt.Font("Noteworthy", 1, 14)); // NOI18N
        jLabel8.setText("Option 1 ");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 415, 60, 30));

        jLabel9.setFont(new java.awt.Font("Noteworthy", 1, 14)); // NOI18N
        jLabel9.setText("Option 2 ");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 415, 60, 30));

        jLabel10.setFont(new java.awt.Font("Noteworthy", 1, 14)); // NOI18N
        jLabel10.setText("Option 3 ");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 495, 60, 30));

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

    void getQuizInList()
    {
        try
        {
            list=QuestionsDao.getPaper(jobId);
            total=list.size();
            setQuestionInFrame(counter);
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,"DB-Error While editing quiz...","Error",JOptionPane.WARNING_MESSAGE);
            return;
        }
    }
    
    int setQuestionInFrame(int counter)
    {
        que=list.get(counter);
        queTxt.setText(que.getQuestion());
        op1Txt.setText(que.getOption1());
        op2Txt.setText(que.getOption2());
        op3Txt.setText(que.getOption3());
        op4Txt.setText(que.getOption4());
        correctOp.setSelectedIndex(que.getCorrectOption());
        return 0;
    }
    
    QuestionPojo setDataInObj()
    {
        que.setJobId(jobId);
        que.setqNo(counter+1);
        que.setQuestion(queTxt.getText().trim());
        que.setOption1(op1Txt.getText().trim());
        que.setOption2(op2Txt.getText().trim());
        que.setOption3(op3Txt.getText().trim());
        que.setOption4(op4Txt.getText().trim());
        que.setCorrectOption(correctOp.getSelectedIndex());
        return que;
    }
    
    private void discardBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_discardBtnActionPerformed
        // TODO add your handling code here:
        new HrEditQuizFrame().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_discardBtnActionPerformed

    private void queBackBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_queBackBtnActionPerformed
        queLbl.setText(""+(counter+1));
        if(counter>0)
        {
            que=setDataInObj();
            list.set(counter,que);
            counter=counter-1;
            setQuestionInFrame(counter);   
        }
        else
        {
            JOptionPane.showMessageDialog(null,"You're on question no 1\nPlease proceed for next","Warning",JOptionPane.WARNING_MESSAGE);
            return;
        }
        queLbl.setText(""+(counter+1));
    }//GEN-LAST:event_queBackBtnActionPerformed

    private void queNextBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_queNextBtnActionPerformed
        // TODO add your handling code here:
        queLbl.setText(""+(counter+1));
        if(validateInput())
        {
            if(counter==total-1)
            {
                que=setDataInObj();
                list.set(counter,que);
                JOptionPane.showMessageDialog(null,"You're on the last question.\nSubmit now.","Warning",JOptionPane.WARNING_MESSAGE);
                return;
            }
            else
            {
                que=setDataInObj();
                list.set(counter,que);
                counter=counter+1;
                setQuestionInFrame(counter);
                queLbl.setText(""+(counter+1));
                return;
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Please fill all fileds","Warning",JOptionPane.WARNING_MESSAGE);
            return;
        }
    }//GEN-LAST:event_queNextBtnActionPerformed

    private void submitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitBtnActionPerformed
    if(validateInput())
    {
        try
        {
            que=setDataInObj();
            if(counter==total-1)
                list.set(counter,que);
            if(QuestionsDao.editPaper(list))
            {   
                System.out.println(list);
                JobDao.setJobStatus(jobId);
                JOptionPane.showMessageDialog(null,"Paper Edited sucessfully","Success",JOptionPane.INFORMATION_MESSAGE);
                new HrEditQuizFrame().setVisible(true);
                this.dispose();
            }
            else
            {
                //undo code
            }
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null,"DB-error while editing paper","Error msg",JOptionPane.ERROR_MESSAGE);
            return;
        }
    }
        else
        {
            JOptionPane.showMessageDialog(null,"Please fill all fileds","Warning",JOptionPane.WARNING_MESSAGE);
            return;
        }
    }//GEN-LAST:event_submitBtnActionPerformed

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
            java.util.logging.Logger.getLogger(HrEditQuizFrame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HrEditQuizFrame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HrEditQuizFrame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HrEditQuizFrame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HrEditQuizFrame1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> correctOp;
    private javax.swing.JButton discardBtn;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTextField op1Txt;
    private javax.swing.JTextField op2Txt;
    private javax.swing.JTextField op3Txt;
    private javax.swing.JTextField op4Txt;
    private javax.swing.JButton queBackBtn;
    private javax.swing.JLabel queLbl;
    private javax.swing.JButton queNextBtn;
    private javax.swing.JTextArea queTxt;
    private javax.swing.JButton submitBtn;
    // End of variables declaration//GEN-END:variables
}
