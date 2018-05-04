package com.kartik.entity;

public class Train {
      Integer id;
      Integer totalSeatCount;
      String trainName;
      String sourceStation;
      String destinationStation;



    //empty Constructor
    public Train() {
    }

    public Train(String trainName) {
        this.trainName = trainName;
    }

    public Train(String sourceStation, String destinationStation) {
        this.sourceStation = sourceStation;
        this.destinationStation = destinationStation;
    }

    public Train(Integer id, String trainName, String sourceStation, String destinationStation, Integer totalSeatCount) {
        this.sourceStation = sourceStation;
        this.destinationStation = destinationStation;
        this.id = id;
        this.trainName = trainName;
        this.totalSeatCount= totalSeatCount;
    }
//    public Train(String trainName) {
//        this.trainName = trainName;
//    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public String getSourceStation() {
        return sourceStation;
    }

    public void setSourceStation(String sourceStation) {
        this.sourceStation = sourceStation;
    }

    public String getDestinationStation() {
        return destinationStation;
    }

    public void setDestinationStation(String destinationStation) {
        this.destinationStation = destinationStation;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTotalSeatCount() {
        return totalSeatCount;
    }

    public void setTotalSeatCount(Integer totalSeatCount) {
        this.totalSeatCount = totalSeatCount;
    }

    @Override
    public String  toString() {
        return "Train{" +
                "id=" + id +
                ", totalSeatCount=" + totalSeatCount +
                ", trainName='" + trainName + '\'' +
                ", sourceStation='" + sourceStation + '\'' +
                ", destinationStation='" + destinationStation + '\'' +
                '}';
    }
}
