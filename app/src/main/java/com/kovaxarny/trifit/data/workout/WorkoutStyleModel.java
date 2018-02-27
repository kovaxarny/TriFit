package com.kovaxarny.trifit.data.workout;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by kovax on 2018-02-27.
 */

public class WorkoutStyleModel implements Serializable{

    private String styleName;
    private int styleImage;
    private ArrayList<WorkoutModel> workoutModelItems;

    public WorkoutStyleModel() {
    }

    public WorkoutStyleModel(String styleName, int styleImage, ArrayList<WorkoutModel> workoutModelItems) {
        this.styleName = styleName;
        this.styleImage = styleImage;
        this.workoutModelItems = workoutModelItems;
    }

    public String getStyleName() {
        return styleName;
    }

    public void setStyleName(String styleName) {
        this.styleName = styleName;
    }

    public int getStyleImage() {
        return styleImage;
    }

    public void setStyleImage(int styleImage) {
        this.styleImage = styleImage;
    }

    public ArrayList<WorkoutModel> getWorkoutModelItems() {
        return workoutModelItems;
    }

    public void setWorkoutModelItems(ArrayList<WorkoutModel> workoutModelItems) {
        this.workoutModelItems = workoutModelItems;
    }
}
