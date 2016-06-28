package co.za.codecol.emusic.service;

import org.springframework.validation.annotation.Validated;

@Validated
public interface EmailService {

    void subToEmailList(String toEmail, String firstName);
}
