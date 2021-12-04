package com.wilbursandwilma.footlocker.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wilbursandwilma.footlocker.model.Customer;
import com.wilbursandwilma.footlocker.service.CustomerService;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> getAllcustomers() {
        try {
            List<Customer> customers = new ArrayList<Customer>();
                customerService.findAll().forEach(customers::add);
            if (customers.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(customers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/customers/id")
    public ResponseEntity<List<Customer>> getCustomerById(@RequestParam(required = false) String id) {
        Customer customer = customerService.findById(id);

        if (customer != null) {
            return new ResponseEntity(customer, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/customers/email")
    public ResponseEntity<List<Customer>> getCustomerByEmail(@RequestParam(required = false) String email) {
            Customer customer = customerService.findByEmail(email);

        if (customer != null) {
            return new ResponseEntity(customer, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/customers/phone")
    public ResponseEntity<List<Customer>> getCustomerByPhone(@RequestParam(required = false) String phoneno) {
        Customer customer = customerService.findByPhone(phoneno);
        System.out.println(customer);
        if (customer != null) {
            return new ResponseEntity(customer, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/customers/fname")
    public ResponseEntity<List<Customer>> getCustomerByName(@RequestParam(required = false) String fname) {
        List<Customer> customer = customerService.findByName(fname);

        if (customer != null) {
            return new ResponseEntity(customer, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/customers/dob")
    public ResponseEntity<List<Customer>> getCustomerByDob(@RequestParam(required = false) Date dob) {
        List<Customer> customer = customerService.findByDob(dob);

        if (customer != null) {
            return new ResponseEntity(customer, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
