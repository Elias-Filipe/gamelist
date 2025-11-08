package com.eliasfilipe.gamelist.controllers;

import com.eliasfilipe.gamelist.dto.GameListDTO;
import com.eliasfilipe.gamelist.dto.GameMinDTO;
import com.eliasfilipe.gamelist.dto.ReplacementListDTO;
import com.eliasfilipe.gamelist.services.GameListService;
import com.eliasfilipe.gamelist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

    @Autowired
    private GameListService gameListService;
    @Autowired
    private GameService gameService;

    @GetMapping
    public List<GameListDTO> findAll(){
        List<GameListDTO> result = gameListService.findAll();
        return result;
    }

    @GetMapping(value = "/{id}")
    public GameListDTO findById(@PathVariable Long id) {
        GameListDTO result = gameListService.findById(id);
        return result;
    }

    @GetMapping(value = "/{listId}/games")
    public List<GameMinDTO> findByList(@PathVariable Long listId){
        List<GameMinDTO> result = gameService.findByList(listId);
        return result;
    }

    @PostMapping(value = "/{listId}/replacement")
    public void move(@PathVariable Long listId, @RequestBody ReplacementListDTO body){
        gameListService.move(listId, body.getSourceIndex(), body.getDestinationIndex());
    }

}
