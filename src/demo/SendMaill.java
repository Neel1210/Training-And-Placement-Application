/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import main.Gmail;

/**
 *
 * @author Neel_Esh
 */
public class SendMaill {
    public static void main(String[] args) throws AddressException,MessagingException {
        Gmail mail=new Gmail();
        mail.setupServerProperties();
        mail.participantsResult("Neelesh","SDE",70);
        mail.sendEmail();
    }
}
