package com.eliasfilipe.gamelist.controllers;

import com.eliasfilipe.gamelist.dto.UserDTO;
import com.eliasfilipe.gamelist.dto.UserInsertDTO;
import com.eliasfilipe.gamelist.dto.UserMinDTO;
import com.eliasfilipe.gamelist.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(value = "/name/{name}")
    public UserDTO findByName(@PathVariable String name) {
        UserDTO result = userService.findByName(name);
        return result;
    }

    @PostMapping
    public UserInsertDTO saveUser(@RequestBody UserInsertDTO userInsertDTO) {
        return userService.saveUser(userInsertDTO);
    }

    @DeleteMapping(value = "/name/{name}")
    public void deleteByName(@PathVariable String name) {
        userService.deleteByName(name);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteById(@PathVariable Long id) {
        userService.deleteById(id);
    }

    @PutMapping(value = "/{id}")
    public UserDTO updateUser(@PathVariable Long id, @RequestBody UserInsertDTO userInsertDTO) {
        return userService.updateUser(id, userInsertDTO);
    }
}
