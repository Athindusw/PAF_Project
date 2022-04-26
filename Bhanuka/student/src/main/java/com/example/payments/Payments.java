/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.payments;

import java.sql.Date;


public class Payments {

    private String nic;
    private String course;
    private double payment;
    private Date date;

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public double getPayment() {
        return payment;
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Payments(String nic, String course, double payment, Date date) {
        this.nic = nic;
        this.course = course;
        this.payment = payment;
        this.date = date;
    }

    public Payments() {
    }

}
