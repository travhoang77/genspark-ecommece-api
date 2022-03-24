package com.genspark.rest.videocardapi.domain.controller;


import com.fasterxml.jackson.databind.node.ObjectNode;
import com.genspark.rest.videocardapi.domain.entity.AccessToken;
import com.genspark.rest.videocardapi.domain.entity.User;
import com.genspark.rest.videocardapi.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
@RestController
@CrossOrigin(origins="*")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/allUsers")
    public List<User> getUsers()
    {
        return userService.get();
    }

    @GetMapping("/userByID/{userID}")
    public User getUserById(@PathVariable String userID)
    {
        return userService.find(Long.parseLong(userID));
    }

    @PostMapping("/addUser")
    public User addUser(@RequestBody User userToAdd)
    {
        return userService.create(userToAdd);
    }

    @GetMapping("/userByEmail/{email}")
    public User getUserByEmail(@PathVariable String email)
    {
        User user=userService.findBy(email);
        if(user==null)
        {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "no user by that email exists");
        }
        return user;
    }


    @PutMapping("/updateUser")
    public User updateUser( @RequestBody User userToUpdate)
    {
        return userService.update(userToUpdate);
    }


    @DeleteMapping("/deleteUser")
    public void deleteUser(@RequestBody User userToDelete)
    {
       userService.delete(userToDelete.getId());
    }

    @RequestMapping(value = "/validateUser", method = RequestMethod.POST)
    @ResponseBody
    public User validatePassword(@RequestBody ObjectNode objectNode)
    {
        String email = objectNode.get("email").asText();
        String password = objectNode.get("password").asText();
        User user=userService.findBy(email);
        if(user==null)
        {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "no user by that email exists");
        }

        if(userService.validatePassword(user,password))
        {
            return user;
        }
        else
        {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "incorrect password");
        }
    }
    @PostMapping("/logOutUser")
    public User logOut(@RequestBody User userToLogOut)
    {
        return userService.logOut(userToLogOut);
    }



}
