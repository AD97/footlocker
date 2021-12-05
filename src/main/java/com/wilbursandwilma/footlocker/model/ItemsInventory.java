package com.wilbursandwilma.footlocker.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.sql.Time;
import java.sql.Timestamp;

@IdClass(ItemsInventory.class)
public class ItemsInventory {

    @Id
    @Column(name = "modelNo")
    private String modelNo;
    @Id
    @Column(name = "warehouseID")
    private String warehouseID;
    @Id
    @Column(name = "timestamp")
    private Timestamp timestamp;
    @Column(name = "availUnits")
    private Number availUnits;

    public String getModelNo() {
        return modelNo;
    }

    public void setModelNo(String modelNo) {
        this.modelNo = modelNo;
    }

    public String getWarehouseID() {
        return warehouseID;
    }

    public void setWarehouseID(String warehouseID) {
        this.warehouseID = warehouseID;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public Number getAvailUnits() {
        return availUnits;
    }

    public void setAvailUnits(Number availUnits) {
        this.availUnits = availUnits;
    }
}
