package com.eliasfilipe.gamelist.dto;

import com.eliasfilipe.gamelist.entities.User;

public class UserMinDTO {

    private long id;
    private String name;

    public UserMinDTO() {}

    public UserMinDTO(User entity) {
        id = entity.getId();
        name = entity.getName();
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
}
