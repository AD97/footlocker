package com.wilbursandwilma.footlocker.model;


public class ItemType {
    private String modelno;
    private String appareltype;
    private String color;
    private Number itemSize;
    private Number price;
    private String brandid;

    public String getModelno() {
        return modelno;
    }

    public void setModelno(String modelno) {
        this.modelno = modelno;
    }

    public String getAppareltype() {
        return appareltype;
    }

    public void setAppareltype(String appareltype) {
        this.appareltype = appareltype;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Number getItemSize() {
        return itemSize;
    }

    public void setItemSize(Number itemSize) {
        this.itemSize = itemSize;
    }

    public Number getPrice() {
        return price;
    }

    public void setPrice(Number price) {
        this.price = price;
    }

    public String getBrandid() {
        return brandid;
    }

    public void setBrandid(String brandid) {
        this.brandid = brandid;
    }
}
