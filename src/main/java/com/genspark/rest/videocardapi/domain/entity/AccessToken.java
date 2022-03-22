package com.genspark.rest.videocardapi.domain.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class AccessToken {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    @NotNull
    private String value;

    public AccessToken() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
