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

import com.wilbursandwilma.footlocker.model.ItemType;

@Repository
public class ItemTypeService {
    @Autowired
    private JdbcTemplate jdbcTemplate;


    public int save(ItemType Item) {
        return jdbcTemplate.update("INSERT INTO ItemType (modelno, apparelType, color, itemSize, price, brandid) VALUES(?,?,?,?,?,?)",
                new Object[] { });
    }


    public List<ItemType> findAll() {
        return jdbcTemplate.query("SELECT * from Item_Type", BeanPropertyRowMapper.newInstance(ItemType.class));
    }


    public List<ItemType> findItemsFromSupplier(String supplierID) {
        return jdbcTemplate.query("SELECT * from Items WHERE supplierID = supplierID", BeanPropertyRowMapper.newInstance(ItemType.class));
    }

    public List<ItemType> findByModelNo(String modelno){
        try{
            return jdbcTemplate.query("SELECT * from Item_Type WHERE lower(modelno) like ?",
                    BeanPropertyRowMapper.newInstance(ItemType.class), modelno);
        } catch (IncorrectResultSizeDataAccessException e) {
            return null;
        }
    }

    public int deleteAll() {
        return jdbcTemplate.update("DELETE from Items");
    }
}
