package com.genspark.rest.videocardapi.domain.service;

import com.genspark.rest.videocardapi.domain.entity.AccessToken;
import com.genspark.rest.videocardapi.domain.entity.User;
import com.genspark.rest.videocardapi.domain.repository.AccessTokenRepository;
import com.genspark.rest.videocardapi.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.persistence.Access;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AccessTokenRepository tokenRepository;

    @Override
    public List<User> get() {
        return userRepository.findAll();
    }

    @Override
    public User find(Long id) {
        Optional<User> u = userRepository.findById(id);
        User user = null;
        if (u.isPresent()) {
            user = u.get();
        } else {
            throw new RuntimeException(" User not found for id : " + id);
        }
        return user;
    }

    @Override
    public User create(User user) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        user.setTimestamp(timestamp);
        return userRepository.save(user);
    }

    @Override
    public User findBy(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User update(User user) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        user.setTimestamp(timestamp);
        return userRepository.save(user);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public boolean validatePassword(User user,String password) {
        if(!user.getPassword().equals(password))
        {
            return false;
        }
        AccessToken accessToken=new AccessToken();
        accessToken.setValue("testAccess");
        accessToken.setUser(user);
        tokenRepository.save(accessToken);
        userRepository.save(user);
        return true;
    }

    @Override
    public User logOut(User user) {
        user.getAccessTokens().clear();
        return userRepository.save(user);
    }
}
