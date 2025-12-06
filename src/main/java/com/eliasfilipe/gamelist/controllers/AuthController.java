package com.eliasfilipe.gamelist.controllers;

import com.eliasfilipe.gamelist.config.TokenConfig;
import com.eliasfilipe.gamelist.dto.LoginRequestDTO;
import com.eliasfilipe.gamelist.dto.LoginResponseDTO;
import com.eliasfilipe.gamelist.dto.RegisterRequestDTO;
import com.eliasfilipe.gamelist.entities.User;
import com.eliasfilipe.gamelist.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TokenConfig tokenConfig;

    @PostMapping(value = "/login")
    public ResponseEntity login(@RequestBody LoginRequestDTO loginRequestDTO) {
        UsernamePasswordAuthenticationToken usernamePassword = new UsernamePasswordAuthenticationToken(loginRequestDTO.getName(), loginRequestDTO.getPassword());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = tokenConfig.generateToken((User) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @PostMapping(value = "/register")
    public ResponseEntity register(@RequestBody RegisterRequestDTO registerRequestDTO) {
        if(this.userRepository.findByName(registerRequestDTO.getName()) != null) return ResponseEntity.badRequest().build();

        String encryptedPassword = new BCryptPasswordEncoder().encode(registerRequestDTO.getPassword());
        User user = new User(registerRequestDTO.getName(), registerRequestDTO.getEmail(), encryptedPassword, registerRequestDTO.getRole());

        this.userRepository.save(user);

        return ResponseEntity.ok().build();
    }

}
