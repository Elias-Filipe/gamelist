package com.eliasfilipe.gamelist.services;

import com.eliasfilipe.gamelist.dto.UserDTO;
import com.eliasfilipe.gamelist.dto.UserInsertDTO;
import com.eliasfilipe.gamelist.dto.UserMinDTO;
import com.eliasfilipe.gamelist.entities.Role;
import com.eliasfilipe.gamelist.entities.User;
import com.eliasfilipe.gamelist.repositories.PostRepository;
import com.eliasfilipe.gamelist.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostRepository postRepository;


    @Transactional(readOnly = true)
    public List<UserMinDTO> findAll() {
        List<User> result = userRepository.findAll();
        return result.stream().map(x -> new UserMinDTO(x)).toList();
    }

    @Transactional(readOnly = true)
    public UserDTO findById(Long id) {
        User result = userRepository.findById(id).get();
        return new UserDTO(result);
    }

    @Transactional(readOnly = true)
    public UserDTO findByName(String name) {
        User result = userRepository.findByName(name).orElseThrow(() -> new RuntimeException("Usuário não encontrado."));
        return new UserDTO(result);
    }

    @Transactional
    public UserInsertDTO saveUser(UserInsertDTO userInsertDTO) {
        User result = new User(userInsertDTO);
        result.setRole(Role.USER);
        result = userRepository.save(result);
        return new UserInsertDTO(result);
    }

    @Transactional
    public void deleteByName(String name) {
        userRepository.deleteByName(name);
    }

    @Transactional
    public void deleteById(Long id) {
        postRepository.deleteByUserId(id);
        userRepository.deleteById(id);
    }

    @Transactional
    public UserDTO updateUser(Long id, UserInsertDTO userInsertDTO) {
        User entity = userRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        if (userInsertDTO.getName() != null && !userInsertDTO.getName().isBlank()) {
            entity.setName(userInsertDTO.getName());
        }
        if (userInsertDTO.getEmail() != null && !userInsertDTO.getEmail().isBlank()) {
            entity.setEmail(userInsertDTO.getEmail());
        }
        if (userInsertDTO.getPassword() != null && !userInsertDTO.getPassword().isBlank()) {
            entity.setPassword(userInsertDTO.getPassword());
        }
        entity = userRepository.save(entity);
        return new UserDTO(entity);
    }
}
