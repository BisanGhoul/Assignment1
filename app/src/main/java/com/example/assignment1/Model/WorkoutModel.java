package com.example.assignment1.Model;

import com.example.assignment1.R;

import java.util.ArrayList;

public class WorkoutModel implements InterfaceWorkout {
    private ArrayList<Workout> Workouts = new ArrayList<>();

    public WorkoutModel(){
        Workouts.add(new Workout("lower abs", "abs", 2,3,R.drawable.lowerabs));
        Workouts.add(new Workout("planks", "abs", 20,3,R.drawable.plank));
//        Workouts.add(new Workout("Hand slide crunch", "arms", 5,5));
//        Workouts.add(new Workout("Reverse crunch", "abs", 5,6));
//        Workouts.add(new Workout("Mountain climber", "abs", 10,2));
//        Workouts.add(new Workout("Abs roll-out", "abs", 5,5));
        Workouts.add(new Workout("Front squat", "legs", 10,1,R.drawable.frontsquat));
        Workouts.add(new Workout("back squat", "legs", 5,6,R.drawable.backsquat));
//        Workouts.add(new Workout("Romanian deadlift", "legs", 10,2));
//        Workouts.add(new Workout("Walking lunges", "legs", 5,5));
//        Workouts.add(new Workout("Reverse lunge", "legs", 10,1));
        Workouts.add(new Workout("Hammer Curl", "arms", 2,5,R.drawable.hummercurl));
        Workouts.add(new Workout("Dip", "arms", 15,2,R.drawable.dips));
//        Workouts.add(new Workout("Close-grip Curl", "arms", 1,5));
//        Workouts.add(new Workout("Chinup", "arms", 10,2));
//        Workouts.add(new Workout("Suspension Trainer Triceps Extension", "arms", 6,2));



    }
    public ArrayList<Workout> getWorkoutsByTypr(String type){
        ArrayList<Workout> result = new ArrayList<>();
        for(Workout w : Workouts){
            if(w.getType().equals(type)){
                result.add(w);
            }
        }
        return result;
    }
}
