package com.eliasfilipe.gamelist.repositories;

import com.eliasfilipe.gamelist.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findUserByName(String username);

    UserDetails findByName(String username);

    void deleteByName(String username);

}
