package com.wilbursandwilma.footlocker.model;

import javax.persistence.Column;
import javax.persistence.Id;

public class Categories {

    @Id
    @Column(name = "categoryID")
    private String categoryID;
    @Column(name = "categoryName")
    private String categoryName;

    public String getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(String categoryID) {
        this.categoryID = categoryID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
