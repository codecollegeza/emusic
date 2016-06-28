package co.za.codecol.emusic.service;

import co.za.codecol.emusic.support.SmtpMailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;

@Service
class DefaultEmailService implements EmailService {


    @Autowired
    private SmtpMailSender mailSender;

    @Override
    public void subToEmailList(String toEmail, String firstName) {
        String subject = "Welcome to our email list";
        String body = "Hello Mr Dick";
        try {
            mailSender.send(toEmail, subject, body);
        } catch (MessagingException mEx) {

        }
    }
}
