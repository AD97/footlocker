/*
package com.wilbursandwilma.footlocker.service;

import com.wilbursandwilma.footlocker.model.Warehouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class Suppliers {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Suppliers> findAllShipment(String id) {
        try {
            List<Suppliers> supplier = jdbcTemplate.query("SELECT * FROM Suppliers",
                    BeanPropertyRowMapper.newInstance(Suppliers.class), id);

            return supplier;
        } catch (IncorrectResultSizeDataAccessException e) {
            return null;
        }
    }

    public List<Warehouse> findShipmentBySupplierID(String id) {
        try {
            List<Warehouse> warehouse = jdbcTemplate.query("SELECT modelNo,availUnits,timestamp FROM ITEMS_INVENTORY WHERE warehouseID = ?",
                    BeanPropertyRowMapper.newInstance(Warehouse.class), id);

            return warehouse;
        } catch (IncorrectResultSizeDataAccessException e) {
            return null;
        }
    }
}
*/
