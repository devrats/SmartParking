package com.example.smartparking;

import java.util.Objects;

public class Vehicle {

    private String vehicleNumber;
    private String type;
    private String time;

    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleNumber='" + vehicleNumber + '\'' +
                ", type='" + type + '\'' +
                ", time='" + time + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return Objects.equals(vehicleNumber, vehicle.vehicleNumber) && Objects.equals(type, vehicle.type) && Objects.equals(time, vehicle.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vehicleNumber, type, time);
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Vehicle(String vehicleNUmber, String type, String time) {
        this.vehicleNumber = vehicleNUmber;
        this.type = type;
        this.time = time;
    }

    public Vehicle() {
    }
}
