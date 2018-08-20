package com.levlin.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class PermissionRole implements Serializable{
    private Integer id;

    private Integer roleId;

    private Integer permissionId;
}