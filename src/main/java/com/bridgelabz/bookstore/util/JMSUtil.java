package com.bridgelabz.bookstore.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service
public class JMSUtil {
    @Autowired
    JavaMailSender javaMailSender;

    /**
     *
     * @param toEmail
     * @param subject
     * @param body
     */
    public  void sendEmail(String toEmail, String subject, String body) {

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom("aj912873@gmail.com");
        mailMessage.setTo(toEmail);
        mailMessage.setText(body);
        mailMessage.setSubject(subject);
        javaMailSender.send(mailMessage);
        System.out.println(mailMessage);
    }
}
