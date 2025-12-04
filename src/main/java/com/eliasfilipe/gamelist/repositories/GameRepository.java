package com.eliasfilipe.gamelist.repositories;

import com.eliasfilipe.gamelist.projection.GameMinProjection;
import com.eliasfilipe.gamelist.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {

    @Query(nativeQuery = true, value = """
        SELECT tb_post.id AS id, tb_post.title AS title, tb_post.content AS content, tb_user.name AS author
        FROM tb_post
        INNER JOIN tb_user
        ON tb_post.user_id = tb_user.id
        WHERE tb_post.game_id = :gameId
        ORDER BY tb_post.id
			""")
    List<GameMinProjection> searchByList(Long listId);

}
