package com.eliasfilipe.gamelist.services;

import com.eliasfilipe.gamelist.dto.GameListDTO;
import com.eliasfilipe.gamelist.entities.GameList;
import com.eliasfilipe.gamelist.projection.GameMinProjection;
import com.eliasfilipe.gamelist.repositories.GameListRepository;
import com.eliasfilipe.gamelist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gamelistRepository;
    @Autowired
    private GameRepository gameRepository;

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

    @Transactional
    public void move(Long listId, int sourceIndex, int destinationIndex) {
        List<GameMinProjection> list = gameRepository.searchByList(listId);
        GameMinProjection obj = list.remove(sourceIndex);
        list.add(destinationIndex, obj);

        int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
        int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;

        for (int i = min; i <= max; i++) {
            gamelistRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
        }

    }
}
