/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Component;

@Component
public class UserService {
    
    Connection con;
  
  public void init (){
         
 
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/final_staff", "root", "");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
  }
    
   
  
   public User getSta(int staffId) {
      init();
        Statement stmt = null;
        ResultSet rs = null;
        User sta = null;
        
         try {
            
            stmt = con.createStatement();
            rs = stmt.executeQuery("select * from staffs where staffId=" + staffId);
            while (rs.next()) {
                int staffid = rs.getInt("staffId");
                String staffName = rs.getString("staffName");
                int age = rs.getInt("age");
                String nic = rs.getString("nic");
                String address = rs.getString("address");
                int contactNo = rs.getInt("contactNo");
                String position = rs.getString("position");

                sta = new User(staffid,staffName,age,nic,address,contactNo,position);
            }
            
            return sta;

            
            
              
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
          return sta;
    }
     public void UpdateStaff(int staffId,String staffName,int age,String nic,String address,int contactNo,String position)  {
 

    init();
          try{ 
           
      
        
         
         
         
          
          String x = "update staffs  SET staffId = "+staffId+", staffName = '"+staffName+"',age = "+age+",nic = '"+nic+"',address = '"+address+"',contactNo = "+contactNo+",position = '"+position+"'";
             Statement mystatement = con.createStatement();
           
            mystatement.executeUpdate(x);
             
           
           
              
            } 
          
catch (SQLException ex ) {
            
        
         } 
       
       catch (Exception ex ) {
           
        
       }
    }



   


    public void CreateStaff(int staffId,String staffName,int age,String nic,String address,int contactNo,String position)  {
 
        
     
      
        init();
          try{ 
           
      
        
         
         
         
          
          String x = "INSERT INTO staffs VALUES("+staffId+",'"+staffName+"',"+age+",'"+nic+"','"+address+"',"+contactNo+",'"+position+"')";
             Statement mystatement = con.createStatement();
           
            mystatement.executeUpdate(x);
             
           
           
              
            } 
          
catch (SQLException ex ) {
            
        
         } 
       
       catch (Exception ex ) {
           
        
       }
    }
 public void delete(int staffId)  {
 
        
     
      
        init();
          try{ 
           
      
        
         
         
         
          
          String x = "DELETE FROM staffs WHERE staffId = '"+staffId+"'";
             Statement mystatement = con.createStatement();
           
            mystatement.executeUpdate(x);
             
           
           
              
            } 
          
catch (SQLException ex ) {
            
        
         } 
       
       catch (Exception ex ) {
           
        
       }
    }
} 
            
        
         
   
