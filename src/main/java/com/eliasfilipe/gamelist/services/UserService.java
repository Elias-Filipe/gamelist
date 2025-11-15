package com.eliasfilipe.gamelist.services;

import com.eliasfilipe.gamelist.dto.UserDTO;
import com.eliasfilipe.gamelist.dto.UserMinDTO;
import com.eliasfilipe.gamelist.entities.User;
import com.eliasfilipe.gamelist.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional(readOnly = true)
    public List<UserMinDTO> findAll(){
        List<User> result = userRepository.findAll();
        return result.stream().map(x -> new UserMinDTO(x)).toList();
    }

    @Transactional(readOnly = true)
    public UserDTO findById(Long id){
        User result = userRepository.findById(id).get();
        return new UserDTO(result);
    }

}
