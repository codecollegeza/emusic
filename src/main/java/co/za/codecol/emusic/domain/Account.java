package co.za.codecol.emusic.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;

@SuppressWarnings("serial")
@Entity
@Table(name = "account")
@Component
public class Account implements java.io.Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name")
    private String name;

    @Column(unique = true)
    private String email;

    @JsonIgnore
    private String password;

    private String role = "ROLE_USER";

    @Temporal(TemporalType.DATE)
    private Date created;

    @Column(name = "LASTNAME")
    private String lastName;

    @Column(name = "COMPANYNAME")
    private String companyName;

    @Column(name = "ADDRESS1")
    private String address1;
    @Column(name = "ADDRESS2")
    private String address2;
    @Column(name = "CITY")
    private String city;
    @Column(name = "ST")
    private String st;
    @Column(name = "ZIP")
    private String zip;
    @Column(name = "COUNTRY")
    private String country;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSt() {
        return st;
    }

    public void setSt(String st) {
        this.st = st;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCreditCardType() {
        return creditCardType;
    }

    public void setCreditCardType(String creditCardType) {
        this.creditCardType = creditCardType;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public String getCreditCardExpirationDate() {
        return creditCardExpirationDate;
    }

    public void setCreditCardExpirationDate(String creditCardExpirationDate) {
        this.creditCardExpirationDate = creditCardExpirationDate;
    }

    @Column(name = "CREDITCARDTYPE")
    private String creditCardType;
    @Column(name = "CREDITCARDNUMBER")
    private String creditCardNumber;
    @Column(name = "CREDITCARDEXPIRATIONDATE")
    private String creditCardExpirationDate;

    protected Account() {

    }

    public Account(String name, String email, String password, String role, String lastName, String address1, String address2, String companyName, String city, String zip, String state, String country ) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
        this.created = new Date();
        this.lastName = lastName;
        this.address1 = address1;
        this.address2 = address2;
        this.companyName = companyName;
        this.city = city;
        this.zip = zip;
        this.st = state;
        this.country = country;
    }



}
