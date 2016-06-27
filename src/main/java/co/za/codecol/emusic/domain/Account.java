package co.za.codecol.emusic.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@SuppressWarnings("serial")
@Entity
@Table(name = "account")
public class Account implements java.io.Serializable {

    @Id
    @GeneratedValue
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

    protected Account() {

    }

    public Account(String name, String email, String password, String role) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
        this.created = new Date();
    }

    public Long getId() {
        return id;
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

//    private String timeCreated() {
//        java.util.Date dt = new java.util.Date();
//        java.text.SimpleDateFormat sdf =
//                new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        return sdf.format(dt);
//    }
}
