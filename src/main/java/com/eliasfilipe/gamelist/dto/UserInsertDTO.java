package com.eliasfilipe.gamelist.dto;

import com.eliasfilipe.gamelist.entities.Role;
import com.eliasfilipe.gamelist.entities.User;
import org.springframework.beans.BeanUtils;


public class UserInsertDTO {

    private String name;
    private String email;
    private String password;

    public UserInsertDTO() {
    }

    public UserInsertDTO(User entity) {
        BeanUtils.copyProperties(entity, this);
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
}
