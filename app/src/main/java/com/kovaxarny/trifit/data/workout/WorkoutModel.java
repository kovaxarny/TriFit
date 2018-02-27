package com.kovaxarny.trifit.data.workout;

import java.io.Serializable;

/**
 * Created by kovax on 2018-02-27.
 */

public class WorkoutModel implements Serializable {
    private String workoutName;
    private int workoutImage;

    public WorkoutModel() {
    }

    public WorkoutModel(String workoutName, int workoutImage) {
        this.workoutName = workoutName;
        this.workoutImage = workoutImage;
    }

    public String getWorkoutName() {
        return workoutName;
    }

    public void setWorkoutName(String workoutName) {
        this.workoutName = workoutName;
    }

    public int getWorkoutImage() {
        return workoutImage;
    }

    public void setWorkoutImage(int workoutImage) {
        this.workoutImage = workoutImage;
    }
}
