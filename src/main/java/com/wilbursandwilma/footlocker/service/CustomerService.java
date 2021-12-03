package com.wilbursandwilma.footlocker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.wilbursandwilma.footlocker.model.Customer;

@Repository
public class CustomerService {
    @Autowired
    private JdbcTemplate jdbcTemplate;


//    public int save(Customer Customer) {
//        return jdbcTemplate.update("INSERT INTO Customers (title, description, published) VALUES(?,?,?)",
//                new Object[] { Customer.getTitle(), Customer.getDescription(), Customer.isPublished() });
//    }


//    public int update(Customer Customer) {
//        return jdbcTemplate.update("UPDATE Customers SET title=?, description=?, published=? WHERE id=?",
//                new Object[] { Customer.getTitle(), Customer.getDescription(), Customer.isPublished(), Customer.getId() });
//    }


    public Customer findById(Long id) {
        try {
            Customer Customer = jdbcTemplate.queryForObject("SELECT * FROM Customers WHERE id=?",
                    BeanPropertyRowMapper.newInstance(Customer.class), id);

            return Customer;
        } catch (IncorrectResultSizeDataAccessException e) {
            return null;
        }
    }


    public int deleteById(Long id) {
        return jdbcTemplate.update("DELETE FROM Customers WHERE id=?", id);
    }

    public List<Customer> findAll() {
        return jdbcTemplate.query("SELECT * from Customers", BeanPropertyRowMapper.newInstance(Customer.class));
    }


    public List<Customer> findByPublished(boolean published) {
        return jdbcTemplate.query("SELECT * from Customers WHERE published=?",
                BeanPropertyRowMapper.newInstance(Customer.class), published);
    }


    public List<Customer> findByTitleContaining(String title) {
        String q = "SELECT * from Customers WHERE title LIKE '%" + title + "%' collate binary_ci";

        return jdbcTemplate.query(q, BeanPropertyRowMapper.newInstance(Customer.class));
    }


    public int deleteAll() {
        return jdbcTemplate.update("DELETE from Customers");
    }

}




