package com.example.assignment1.Model;

import java.util.ArrayList;

public class ToDoModel {
    private ArrayList<ToDo> ToDos = new ArrayList<>();

    public ToDoModel(){
        ToDos.add(new ToDo("day 1", "Drink enough water"));
        ToDos.add(new ToDo("day2", "legs day"));
        ToDos.add(new ToDo("do abs workouts", "3x Abdominal crunches"));
        ToDos.add(new ToDo("day3", "planks"));
        ToDos.add(new ToDo("day4", "do crunches for 20 minutes"));

    }
    public ArrayList<ToDo> getNotes(){
        ArrayList<ToDo> result = new ArrayList<>();
        for(ToDo obj : ToDos){

                result.add(obj);

        }
        return result;
    }
}
