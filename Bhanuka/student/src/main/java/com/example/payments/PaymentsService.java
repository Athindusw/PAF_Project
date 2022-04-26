/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.payments;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Component;


@Component
public class PaymentsService {
    Connection con;
    String nics;

    public void init() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/bill_db", "root", "");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(PaymentsService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void getStudentNIC(String nic) {

        init();
        Statement stmt = null;
        ResultSet rs = null;

        try {

            stmt = con.createStatement();
            rs = stmt.executeQuery("select * from student where nic =  '" + nic + "'");
            while (rs.next()) {
                nics = rs.getString("nic");
            }
        } catch (SQLException ex) {

        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
            }
        }
    }

    public void createPayments(String nic, String course, Double payment) {
        getStudentNIC(nic);
        init();
        LocalDate localDate = LocalDate.now();
        if (nics != null) {
            try {

                String x = "INSERT INTO payments (nic,course,payment,date) VALUES('" + nics + "','" + course + "','" + payment + "','"+localDate+"')";
                Statement mystatement = con.createStatement();

                mystatement.executeUpdate(x);

            } catch (SQLException ex) {

            } catch (Exception ex) {

            }
            nics = null;
        }
    }

    public Payments getPayments(String nic) {
        init();
        Statement stmt = null;
        ResultSet rs = null;
        Payments pay = null;

        try {

            stmt = con.createStatement();
            rs = stmt.executeQuery("select * from payments where nic='" + nic + "'");
            while (rs.next()) {
                nic = rs.getString("nic");
                String course = rs.getString("course");

                Double payment = rs.getDouble("payment");
                Date date = rs.getDate("date");

                pay = new Payments(nic, course, payment, date);
            }

            return pay;

        } catch (SQLException ex) {

        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
            }
        }
        return pay;
    }

    public void updatePayments(String nic, String course, Double payment) {

        init();
        try {

            String x = "update payments SET nic = '" + nic + "',course = '" + course + "',payment = '" + payment + "'";
            Statement mystatement = con.createStatement();

            mystatement.executeUpdate(x);

        } catch (SQLException ex) {

        } catch (Exception ex) {

        }
    }
}
