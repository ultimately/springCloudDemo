package com.levlin.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
public class User implements UserDetails {
    private Integer id;
    private String cnname;
    private String username;
    @JsonIgnore
    private String password;
    private String rePassword;
    private String historyPassword;
    private String email;
    @JsonIgnore
    private String telephone;
    private String mobilePhone;
    private List<? extends GrantedAuthority> authorities;
    private Role role;
    private Integer roleId;

    @Override
    @JsonIgnore
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isEnabled() {
        return true;
    }

    @JsonIgnore
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }
    public void setGrantedAuthorities(List<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", cnname=" + cnname +
                ", username=" + username +
                ", password=" + password +
                ", email=" + email +
                ", telephone=" + telephone +
                ", mobilePhone=" + mobilePhone +
                '}';
    }
}