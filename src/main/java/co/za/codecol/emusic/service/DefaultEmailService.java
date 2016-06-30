package co.za.codecol.emusic.service;

import co.za.codecol.emusic.support.SmtpMailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;

@Service
public class DefaultEmailService implements EmailService {

    @Autowired
    private SmtpMailSender smtpMailSender;

    @Override
    public void subToEmailList(String toEmail, String firstName) {

    }

    @Override
    public void sendConfirmationEmail(String toEmail) throws MessagingException {
        smtpMailSender.send(toEmail, "Order comfirm", "Your order has been placed");
    }


}
