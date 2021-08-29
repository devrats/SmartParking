package com.example.smartparking;

import java.util.Objects;

public class ParkingStation {

    private String name;
    private String parkingSpaceTwoWheeler;
    private String parkingSpaceFourWheeler;
    private String email;
    private String charger4_3;
    private String charger4_6;
    private String charger4_12;
    private String charger4_24;
    private String charger4_48;
    private String charger2_3;
    private String charger2_6;
    private String charger2_12;
    private String charger2_24;
    private String charger2_48;
    private String mobileNumber;
    private String parkingStationName;
    private String address;
    private String city;
    private String state;
    private String highlight;
    private String role;
    private String uid;

    @Override
    public String toString() {
        return "ParkingStation{" +
                "name='" + name + '\'' +
                ", parkingSpaceTwoWheeler='" + parkingSpaceTwoWheeler + '\'' +
                ", parkingSpaceFourWheeler='" + parkingSpaceFourWheeler + '\'' +
                ", email='" + email + '\'' +
                ", charger4_3='" + charger4_3 + '\'' +
                ", charger4_6='" + charger4_6 + '\'' +
                ", charger4_12='" + charger4_12 + '\'' +
                ", charger4_24='" + charger4_24 + '\'' +
                ", charger4_48='" + charger4_48 + '\'' +
                ", charger2_3='" + charger2_3 + '\'' +
                ", charger2_6='" + charger2_6 + '\'' +
                ", charger2_12='" + charger2_12 + '\'' +
                ", charger2_24='" + charger2_24 + '\'' +
                ", charger2_48='" + charger2_48 + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", parkingStationName='" + parkingStationName + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", highlight='" + highlight + '\'' +
                ", role='" + role + '\'' +
                ", uid='" + uid + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParkingStation that = (ParkingStation) o;
        return Objects.equals(name, that.name) && Objects.equals(parkingSpaceTwoWheeler, that.parkingSpaceTwoWheeler) && Objects.equals(parkingSpaceFourWheeler, that.parkingSpaceFourWheeler) && Objects.equals(email, that.email) && Objects.equals(charger4_3, that.charger4_3) && Objects.equals(charger4_6, that.charger4_6) && Objects.equals(charger4_12, that.charger4_12) && Objects.equals(charger4_24, that.charger4_24) && Objects.equals(charger4_48, that.charger4_48) && Objects.equals(charger2_3, that.charger2_3) && Objects.equals(charger2_6, that.charger2_6) && Objects.equals(charger2_12, that.charger2_12) && Objects.equals(charger2_24, that.charger2_24) && Objects.equals(charger2_48, that.charger2_48) && Objects.equals(mobileNumber, that.mobileNumber) && Objects.equals(parkingStationName, that.parkingStationName) && Objects.equals(address, that.address) && Objects.equals(city, that.city) && Objects.equals(state, that.state) && Objects.equals(highlight, that.highlight) && Objects.equals(role, that.role) && Objects.equals(uid, that.uid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, parkingSpaceTwoWheeler, parkingSpaceFourWheeler, email, charger4_3, charger4_6, charger4_12, charger4_24, charger4_48, charger2_3, charger2_6, charger2_12, charger2_24, charger2_48, mobileNumber, parkingStationName, address, city, state, highlight, role, uid);
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public ParkingStation(String name, String parkingSpaceTwoWheeler, String parkingSpaceFourWheeler, String email, String charger4_3, String charger4_6, String charger4_12, String charger4_24, String charger4_48, String charger2_3, String charger2_6, String charger2_12, String charger2_24, String charger2_48, String mobileNumber, String parkingStationName, String address, String city, String state, String highlight, String role, String uid) {

        this.name = name;
        this.parkingSpaceTwoWheeler = parkingSpaceTwoWheeler;
        this.parkingSpaceFourWheeler = parkingSpaceFourWheeler;
        this.email = email;
        this.charger4_3 = charger4_3;
        this.charger4_6 = charger4_6;
        this.charger4_12 = charger4_12;
        this.charger4_24 = charger4_24;
        this.charger4_48 = charger4_48;
        this.charger2_3 = charger2_3;
        this.charger2_6 = charger2_6;
        this.charger2_12 = charger2_12;
        this.charger2_24 = charger2_24;
        this.charger2_48 = charger2_48;
        this.mobileNumber = mobileNumber;
        this.parkingStationName = parkingStationName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.highlight = highlight;
        this.role = role;
        this.uid = uid;
    }

    public String getRole() {

        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public ParkingStation(String name, String parkingSpaceTwoWheeler, String parkingSpaceFourWheeler, String email, String charger4_3, String charger4_6, String charger4_12, String charger4_24, String charger4_48, String charger2_3, String charger2_6, String charger2_12, String charger2_24, String charger2_48, String mobileNumber, String parkingStationName, String address, String city, String state, String highlight, String role) {
        this.name = name;
        this.parkingSpaceTwoWheeler = parkingSpaceTwoWheeler;
        this.parkingSpaceFourWheeler = parkingSpaceFourWheeler;
        this.email = email;
        this.charger4_3 = charger4_3;
        this.charger4_6 = charger4_6;
        this.charger4_12 = charger4_12;
        this.charger4_24 = charger4_24;
        this.charger4_48 = charger4_48;
        this.charger2_3 = charger2_3;
        this.charger2_6 = charger2_6;
        this.charger2_12 = charger2_12;
        this.charger2_24 = charger2_24;
        this.charger2_48 = charger2_48;
        this.mobileNumber = mobileNumber;
        this.parkingStationName = parkingStationName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.highlight = highlight;
        this.role = role;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getParkingStationName() {
        return parkingStationName;
    }

    public void setParkingStationName(String parkingStationName) {
        this.parkingStationName = parkingStationName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getHighlight() {
        return highlight;
    }

    public void setHighlight(String highlight) {
        this.highlight = highlight;
    }

    public ParkingStation(String name, String parkingSpaceTwoWheeler, String parkingSpaceFourWheeler, String email, String charger4_3, String charger4_6, String charger4_12, String charger4_24, String charger4_48, String charger2_3, String charger2_6, String charger2_12, String charger2_24, String charger2_48, String mobileNumber, String parkingStationName, String address, String city, String state, String highlight) {
        this.name = name;
        this.parkingSpaceTwoWheeler = parkingSpaceTwoWheeler;
        this.parkingSpaceFourWheeler = parkingSpaceFourWheeler;
        this.email = email;
        this.charger4_3 = charger4_3;
        this.charger4_6 = charger4_6;
        this.charger4_12 = charger4_12;
        this.charger4_24 = charger4_24;
        this.charger4_48 = charger4_48;
        this.charger2_3 = charger2_3;
        this.charger2_6 = charger2_6;
        this.charger2_12 = charger2_12;
        this.charger2_24 = charger2_24;
        this.charger2_48 = charger2_48;
        this.mobileNumber = mobileNumber;
        this.parkingStationName = parkingStationName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.highlight = highlight;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCharger4_3() {
        return charger4_3;
    }

    public void setCharger4_3(String charger4_3) {
        this.charger4_3 = charger4_3;
    }

    public String getCharger4_6() {
        return charger4_6;
    }

    public void setCharger4_6(String charger4_6) {
        this.charger4_6 = charger4_6;
    }

    public String getCharger4_12() {
        return charger4_12;
    }

    public void setCharger4_12(String charger4_12) {
        this.charger4_12 = charger4_12;
    }

    public String getCharger4_24() {
        return charger4_24;
    }

    public void setCharger4_24(String charger4_24) {
        this.charger4_24 = charger4_24;
    }

    public String getCharger4_48() {
        return charger4_48;
    }

    public void setCharger4_48(String charger4_48) {
        this.charger4_48 = charger4_48;
    }

    public String getCharger2_3() {
        return charger2_3;
    }

    public void setCharger2_3(String charger2_3) {
        this.charger2_3 = charger2_3;
    }

    public String getCharger2_6() {
        return charger2_6;
    }

    public void setCharger2_6(String charger2_6) {
        this.charger2_6 = charger2_6;
    }

    public String getCharger2_12() {
        return charger2_12;
    }

    public void setCharger2_12(String charger2_12) {
        this.charger2_12 = charger2_12;
    }

    public String getCharger2_24() {
        return charger2_24;
    }

    public void setCharger2_24(String charger2_24) {
        this.charger2_24 = charger2_24;
    }

    public String getCharger2_48() {
        return charger2_48;
    }

    public void setCharger2_48(String charger2_48) {
        this.charger2_48 = charger2_48;
    }

    public ParkingStation(String name, String parkingSpaceTwoWheeler, String parkingSpaceFourWheeler, String email, String charger4_3, String charger4_6, String charger4_12, String charger4_24, String charger4_48, String charger2_3, String charger2_6, String charger2_12, String charger2_24, String charger2_48) {
        this.name = name;
        this.parkingSpaceTwoWheeler = parkingSpaceTwoWheeler;
        this.parkingSpaceFourWheeler = parkingSpaceFourWheeler;
        this.email = email;
        this.charger4_3 = charger4_3;
        this.charger4_6 = charger4_6;
        this.charger4_12 = charger4_12;
        this.charger4_24 = charger4_24;
        this.charger4_48 = charger4_48;
        this.charger2_3 = charger2_3;
        this.charger2_6 = charger2_6;
        this.charger2_12 = charger2_12;
        this.charger2_24 = charger2_24;
        this.charger2_48 = charger2_48;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParkingSpaceTwoWheeler() {
        return parkingSpaceTwoWheeler;
    }

    public void setParkingSpaceTwoWheeler(String parkingSpaceTwoWheeler) {
        this.parkingSpaceTwoWheeler = parkingSpaceTwoWheeler;
    }

    public String getParkingSpaceFourWheeler() {
        return parkingSpaceFourWheeler;
    }

    public void setParkingSpaceFourWheeler(String parkingSpaceFourWheeler) {
        this.parkingSpaceFourWheeler = parkingSpaceFourWheeler;
    }

    public ParkingStation() {
    }

    public ParkingStation(String name, String parkingSpaceTwoWheeler, String parkingSpaceFourWheeler) {
        this.name = name;
        this.parkingSpaceTwoWheeler = parkingSpaceTwoWheeler;
        this.parkingSpaceFourWheeler = parkingSpaceFourWheeler;
    }
}
