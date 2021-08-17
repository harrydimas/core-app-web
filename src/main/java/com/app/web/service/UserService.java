package com.app.web.service;

import com.app.web.model.User;
import com.app.web.repos.UserReporsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserReporsitory userReporsitory;

    @Autowired
    public UserService(UserReporsitory userReporsitory) {
        this.userReporsitory = userReporsitory;
    }

    public List<User> getAll(){
        return userReporsitory.findAll();
    }

    public User getByLoginId(String loginId){
        return userReporsitory.findByLoginId(loginId).orElse(null);
    }
}
