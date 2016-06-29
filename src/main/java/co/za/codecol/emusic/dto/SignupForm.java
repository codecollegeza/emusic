package co.za.codecol.emusic.dto;

import co.za.codecol.emusic.domain.Account;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.util.Date;

public class SignupForm {

    private static final String NOT_BLANK_MESSAGE = "{notBlank.message}";
    private static final String EMAIL_MESSAGE = "{email.message}";

    @NotBlank(message = SignupForm.NOT_BLANK_MESSAGE)
    private String name;

    @NotBlank(message = SignupForm.NOT_BLANK_MESSAGE)
    private String lastName;

    @NotBlank(message = SignupForm.NOT_BLANK_MESSAGE)
    @Email(message = SignupForm.EMAIL_MESSAGE)
    private String email;

    @Temporal(TemporalType.DATE)
    private Date created;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getSt() {
        return st;
    }

    public void setSt(String st) {
        this.st = st;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    private String companyName;

    private String address1;

    private String address2;

    private String city;

    private String st;

    private String zip;

    private String country;

    @NotBlank(message = SignupForm.NOT_BLANK_MESSAGE)
    private String password;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Account createAccount() {
        return new Account(getName(),getEmail(), getPassword(), "ROLE_USER", getLastName(), getAddress1(), getAddress2(), getCompanyName(),getCity(), getZip(), getSt(), getCountry());
    }
}
