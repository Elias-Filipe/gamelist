package com.eliasfilipe.gamelist.controllers;


import com.eliasfilipe.gamelist.dto.PostDTO;
import com.eliasfilipe.gamelist.dto.PostMinDTO;
import com.eliasfilipe.gamelist.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping
    public List<PostDTO> findAll() {
        List<PostDTO> result = postService.findAll();
        return result;
    }

    @GetMapping(value = "/{id}")
    public PostDTO findById(@PathVariable Long id) {
        PostDTO result = postService.findById(id);
        return result;
    }

    @GetMapping(value = "/game/{gameId}")
    public List<PostMinDTO> findByGame(@PathVariable Long gameId) {
        List<PostMinDTO> result = postService.findByGameId(gameId);
        return result;
    }

}
