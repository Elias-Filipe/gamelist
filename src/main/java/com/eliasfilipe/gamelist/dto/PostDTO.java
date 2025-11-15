package com.eliasfilipe.gamelist.dto;

import com.eliasfilipe.gamelist.entities.Post;
import org.springframework.beans.BeanUtils;

public class PostDTO {

    private long id;
    private String title;
    private String content;
    private UserMinDTO user;
    private GameMinDTO game;

    public PostDTO(){}

    public PostDTO(Post entity) {
        id = entity.getId();
        title = entity.getTitle();
        content = entity.getContent();
        user = new UserMinDTO(entity.getUser());
        game = new GameMinDTO(entity.getGame());
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public UserMinDTO getUser() {
        return user;
    }

    public void setUser(UserMinDTO user) {
        this.user = user;
    }

    public GameMinDTO getGame() {
        return game;
    }

    public void setGame(GameMinDTO game) {
        this.game = game;
    }
}
