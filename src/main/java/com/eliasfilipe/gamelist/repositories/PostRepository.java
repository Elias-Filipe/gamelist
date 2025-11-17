package com.eliasfilipe.gamelist.repositories;

import com.eliasfilipe.gamelist.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    void deleteByUserId(@Param("userId") Long userId);

    boolean existsByUserId(Long userId);

}
