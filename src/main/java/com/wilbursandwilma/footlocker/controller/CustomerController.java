package com.wilbursandwilma.footlocker.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wilbursandwilma.footlocker.model.Customer;
import com.wilbursandwilma.footlocker.service.CustomerService;

@CrossOrigin
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

    @PutMapping("/customers/update/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable("id") String id, @RequestBody Customer customer){
        Customer customerData = customerService.findById(id);
        System.out.println("Hi there" + customerData);
        if(customerData != null){
            customerData.setCustID(id);
            customerData.setDob(customer.getDob());
            customerData.setEmail(customer.getEmail());
            customerData.setfName(customer.getfName());
            customerData.setmInitial(customer.getmInitial());
            customerData.setlName(customer.getlName());
            customerData.setGender(customer.getGender());
            customerData.setPhoneNo(customer.getPhoneNo());
            customerService.update(customerData);
            return new ResponseEntity("Customer was updated successfully.", HttpStatus.OK);
        } else {
            return new ResponseEntity("Cannot find Customer with id=" + id, HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/customers/create")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer){
        System.out.println(customer.getDob());
        try {
            int cust = customerService
                    .save(new Customer("", customer.getDob(), customer.getEmail(), customer.getPhoneNo(),
                            customer.getGender(), customer.getfName(), customer.getmInitial(), customer.getlName()));
            return new ResponseEntity(cust, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/customers/delete/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable("id") String id) {
        try {
            int result = customerService.deleteById(id);
            if (result == 0) {
                return new ResponseEntity<>("Cannot find Customer with id=" + id, HttpStatus.OK);
            }
            return new ResponseEntity<>("Customer was deleted successfully.", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Cannot delete Customer.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
