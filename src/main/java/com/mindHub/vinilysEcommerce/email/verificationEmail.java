package com.mindHub.vinilysEcommerce.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class verificationEmail {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendVerificationEmail (String email, String subject, String body){
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("orpheus.music.vinyls@gmail.com");
        simpleMailMessage.setTo(email);
        simpleMailMessage.setText(body);
        simpleMailMessage.setSubject(subject);
        javaMailSender.send(simpleMailMessage);
    }
}
