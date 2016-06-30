package co.za.codecol.emusic.service;


import javax.mail.MessagingException;

public interface EmailService {
    void subToEmailList(String toEmail, String firstName);

    void sendConfirmationEmail(String toEmail) throws MessagingException;

}
