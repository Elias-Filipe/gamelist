package com.eliasfilipe.gamelist.services;

import com.eliasfilipe.gamelist.dto.GameListDTO;
import com.eliasfilipe.gamelist.entities.GameList;
import com.eliasfilipe.gamelist.repositories.GameListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gamelistRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll(){
        List<GameList> result = gamelistRepository.findAll();
        return result.stream().map(x -> new GameListDTO(x)).toList();
    }

    @Transactional(readOnly = true)
    public GameListDTO findById(long id) {
        GameList result = gamelistRepository.findById(id).get();
        return new GameListDTO(result);
    }
}
