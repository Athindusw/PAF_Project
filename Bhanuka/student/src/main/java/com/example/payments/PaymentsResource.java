/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.payments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentsResource {
    @Autowired
    private PaymentsService paymentsService;
    
    @PostMapping(path = "/updatePayment")
    public void updatePayments(@RequestBody Payments pay) {
        String nic = pay.getNic();
        String course = pay.getCourse();
        Double payment = pay.getPayment();
        paymentsService.updatePayments(nic, course, payment);
    }

    @PostMapping(path = "/paymentAdd")
    public void createPayments(@RequestBody Payments pay) {
        String nic = pay.getNic();
        String course = pay.getCourse();
        Double payment = pay.getPayment();
        paymentsService.createPayments(nic, course, payment );
    }

    @GetMapping(path = "/searchPayment/{nic}")
    public ResponseEntity<Payments> getPayments(@PathVariable String nic) {
        Payments pay = paymentsService.getPayments(nic);
        return ResponseEntity.ok(pay);
    }
}
