package com.levlin.service;


import com.levlin.model.Role;
import com.levlin.model.User;

import java.util.List;

public interface UserRoleService {

    List<Role> getRoleByUser(User user);
}
