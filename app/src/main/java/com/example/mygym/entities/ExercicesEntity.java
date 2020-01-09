package com.example.mygym.entities;

import android.media.Image;

public class ExercicesEntity {

    public String id;
    public String name;
    public String hores;
    public String iconurl;
    public String description;


    public ExercicesEntity(String id, String name,String hores, String iconurl,String description) {
        this.id = id;
        this.name = name;
        this.hores = hores;
        this.iconurl = iconurl;
        this.description = description;


    }
}

