/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.User;

/**
 *
 * @author NimeshaKaushalya
 */
public class User {

    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getContactNo() {
        return contactNo;
    }

    public void setContactNo(int contactNo) {
        this.contactNo = contactNo;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public User() {
    }
     private int staffId;
    private String staffName;
    private int age;
    private String nic;
    private String address;
    private int contactNo; 
    private String position;

    public User(int staffId, String staffName, int age, String nic, String address, int contactNo, String position) {
        this.staffId = staffId;
        this.staffName = staffName;
        this.age = age;
        this.nic = nic;
        this.address = address;
        this.contactNo = contactNo;
        this.position = position;
    }

}
