package com.example.smartparking;

import java.util.Objects;

public class ParkingStation {

    private String name;
    private int parkingSpaceTwoWheeler;
    private int parkingSpaceFourWheeler;

    @Override
    public String toString() {
        return "ParkingStation{" +
                "name='" + name + '\'' +
                ", parkingSpaceTwoWheeler=" + parkingSpaceTwoWheeler +
                ", parkingSpaceFourWheeler=" + parkingSpaceFourWheeler +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParkingStation that = (ParkingStation) o;
        return parkingSpaceTwoWheeler == that.parkingSpaceTwoWheeler && parkingSpaceFourWheeler == that.parkingSpaceFourWheeler && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, parkingSpaceTwoWheeler, parkingSpaceFourWheeler);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getParkingSpaceTwoWheeler() {
        return parkingSpaceTwoWheeler;
    }

    public void setParkingSpaceTwoWheeler(int parkingSpaceTwoWheeler) {
        this.parkingSpaceTwoWheeler = parkingSpaceTwoWheeler;
    }

    public int getParkingSpaceFourWheeler() {
        return parkingSpaceFourWheeler;
    }

    public void setParkingSpaceFourWheeler(int parkingSpaceFourWheeler) {
        this.parkingSpaceFourWheeler = parkingSpaceFourWheeler;
    }

    public ParkingStation() {
    }

    public ParkingStation(String name, int parkingSpaceTwoWheeler, int parkingSpaceFourWheeler) {
        this.name = name;
        this.parkingSpaceTwoWheeler = parkingSpaceTwoWheeler;
        this.parkingSpaceFourWheeler = parkingSpaceFourWheeler;
    }
}
