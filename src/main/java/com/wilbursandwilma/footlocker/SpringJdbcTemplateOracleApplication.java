package com.wilbursandwilma.footlocker;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.wilbursandwilma.footlocker.model.Customer;

@SpringBootApplication
public class SpringJdbcTemplateOracleApplication implements CommandLineRunner {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public static void main(String[] args) {
        SpringApplication.run(SpringJdbcTemplateOracleApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        String sql = "SELECT * FROM Customers";

        List<Customer> customers = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Customer.class));

        customers.forEach(System.out :: println);
    }

}
