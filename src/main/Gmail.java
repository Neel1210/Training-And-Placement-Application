package main;

import java.sql.ResultSet;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import pojo.CurrentUser;
import pojo.HrPojo;
import pojo.JobPojo;
import pojo.ParticipantsPojo;
/**
 *
 * @author Neel_Esh
 */
public class Gmail {
    
    Session newSession;
    MimeMessage mimeMessage;
    
    public Gmail()
    {
        setupServerProperties();
    }
        //Gmail gmail = new Gmail();
        //gmail.setupServerProperties();
        //gmail.HrCredentialsEmail(hr);
        //gmail.sendEmail();
    
    public void setupServerProperties()
    {
        Properties pro = System.getProperties();
        pro.put("mail.smtp.port","587");
        pro.put("mail.smtp.auth","true");
        pro.put("mail.smtp.starttls.enable","true");
        newSession=Session.getDefaultInstance(pro,null);
        
    }
    
    public void sendEmail() throws MessagingException
    {
        String fromUser="1210neelesh@gmail.com";
        String fromUserPwd="pqpwylcqigkmhacj";
        String emailHost="smtp.gmail.com";
        Transport transport=newSession.getTransport("smtp");
        transport.connect(emailHost,fromUser,fromUserPwd);
        transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
        transport.close();
        
        System.out.println("Email SuccessFully transfered");
        
    }
    
   public MimeMessage participantsResult(String jobId,String jobTitle,int result) throws AddressException,MessagingException
    {
        String email=CurrentUser.userId;
        //String email="sca.submit.resume@gmail.com";
        String emailSubject="Notification From SCALIVE Traning And Placement Application";
        String emailBody="Hello "+CurrentUser.name+",\n"
                + "\nYou got "+result+"% in "+jobId+" (\""+jobTitle+"\")"
                +"\n\nWarm Regards"
                + "\nSCALIVE "
                + "\nTraning And Placement Application";
        
        mimeMessage= new MimeMessage(newSession);
        
        mimeMessage.addRecipient(Message.RecipientType.TO,new InternetAddress(email));
        
        mimeMessage.setSubject(emailSubject);
        
        
        
        MimeBodyPart bodyPart=new MimeBodyPart();
        //bodyPart.setContent(emailBody,"html/text");
        bodyPart.setText(emailBody);
        
        MimeMultipart multiPart=new MimeMultipart();
        multiPart.addBodyPart(bodyPart);
        
        mimeMessage.setContent(multiPart);
        return mimeMessage; 
    }
    
    public MimeMessage interviewInvition(ParticipantsPojo pj,JobPojo jb) throws AddressException,MessagingException
    {
        
        String email=pj.getUserId();
        String emailSubject="Interview Invitation From "+jb.getHrId();
        String emailBody="Hello "+pj.getName()+",\n\nWarm Welcome from "+jb.getHrId()+".\n"
                + "You are qualified our first technical round.\n"
                + "\nJob Description -\n"
                + "Job Id : \""+jb.getJobId()+"\"\n"
                + "Job Title : \""+jb.getJobTitle()+"\"\n"
                + "\nYour Interview will be taken by "+CurrentUser.name+"\n"
                + "Interview Schedule and meeting link will be shared soon.\n"
                +"\nWarm Regards"
                +"\n"+jb.getHrId();
        
        mimeMessage= new MimeMessage(newSession);

        mimeMessage.addRecipient(Message.RecipientType.TO,new InternetAddress(email));
        
        mimeMessage.setSubject(emailSubject);
          
        MimeBodyPart bodyPart=new MimeBodyPart();
        //bodyPart.setContent(emailBody,"html/text");
        bodyPart.setText(emailBody);
        
        MimeMultipart multiPart=new MimeMultipart();
        multiPart.addBodyPart(bodyPart);
        
        mimeMessage.setContent(multiPart);
        return mimeMessage;  
    }
    
    
    public MimeMessage HrCredentialsEmail(HrPojo hr) throws AddressException,MessagingException
    {
        String email=hr.getUserId();
        String emailSubject="Login Credentails For HR From SCALIVE Traning And Placement Application";
        String emailBody="Hello "+hr.getName()+",\nWarm Welcome in SCALIVE Traning And Placement Application.\n"
                + "Your Login Credentials - \n\n"
                + "Hr Id - "+hr.getHrId()+"\n"
                + "Email :-"+hr.getUserId()+"\n"
                + "PassWord :- "+hr.getPassword()+"\n"
                +"\nWarm Regards"
                + "\nSCALIVE "
                + "\nTraning And Placement Application";
        
        mimeMessage= new MimeMessage(newSession);

        mimeMessage.addRecipient(Message.RecipientType.TO,new InternetAddress(email));
        
        mimeMessage.setSubject(emailSubject);
          
        MimeBodyPart bodyPart=new MimeBodyPart();
        //bodyPart.setContent(emailBody,"html/text");
        bodyPart.setText(emailBody);
        
        MimeMultipart multiPart=new MimeMultipart();
        multiPart.addBodyPart(bodyPart);
        
        mimeMessage.setContent(multiPart);
        return mimeMessage; 
    }
    
    
}
