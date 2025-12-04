package com.eliasfilipe.gamelist.repositories;

import com.eliasfilipe.gamelist.entities.Post;
import com.eliasfilipe.gamelist.projection.PostMinProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    void deleteByUserId(@Param("userId") Long userId);

    boolean existsByUserId(Long userId);



    @Query(nativeQuery = true, value = """
            SELECT p.id, p.title, p.content, u.name AS author
            FROM tb_post p
            JOIN tb_user u ON p.user_id = u.id
            WHERE p.game_id = :gameId
            ORDER BY p.id
                        """)
    List<PostMinProjection> searchByGame(Long gameId);

}
