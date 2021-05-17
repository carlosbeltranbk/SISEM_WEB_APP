/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utez.edu.correo;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.PasswordAuthentication;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
/**
 *
 * @author jtc_2
 */
public class ServicioDeCorreo {

    public static String Username = "TribunalFederaldelaJusticia@gmail.com";
    public static String PassWord = "tribunalFederal";
  
    public void SendMail(String Subject,String To,String Mensage) {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

      Session session = Session.getInstance(props,
          new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(Username, PassWord);
            }
          });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(Username));
            message.setRecipients(Message.RecipientType.TO,
            InternetAddress.parse(To));
            message.setSubject(Subject);
            message.setContent(Mensage, "text/html" ) ;
            Transport.send(message);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

//    public static void main(String[] args) {
//        ServicioDeCorreo nu = new ServicioDeCorreo();
//        nu.SendMail();
//    }

}
