/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author NimeshaKaushalya
 */
@RestController
public class UserResource {
      @Autowired
    private UserService staffService;
      
      
       @GetMapping(path = "/update/{staffId}")
    public ResponseEntity<User> getSta(@PathVariable int staffId){
        User sta = staffService.getSta(staffId);
        return ResponseEntity.ok(sta);
    }
    
     @PostMapping(path = "/updater")
    public void UpdateStaff(@RequestBody  User sta) {
        int staffId = sta.getStaffId();
        String staffName = sta.getStaffName();
        int age = sta.getAge();
        String nic = sta.getNic();
        String address = sta.getAddress();
        int contactNo = sta.getContactNo();
        String position = sta.getPosition();
        staffService.UpdateStaff(staffId,staffName,age,nic,address,contactNo,position);
}
    
      @PostMapping(path = "/register")
    public void CreateStaff(@RequestBody  User sta) {
        int staffId = sta.getStaffId();
        String staffName = sta.getStaffName();
        int age = sta.getAge();
        String nic = sta.getNic();
        String address = sta.getAddress();
        int contactNo = sta.getContactNo();
        String position = sta.getPosition();
        staffService.CreateStaff(staffId,staffName,age,nic,address,contactNo,position);
      
    }
    
     @GetMapping(path = "/delete/{staffId}")
    public void delete(@PathVariable int staffId){
        staffService.delete(staffId);
        
    }
}