package com.genspark.rest.videocardapi.domain.service;

import com.genspark.rest.videocardapi.domain.entity.User;

import java.util.List;

public interface UserService {
    List<User> get();
    User find(Long id);
    User create(User user);
    User findBy(String email);
    User update(User user);
    void delete(Long id);
    boolean validatePassword(User user,String password);
    User logOut(User user);
}
