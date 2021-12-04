package com.wilbursandwilma.footlocker.service;

import java.util.Date;
import java.util.List;

import com.wilbursandwilma.footlocker.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomMapEditor;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.wilbursandwilma.footlocker.model.Item;

public class ItemService {
    @Autowired
    private JdbcTemplate jdbcTemplate;


    public int save(Item Item) {
        return jdbcTemplate.update("INSERT INTO Items (timestamp, modelno, supplierID) VALUES(?,?,?)",
                new Object[] { Item.getTimestamp(), Item.getModelno(), Item.getSupplierID()});
    }

    public Item findById(String id) {
        try {
            Item Item = jdbcTemplate.queryForObject("SELECT * FROM Items WHERE id=?",
                    BeanPropertyRowMapper.newInstance(Item.class), id);

            return Item;
        } catch (IncorrectResultSizeDataAccessException e) {
            return null;
        }
    }

    public List<Item> findAll() {
        return jdbcTemplate.query("SELECT * from Items", BeanPropertyRowMapper.newInstance(Item.class));
    }


    public List<Item> findItemsFromSupplier(String supplierID) {
        return jdbcTemplate.query("SELECT * from Items WHERE supplierID = supplierID", BeanPropertyRowMapper.newInstance(Item.class));
    }

    public List<Item> findByModelNo(String modelno){
        try{
            return jdbcTemplate.query("SELECT * from Items WHERE lower(modelno) like ?",
                    BeanPropertyRowMapper.newInstance(Item.class), modelno);
        } catch (IncorrectResultSizeDataAccessException e) {
            return null;
        }
    }

    public int deleteAll() {
        return jdbcTemplate.update("DELETE from Items");
    }
}
