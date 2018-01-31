package com.example.joaovitor.shared;

/**
 * Created by joaovitor on 30/08/17.
 */

public class HeroModel {

    private String name;
    private String image;

    public HeroModel(){}

    public HeroModel(String name, String image) {
        this.name = name;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }




}
