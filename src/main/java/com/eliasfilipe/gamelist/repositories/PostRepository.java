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
        SELECT post.id, post.title, post.content
        FROM tb_post post
        WHERE post.game_id = :gameId
        ORDER BY post.id
        """)
    List<PostMinProjection> searchByGame(Long gameId);

}
