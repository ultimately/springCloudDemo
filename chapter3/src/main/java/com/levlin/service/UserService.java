package com.levlin.service;


import com.levlin.model.User;

public interface UserService {

    User getById(Integer id);

    User getUsername(String username);
}
