package com.genspark.rest.videocardapi.domain.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class User {
    @Id
    @GeneratedValue
    private Long id;



    //email is username in this case
    @Email(message = "Email is not valid", regexp = "^[a-zA-Z0-9.!#$%&’*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$")
    @NotEmpty(message = "Email cannot be empty")
    @Column(unique=true)
    private String email;

    @NotEmpty(message = "Password cannot be empty")
    @NotNull
    private String password;

    @Size(max=100)
    private String firstname;

    @Size(max=100)
    private String lastname;



    @JsonManagedReference
    @OneToMany(mappedBy="user",cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<AccessToken> accessTokens =new HashSet<>();

    @Past
    private Date birthDate;

    @Enumerated(EnumType.STRING)
    private UserRole userRole;

    @OneToMany(mappedBy = "user")
    private List<Address> addresses;

    @NotNull
    private Timestamp timestamp;

    public User() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Set<AccessToken> getAccessTokens() {
        return accessTokens;
    }

    public void setAccessTokens(Set<AccessToken> accessTokens) {
        this.accessTokens = accessTokens;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }
}
