package org.example.servlet;

public class Product {

   int id;
   String productName;
   String price;


    public Product(int id, String productName, String price) {
        this.id = id;
        this.productName = productName;
        this.price = price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public String getPrice() {
        return price;
    }
}
