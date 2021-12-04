package com.wilbursandwilma.footlocker.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

import com.wilbursandwilma.footlocker.model.ItemType;
import com.wilbursandwilma.footlocker.service.ItemTypeService;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class ItemTypeController {

    @Autowired
    ItemTypeService itemTypeService;

    @GetMapping("/itemtypes")
    public ResponseEntity<List<ItemType>> getAllItemTypes() {
        try {
            List<ItemType> items = new ArrayList<ItemType>();
            itemTypeService.findAll().forEach(items::add);
            if (items.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(items, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/items/id")
    public ResponseEntity<List<ItemType>> getItemById(@RequestParam(required = false) String id) {
        ItemType item = itemTypeService.findById(id);

        if (item != null) {
            return new ResponseEntity(item, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/items/supplierid")
    public ResponseEntity<List<ItemType>> getAllItemsBySupplier(@RequestParam(required = false) String supplierId) {
        try {
            List<ItemType> items = new ArrayList<ItemType>();
            itemTypeService.findItemsFromSupplier(supplierId);
            if (items.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(items, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
