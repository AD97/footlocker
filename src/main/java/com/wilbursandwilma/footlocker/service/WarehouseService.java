package com.wilbursandwilma.footlocker.service;

import com.wilbursandwilma.footlocker.model.Customer;
import com.wilbursandwilma.footlocker.model.ItemsInventory;
import com.wilbursandwilma.footlocker.model.Shipments;
import com.wilbursandwilma.footlocker.model.Warehouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class WarehouseService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<ItemsInventory> findInventoryByWarehouseID(String id) {
        try {
            List<ItemsInventory> itemsInventories = jdbcTemplate.query("SELECT modelNo, warehouseid, timestamp, availUnits FROM ITEMS_INVENTORY WHERE warehouseid = ?",
                    BeanPropertyRowMapper.newInstance(ItemsInventory.class), id);
            return itemsInventories;
        } catch (IncorrectResultSizeDataAccessException e) {
            return null;
        }
    }

    public List<Warehouse> findAllWarehouse() {
        try {
            List<Warehouse> warehouse = jdbcTemplate.query("SELECT * from WAREHOUSE",
                    BeanPropertyRowMapper.newInstance(Warehouse.class));

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
