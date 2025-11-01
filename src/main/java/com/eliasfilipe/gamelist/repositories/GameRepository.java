package com.eliasfilipe.gamelist.repositories;

import com.eliasfilipe.gamelist.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
}
