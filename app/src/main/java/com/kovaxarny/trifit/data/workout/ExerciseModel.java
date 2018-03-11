package com.kovaxarny.trifit.data.workout;

/**
 * Created by kovax on 2018-03-11.
 */

public class ExerciseModel {
    private Integer _id;
    private String name;
    private String type;
    private String muscle;
    private String description;
    private String equipment;

    public ExerciseModel() {
    }

    public ExerciseModel(String name, String type, String muscle, String description, String equipment) {
        this.name = name;
        this.type = type;
        this.muscle = muscle;
        this.description = description;
        this.equipment = equipment;
    }

    public Integer get_id() {
        return _id;
    }

    public void set_id(Integer _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMuscle() {
        return muscle;
    }

    public void setMuscle(String muscle) {
        this.muscle = muscle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    @Override
    public String toString() {
        return "ExerciseModel{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", muscle='" + muscle + '\'' +
                ", description='" + description + '\'' +
                ", equipment='" + equipment + '\'' +
                '}';
    }
}
