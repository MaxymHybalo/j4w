package ua.inventory.core;

public class Product {

    float price;
    int quantity;
    String name;

    public Product( String name,float price,int quantity) {
        this.price = price;
        this.quantity = quantity;
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this==o) return true;
        if(this.getName().equals(((Product) o).getName())) return true;
        return false;
    }

    @Override
    public String toString() {
        return "["+getName()+"] Price: " + getPrice() + ", Quantity: " + getQuantity();
    }
}
