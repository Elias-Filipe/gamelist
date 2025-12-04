package com.eliasfilipe.gamelist.dto;

import com.eliasfilipe.gamelist.entities.Role;
import com.eliasfilipe.gamelist.entities.User;
import org.springframework.beans.BeanUtils;



public class UserDTO {

    private long id;
    private String name;
    private String email;
    private String password;
    private Role role;

    public UserDTO() {
    }

    public UserDTO(User entity) {
        BeanUtils.copyProperties(entity, this);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
