package com.kovaxarny.trifit.data;

/**
 * Created by kovax on 2018-02-13.
 */

public class BodyStatsModel {
    private Integer _id;
    private Integer height;
    private Double weight;
    private String timestamp;

    public BodyStatsModel(Integer _id, Integer height, Double weight, String timestamp) {
        this._id = _id;
        this.height = height;
        this.weight = weight;
        this.timestamp = timestamp;
    }

    public BodyStatsModel() {
    }

    public Integer get_id() {
        return _id;
    }

    public void set_id(Integer _id) {
        this._id = _id;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return  "Stat Id=" + get_id() +
                " Height=" + getHeight() +
                " Weight=" + getWeight() +
                " Timestamp=" + getTimestamp();
    }
}
