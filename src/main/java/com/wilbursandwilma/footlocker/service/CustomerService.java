package com.wilbursandwilma.footlocker.service;

import java.util.Date;
import java.util.List;

import com.wilbursandwilma.footlocker.model.CustomerOnlineSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomMapEditor;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.wilbursandwilma.footlocker.model.Customer;

@Repository
public class CustomerService {
    @Autowired
    private JdbcTemplate jdbcTemplate;


    public int save(Customer Customer) {
        return jdbcTemplate.update("INSERT INTO Customers (custId, dob, email, phoneno, gender, fname, minitial, lname) VALUES(?,?,?,?,?,?,?,?)",
                new Object[] {"", Customer.getDob(), Customer.getEmail(), Customer.getPhoneNo(),
                        Customer.getGender(), Customer.getfName(), Customer.getmInitial(), Customer.getlName()});
    }
    public int update(Customer Customer) {
        System.out.println(Customer.getfName());
        return jdbcTemplate.update("UPDATE Customers SET dob=?, email=?, phoneno=?, gender=?, fname=?, minitial=?, lname=? WHERE CUSTID=?",
                new Object[] { Customer.getDob(), Customer.getEmail(), Customer.getPhoneNo(),
                        Customer.getGender(), Customer.getfName(), Customer.getmInitial(), Customer.getlName(), Customer.getCustID() });
    }
    public Customer findById(String id) {
        try {
            Customer Customer = jdbcTemplate.queryForObject("SELECT * FROM Customers WHERE custID=?",
                    BeanPropertyRowMapper.newInstance(Customer.class), id);

            return Customer;
        } catch (IncorrectResultSizeDataAccessException e) {
            return null;
        }
    }


    public int deleteById(String id) {
        return jdbcTemplate.update("DELETE FROM Customers WHERE CustID=?", id);
    }

    public List<Customer> findAll() {
        return jdbcTemplate.query("SELECT * from Customers", BeanPropertyRowMapper.newInstance(Customer.class));
    }


    public List<Customer> findByDob(Date dob){
        try{
            return jdbcTemplate.query("SELECT * from Customers WHERE dob=?",
                    BeanPropertyRowMapper.newInstance(Customer.class), dob);
        } catch (IncorrectResultSizeDataAccessException e) {
            return null;
        }
    }
    public Customer findByEmail(String email) {
        try {
            Customer Customer = jdbcTemplate.queryForObject("SELECT * from Customers WHERE email=?",
                    BeanPropertyRowMapper.newInstance(Customer.class), email);

            return Customer;
        } catch (IncorrectResultSizeDataAccessException e) {
            return null;
        }
    }
    public Customer findByPhone(String phoneNo) {
        try {
            Customer Customer = jdbcTemplate.queryForObject("SELECT * from Customers WHERE phoneNo=?",
                    BeanPropertyRowMapper.newInstance(Customer.class), phoneNo);

            return Customer;
        } catch (IncorrectResultSizeDataAccessException e) {
            return null;
        }
    }

    public List<Customer> findByName(String name){
        try{
            return jdbcTemplate.query("SELECT * from Customers WHERE lower(fname) like ?",
                    BeanPropertyRowMapper.newInstance(Customer.class), name);
        } catch (IncorrectResultSizeDataAccessException e) {
            return null;
        }
    }

    public List<CustomerOnlineSession> findbySessionCustID(String id){
        try{
            return jdbcTemplate.query("Select * from Customer_online_session where id = ?",
                    BeanPropertyRowMapper.newInstance(CustomerOnlineSession.class), id);
        } catch(IncorrectResultSizeDataAccessException e){
            return null;
        }
    }

    public List<CustomerOnlineSession> findAllSession(){
        try{
            return jdbcTemplate.query("Select * from Customer_online_session",
                    BeanPropertyRowMapper.newInstance(CustomerOnlineSession.class));
        } catch(IncorrectResultSizeDataAccessException e){
            return null;
        }
    }

    public int deleteAll() {
        return jdbcTemplate.update("DELETE from Customers");
    }

}




