package com.eliasfilipe.gamelist.controllers;

import com.eliasfilipe.gamelist.dto.GameDTO;
import com.eliasfilipe.gamelist.dto.GameMinDTO;
import com.eliasfilipe.gamelist.dto.UserDTO;
import com.eliasfilipe.gamelist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/games")
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping
    public List<GameMinDTO> findAll(){
        List<GameMinDTO> result = gameService.findAll();
        return result;
    }

    @GetMapping(value = "/{id}")
    public GameDTO findByID(@PathVariable Long id){
        GameDTO result = gameService.findById(id);
        return result;
    }

    @GetMapping(value = "/title/{title}")
    public GameMinDTO findGameByTitle(@PathVariable String title) {
        GameMinDTO result = gameService.findGameByTitle(title);
        return result;
    }

}