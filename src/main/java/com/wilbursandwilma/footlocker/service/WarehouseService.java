package com.wilbursandwilma.footlocker.service;

import com.wilbursandwilma.footlocker.model.Customer;
import com.wilbursandwilma.footlocker.model.Shipments;
import com.wilbursandwilma.footlocker.model.Warehouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class WarehouseService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Warehouse> findInventoryByWarehouseID(String id) {
        try {
            List<Warehouse> warehouse = jdbcTemplate.query("SELECT modelNo,availUnits,timestamp FROM ITEMS_INVENTORY WHERE warehouseID = ?",
                    BeanPropertyRowMapper.newInstance(Warehouse.class), id);

            return warehouse;
        } catch (IncorrectResultSizeDataAccessException e) {
            return null;
        }
    }

    public List<Warehouse> findAllWarehouse(String id) {
        try {
            List<Warehouse> warehouse = jdbcTemplate.query("SELECT * from WAREHOUSE",
                    BeanPropertyRowMapper.newInstance(Warehouse.class), id);

            return warehouse;
        } catch (IncorrectResultSizeDataAccessException e) {
            return null;
        }
    }

    public List<Shipments> findShipmentbyWarehouseID(String id) {
        try {
            List<Shipments> shipment = jdbcTemplate.query("SELECT shipmentID,shipmentStatus,shippingAddress," +
                            "dateOfShipping,dateOfDelivery from Shipments where warehouseID = ?",
                    BeanPropertyRowMapper.newInstance(Shipments.class), id);

            return shipment;
        } catch (IncorrectResultSizeDataAccessException e) {
            return null;
        }
    }






}
