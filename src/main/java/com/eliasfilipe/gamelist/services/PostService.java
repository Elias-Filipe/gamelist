package com.eliasfilipe.gamelist.services;

import com.eliasfilipe.gamelist.dto.PostDTO;
import com.eliasfilipe.gamelist.entities.Post;
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
}
