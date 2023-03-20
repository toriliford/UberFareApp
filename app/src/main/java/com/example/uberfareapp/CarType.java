package com.example.uberfareapp;

import java.util.ArrayList;

public class CarType {

    public static ArrayList<CarType> carTypeArrayList = new ArrayList<>();
    String carName;

    public CarType(String carName){
        this.carName = carName;
    }

    public String getCarName(){
        return carName;
    }

    public void setCarName(String carName){
        this.carName = carName;
    }

    //populate arrayList

    public static void popCarArray(){
        CarType smartCar = new CarType("Smart Car");
        carTypeArrayList.add(smartCar);
        CarType sedan = new CarType("Sedan");
        carTypeArrayList.add(sedan);
        CarType minivan = new CarType("Minivan");
        carTypeArrayList.add(minivan);
    }

    public ArrayList<CarType> getCarTypeArrayList(){
        return carTypeArrayList;
    }

    public String toString(){
        return carName;
    }
}
