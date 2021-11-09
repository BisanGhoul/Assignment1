package com.example.assignment1.Model;

public class Workout {
    private String name;
    private String type;
    private int duration;
    private int sets;
    private int img;

    public Workout(String name, String type, int duration, int sets, int img) {
        this.name = name;
        this.type = type;
        this.duration = duration;
        this.sets = sets;
        this.img = img;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getSets() {
        return sets;
    }

    public void setSets(int sets) {
        this.sets = sets;
    }
}
