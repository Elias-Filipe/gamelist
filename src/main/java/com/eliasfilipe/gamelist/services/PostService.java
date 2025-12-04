package com.eliasfilipe.gamelist.services;

import com.eliasfilipe.gamelist.dto.PostDTO;
import com.eliasfilipe.gamelist.dto.PostMinDTO;
import com.eliasfilipe.gamelist.entities.Post;
import com.eliasfilipe.gamelist.projection.PostMinProjection;
import com.eliasfilipe.gamelist.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    @Transactional(readOnly = true)
    public List<PostDTO> findAll(){
        List<Post> result = postRepository.findAll();
        return result.stream().map(x -> new PostDTO(x)).toList();
    }

    @Transactional(readOnly = true)
    public PostDTO findById(Long id){
        Post result = postRepository.findById(id).get();
        return new PostDTO(result);
    }

    @Transactional(readOnly = true)
    public List<PostMinDTO> findByGameId(Long gameId){
        List<PostMinProjection> result = postRepository.searchByGame(gameId);
        return result.stream().map(x -> new PostMinDTO(x)).toList();
    }
}
