package com.example.assignments;

public class Student {
    private String name;
    private String id;
    private Boolean cb;
    private  String avatarUrl;
    private String phone;
    private String address;

    public Student(String name, String id, Boolean cb, String avatarUrl) {
        this.name = name;
        this.id = id;
        this.cb = cb;
        this.avatarUrl = avatarUrl;
    }

    public Student(String name, String id, Boolean cb, String avatarUrl, String phone, String address) {
        this.name = name;
        this.id = id;
        this.cb = cb;
        this.avatarUrl = avatarUrl;
        this.phone = phone;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public Boolean getCb() {
        return cb;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setCb(Boolean cb) {
        this.cb = cb;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }
}
