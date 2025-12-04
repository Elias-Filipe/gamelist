package com.eliasfilipe.gamelist.dto;

import com.eliasfilipe.gamelist.entities.Post;
import com.eliasfilipe.gamelist.projection.PostMinProjection;

public class PostMinDTO {

    private long id;
    private String title;
    private String content;


    public PostMinDTO(Post entity) {
        id = entity.getId();
        title = entity.getTitle();
        content = entity.getContent();
    }

    public PostMinDTO(PostMinProjection projection) {
        id = projection.getId();
        title = projection.getTitle();
        content = projection.getContent();
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


}
