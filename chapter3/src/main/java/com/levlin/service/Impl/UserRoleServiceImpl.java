package com.levlin.service.Impl;

import com.levlin.model.Role;
import com.levlin.model.User;
import com.levlin.service.UserRoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRoleServiceImpl implements UserRoleService {


    private Logger logger = LoggerFactory.getLogger(UserRoleServiceImpl.class);

    @Override
    public List<Role> getRoleByUser(User user){
        return null;
    }
}
