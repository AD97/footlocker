package com.wilbursandwilma.footlocker.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.wilbursandwilma.footlocker.model.Customer;
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

import com.wilbursandwilma.footlocker.model.Item;
import com.wilbursandwilma.footlocker.service.ItemService;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class ItemController {

    @Autowired
    ItemService itemService;

    @GetMapping("/items")
    public ResponseEntity<List<Item>> getAllItems() {
        try {
            List<Item> items = new ArrayList<Item>();
            itemService.findAll().forEach(items::add);
            if (items.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(items, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/items/id")
    public ResponseEntity<List<Item>> getItemById(@RequestParam(required = false) String id) {

        Item item = itemService.findById(id);

        if (item != null) {
            return new ResponseEntity(item, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/items/model")
    public ResponseEntity<List<Item>> getItemsByModel(@RequestParam(required = false) String modelNo) {

        List<Item> items = new ArrayList<Item>();
        items = itemService.findByModelNo(modelNo);
        if (items != null) {
            return new ResponseEntity(items, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/items/supplier")
    public ResponseEntity<List<Item>> getAllItemsBySupplier(@RequestParam(required = false) String supplierId) {
        try {
            List<Item> items = new ArrayList<Item>();
            items = itemService.findItemsFromSupplier(supplierId);
            if (items.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(items, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/items/update/{id}")
    public ResponseEntity<Item> updateCustomer(@PathVariable("id") String id, @RequestBody Item item){
        System.out.println("Hi there" + item.getModelno());
        Item itemData = itemService.findById(id);
        if(itemData != null){
            itemData.setItemID(id);
            itemData.setModelno(item.getModelno());
            itemData.setSupplierID(item.getSupplierID());
            System.out.println("This is item id in controller" + itemData.getItemID());
            itemService.update(itemData);
            return new ResponseEntity("Item was updated successfully.", HttpStatus.OK);
        } else {
            return new ResponseEntity("Cannot find Item with id=" + id, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/items/create")
    public ResponseEntity<Customer> createCustomer(@RequestBody Item item){
        System.out.println(item.getModelno());
        try {
            int items = itemService.save(new Item(item.getItemID(), item.getModelno(), item.getSupplierID()));
            return new ResponseEntity(items, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/items/delete/{id}")
    public ResponseEntity<String> deleteItem(@PathVariable("id") String itemId) {
        try {
            int result = itemService.deleteById(itemId);
            if (result == 0) {
                return new ResponseEntity<>("Cannot find Item with id=" + itemId, HttpStatus.OK);
            }
            return new ResponseEntity<>("Item was deleted successfully.", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Cannot delete Customer.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
