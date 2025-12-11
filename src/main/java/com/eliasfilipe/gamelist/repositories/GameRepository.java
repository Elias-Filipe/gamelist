package com.eliasfilipe.gamelist.repositories;

import com.eliasfilipe.gamelist.entities.User;
import com.eliasfilipe.gamelist.projection.GameMinProjection;
import com.eliasfilipe.gamelist.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {

    @Query(nativeQuery = true, value = """
             SELECT g.id, g.title, g.short_description AS shortDescription, g.img_url AS imgUrl, b.position
             FROM tb_belonging b
             JOIN tb_game g ON g.id = b.game_id
             WHERE b.list_id = :listId
             ORDER BY b.position
            """)
    List<GameMinProjection> searchByList(Long listId);

    Optional<Game> findGameByTitle(String title);
}
