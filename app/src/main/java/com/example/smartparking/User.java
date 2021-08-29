package com.example.smartparking;

import java.util.Objects;

public class User {

    private String name;
    private String email;
    private String role;
    private String uid;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                ", uid='" + uid + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name) && Objects.equals(email, user.email) && Objects.equals(role, user.role) && Objects.equals(uid, user.uid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, email, role, uid);
    }

    public String getUid() {


        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public User(String name, String email, String role, String uid) {
        this.name = name;
        this.email = email;
        this.role = role;
        this.uid = uid;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public User(String name, String email, String role) {
        this.name = name;
        this.email = email;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }
}
