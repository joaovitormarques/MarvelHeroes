package com.example.joaovitor.shared.model;

/**
 * Created by joaovitor on 31/08/17.
 */

public class APICharacter {
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public APIThumbnail getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(APIThumbnail thumbnail) {
        this.thumbnail = thumbnail;
    }

    private long id;
    private String name;
    private String description;
    private APIThumbnail thumbnail;
}
