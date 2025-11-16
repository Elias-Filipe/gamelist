package com.eliasfilipe.gamelist.controllers;

import com.eliasfilipe.gamelist.dto.UserDTO;
import com.eliasfilipe.gamelist.dto.UserMinDTO;
import com.eliasfilipe.gamelist.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserMinDTO> findAll() {
        List<UserMinDTO> result = userService.findAll();
        return result;
    }

    @GetMapping(value = "/{id}")
    public UserDTO findById(@PathVariable Long id) {
        UserDTO result = userService.findById(id);
        return result;
    }

}
