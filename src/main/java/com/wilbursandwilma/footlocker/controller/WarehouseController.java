package com.wilbursandwilma.footlocker.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.wilbursandwilma.footlocker.model.*;
import com.wilbursandwilma.footlocker.service.CustomerService;
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

import com.wilbursandwilma.footlocker.model.Warehouse;
import com.wilbursandwilma.footlocker.model.Shipments;
import com.wilbursandwilma.footlocker.model.ItemsInventory;
import com.wilbursandwilma.footlocker.service.WarehouseService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class WarehouseController {
    @Autowired
    WarehouseService warehouseService;

    @GetMapping("/warehouses")
    public ResponseEntity<List<Warehouse>> getAllWarehouses() {
        try {
            List<Warehouse> items = new ArrayList<Warehouse>();
            warehouseService.findAllWarehouse().forEach(items::add);
            if (items.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(items, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/warehouses/id")
    public ResponseEntity<List<Warehouse>> getShipmentsById(@RequestParam(required = false) String id) {
            List<Shipments> shipments = new ArrayList<Shipments>();
            warehouseService.findShipmentbyWarehouseID(id);
            if (shipments != null) {
                return new ResponseEntity(shipments, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
    }
    @GetMapping("/warehouses/inventory")
    public ResponseEntity<List<ItemsInventory>> findItemsInWarehouse(@RequestParam(required = false) String id) {
        List<ItemsInventory> itemsInventories = warehouseService.findInventoryByWarehouseID(id);

        if (itemsInventories != null) {
            return new ResponseEntity(itemsInventories, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
