package com.levlin.service.Impl;

import com.levlin.mapper.PermissionRoleMapper;
import com.levlin.model.PermissionRole;
import com.levlin.service.PermissionRoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionRoleServiceImpl implements PermissionRoleService {

    private Logger logger = LoggerFactory.getLogger(PermissionRoleServiceImpl.class);

    @Autowired
    private PermissionRoleMapper permissionRoleMapper;

    @Override
    public List<PermissionRole> getUser(){
        return permissionRoleMapper.selectAll();
    }


}
