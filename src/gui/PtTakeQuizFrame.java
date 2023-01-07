/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import dao.QuestionsDao;
import pojo.CurrentUser;
import pojo.QuestionPojo;
import pojo.ResultPojo;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import javax.mail.MessagingException;
import javax.swing.JOptionPane;
import main.Gmail;
import pojo.HrPojo;

/**
 *
 * @author Neel_Esh
 */
public class PtTakeQuizFrame extends javax.swing.JFrame {

    /**
     * Creates new form PtTakeQuizFrame
     */
    List<QuestionPojo> list;
    private String jobId,jobTitle;
    int counter=0,total=0;
    List<Integer> userAnswerList=new ArrayList<Integer>();
    PtTakeQuizFrame pt=this;
    
    
    
    public PtTakeQuizFrame() {
        initComponents();
        queLbl.setText(""+(counter+1));
        this.setLocationRelativeTo(null);        
    }

    public PtTakeQuizFrame(String jobId,String jobTitle) {
        
        initComponents();
        this.jobId=jobId;
        this.jobTitle=jobTitle;
        queLbl.setText(""+(counter+1));
        this.setLocationRelativeTo(null);
        getQuestionFromDataBase();
        this.setVisible(true);
        timer(total);
        
    }
    
    void getQuestionFromDataBase()
    {
       try
        {
            list=QuestionsDao.getPaper(jobId);
            total=list.size();
            setData(counter);
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null,"Error While Retriving Question From DataBase","Warning",JOptionPane.WARNING_MESSAGE);
            return;
        } 
    }
    
    int setData(int counter)
    {
        QuestionPojo que;
        que=list.get(counter);
    
        queTxt.setText(que.getQuestion());
        option1.setText(que.getOption1());
        option2.setText(que.getOption2());
        option3.setText(que.getOption3());
        option4.setText(que.getOption4());
        buttonGroup1.clearSelection();
        return 0;
    }
    
    private boolean validateInput() 
    {
        if(!option1.isSelected() && !option3.isSelected() && !option2.isSelected() && !option4.isSelected())
            return false;
        return true;
    }
    
    private void getSelectOption(int res)
    {
        if(res==1)
            option1.setSelected(true);
        else if(res==2)
            option2.setSelected(true);
        else if(res==3)
            option3.setSelected(true);
        else
            option4.setSelected(true);
    }
    
    private int validateChooseOption() 
    {
        if(option1.isSelected())
            return 1;
        else if(option2.isSelected())
            return 2;
        else if(option3.isSelected())
            return 3;
        else if(option4.isSelected())
            return 4;   
        else
            return 0;
    }
    
    private int getSelectedOptionFromList()
    {
        try
        {
            return userAnswerList.get(counter);
        }
        catch(IndexOutOfBoundsException ex)
        {
            return -1;
        }
    }
    
    private double getResult()
    {   
        double totalmarks=0.0;
        for(int i=0;i<total;i++)
        {
            QuestionPojo q=list.get(i);
            if(q.getCorrectOption()==userAnswerList.get(i))
                totalmarks=totalmarks+1;
        }
        return (totalmarks/total)*100;
    }
    
    private void timer(int total)
    {
        Timer timer = new Timer();
        TimerTask task = new TimerTask(){
        int time=120*total;
            
            public void run()
            {
                if(time>0)
                {
                    minLbl.setText(""+time/60);
                    secLbl.setText(""+time%60);
                    time=time-1;
                }
                else
                {
                    minLbl.setText("");
                    secLbl.setText("");
                    colenLbl.setText("Time over");
                    timer.cancel();
                    
                    int i=0;
                    for(i=counter;i<total;i++)
                    {
                        userAnswerList.add(0);
                    }
                    
                    ResultPojo rs=new ResultPojo();
                    rs.setJobId(jobId);
                    rs.setParticipantId(CurrentUser.id);
                    if(getResult()<5)
                        rs.setStatus(5.0);
                    else
                        rs.setStatus(getResult());
        
                    try
                    {
                        if(dao.ResultsDao.setStatus(rs))
                        {
                            sendMail((int)rs.getStatus());
                
                            JOptionPane.showMessageDialog(null,"You got "+rs.getStatus()+"%\n"
                + "And Result is also sended on mail","Result",JOptionPane.INFORMATION_MESSAGE);
                
                            new PtViewAllAppliedJobFrame().setVisible(true);
                            pt.dispose();
                            //this.dispose();
                        }    
                    }
                    catch(SQLException ex)
                    {
                        JOptionPane.showMessageDialog(null,"DB-error while adding paper","Error msg",JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    
                }    
            }
        };
        timer.scheduleAtFixedRate(task, 0, 1000);   
    }
    
    void sendMail(int result)
    {
        Runnable r=()->{
            try
            {
                Gmail gmail = new Gmail();
                gmail.participantsResult(jobId,jobTitle,result);
                gmail.sendEmail();
                
            }
            catch(MessagingException ex)
            {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null,"Error while sending E-mail");
            }
        };          
        Thread th=new Thread(r);
        th.start();
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
        option1 = new javax.swing.JRadioButton();
        option3 = new javax.swing.JRadioButton();
        option2 = new javax.swing.JRadioButton();
        option4 = new javax.swing.JRadioButton();
        discardBtn = new javax.swing.JButton();
        queLbl = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        queTxt = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
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
        colenLbl = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        minLbl = new javax.swing.JLabel();
        secLbl = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(243, 246, 254));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buttonGroup1.add(option1);
        option1.setText("buton 1");
        option1.setOpaque(false);
        jPanel1.add(option1, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 487, 290, 25));

        buttonGroup1.add(option3);
        option3.setText("jRadioButton1");
        option3.setOpaque(false);
        jPanel1.add(option3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 567, 290, 25));

        buttonGroup1.add(option2);
        option2.setText("jRadioButton1");
        option2.setOpaque(false);
        jPanel1.add(option2, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 487, 290, 25));

        buttonGroup1.add(option4);
        option4.setText("jRadioButton1");
        option4.setOpaque(false);
        jPanel1.add(option4, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 567, 290, 25));

        discardBtn.setBackground(new java.awt.Color(173, 192, 234));
        discardBtn.setText("Discard Paper");
        discardBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                discardBtnActionPerformed(evt);
            }
        });
        jPanel1.add(discardBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 660, 140, -1));

        queLbl.setFont(new java.awt.Font("Noteworthy", 1, 24)); // NOI18N
        jPanel1.add(queLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 300, 40, 30));

        queTxt.setEditable(false);
        queTxt.setBackground(new java.awt.Color(173, 192, 234));
        queTxt.setColumns(20);
        queTxt.setFont(new java.awt.Font("Heiti TC", 1, 14)); // NOI18N
        queTxt.setRows(5);
        queTxt.setAutoscrolls(false);
        queTxt.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.darkGray, java.awt.Color.gray));
        jScrollPane1.setViewportView(queTxt);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 300, 860, 90));

        jLabel4.setFont(new java.awt.Font("Noteworthy", 1, 24)); // NOI18N
        jLabel4.setText("Que .");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, 60, 30));

        jLabel5.setFont(new java.awt.Font("Noteworthy", 1, 14)); // NOI18N
        jLabel5.setText("Option 4 ");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 560, 60, 30));

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/TextFieldPic.png"))); // NOI18N
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 560, 350, 40));

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/TextFieldPic.png"))); // NOI18N
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 480, 350, 40));

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/TextFieldPic.png"))); // NOI18N
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 480, 350, 40));

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/TextFieldPic.png"))); // NOI18N
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 560, 350, 40));

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
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, 970, 10));

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/World-Map.png"))); // NOI18N
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 65, 970, 170));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 620, 980, 10));
        jPanel1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 450, 980, 10));

        jLabel7.setFont(new java.awt.Font("Noteworthy", 1, 24)); // NOI18N
        jLabel7.setText("Options -");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 400, 150, 40));

        jLabel8.setFont(new java.awt.Font("Noteworthy", 1, 14)); // NOI18N
        jLabel8.setText("Option 1 ");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 480, 60, 30));

        jLabel9.setFont(new java.awt.Font("Noteworthy", 1, 14)); // NOI18N
        jLabel9.setText("Option 2 ");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 480, 60, 30));

        jLabel10.setFont(new java.awt.Font("Noteworthy", 1, 14)); // NOI18N
        jLabel10.setText("Option 3 ");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 560, 60, 30));

        colenLbl.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        colenLbl.setForeground(new java.awt.Color(255, 0, 51));
        colenLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        colenLbl.setText(":");
        jPanel1.add(colenLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 660, 100, 20));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 51));
        jLabel2.setText("Time Left :-");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 660, -1, 20));

        minLbl.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        minLbl.setForeground(new java.awt.Color(255, 0, 51));
        minLbl.setText("0");
        jPanel1.add(minLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 660, 20, 20));

        secLbl.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        secLbl.setForeground(new java.awt.Color(255, 0, 51));
        secLbl.setText("0");
        jPanel1.add(secLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 660, 20, 20));
        jPanel1.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, 970, 10));

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

    private void discardBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_discardBtnActionPerformed
        // TODO add your handling code here:
        new PtViewAllJobFrame().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_discardBtnActionPerformed

    private void queBackBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_queBackBtnActionPerformed
        queLbl.setText(""+(counter+1));
        
        int res=validateChooseOption();
        if(res==0)
        {
            JOptionPane.showMessageDialog(null,"Please select any option","Warning",JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        else
        {   
            if(counter>0)
            {
                if(getSelectedOptionFromList()==-1)
                    userAnswerList.add(res);
                else
                    userAnswerList.set(counter,res);
                //System.out.println(userAnswerList);
                counter=counter-1;
                setData(counter);
                getSelectOption(userAnswerList.get(counter));    
            }
            else
            {
                JOptionPane.showMessageDialog(null,"You're on question no 1\nPlease proceed for next","Warning",JOptionPane.WARNING_MESSAGE);
                return;
            }
        }        
        queLbl.setText(""+(counter+1));
    }//GEN-LAST:event_queBackBtnActionPerformed

    private void queNextBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_queNextBtnActionPerformed
        //TODO add your handling code here:
        queLbl.setText(""+(counter+1));
        int res=validateChooseOption();
        
        if(res==0)
        {
            JOptionPane.showMessageDialog(null,"Please select any option","Warning",JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        else
        {
            if(counter==total-1)
            {
                if(getSelectedOptionFromList()==-1)
                    userAnswerList.add(res);
                else
                    userAnswerList.set(counter,res);
                JOptionPane.showMessageDialog(null,"You're on the last question","Warning",JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            else
            {
                if(getSelectedOptionFromList()==-1)
                    userAnswerList.add(res);
                else
                    userAnswerList.set(counter,res);
                
                counter=counter+1;
                
                setData(counter);
                int op=getSelectedOptionFromList();
                if(op!=-1)
                    getSelectOption(userAnswerList.get(counter));
                    
                queLbl.setText(""+(counter+1));
                return;    
            }
            
        }
    }//GEN-LAST:event_queNextBtnActionPerformed

    private void submitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitBtnActionPerformed
        // TODO add your handling code here:
        int res=validateChooseOption();
        
        if(res==0)
        {
            JOptionPane.showMessageDialog(null,"Please select any option","Warning",JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        else
        {
            if(getSelectedOptionFromList()==-1)
                userAnswerList.add(res);
            else
                userAnswerList.set(counter,res);
        }
        
//        System.out.println(userAnswerList);
//        System.out.println(getResult());
        
        ResultPojo rs=new ResultPojo();
        rs.setJobId(jobId);
        rs.setParticipantId(CurrentUser.id);
        
        if(getResult()<5)
            rs.setStatus(5.0);
        else
            rs.setStatus(getResult());
        
        try
        {
            if(dao.ResultsDao.setStatus(rs))
            {
                
                
                sendMail((int)rs.getStatus());
                
                JOptionPane.showMessageDialog(null,"You got "+rs.getStatus()+"%\n"
                        + "And Result is also sended on mail","Result",JOptionPane.INFORMATION_MESSAGE);
                
                new PtViewAllAppliedJobFrame().setVisible(true);
                this.dispose();
            }    
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null,"DB-error while adding paper","Error msg",JOptionPane.ERROR_MESSAGE);
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
            java.util.logging.Logger.getLogger(PtTakeQuizFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PtTakeQuizFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PtTakeQuizFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PtTakeQuizFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PtTakeQuizFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel colenLbl;
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
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JLabel minLbl;
    private javax.swing.JRadioButton option1;
    private javax.swing.JRadioButton option2;
    private javax.swing.JRadioButton option3;
    private javax.swing.JRadioButton option4;
    private javax.swing.JButton queBackBtn;
    private javax.swing.JLabel queLbl;
    private javax.swing.JButton queNextBtn;
    private javax.swing.JTextArea queTxt;
    private javax.swing.JLabel secLbl;
    private javax.swing.JButton submitBtn;
    // End of variables declaration//GEN-END:variables
}