package ua.inventory.core;

import java.util.*;

public class Inventory {

    private Map<String,Product> inventory = new TreeMap<>();

    Inventory(){
        setProductIntoInventory(new Product("Cookies", 24.32f,12));
        setProductIntoInventory(new Product("Tea",23,12));
        setProductIntoInventory(new Product("Coffee",3,12));
        setProductIntoInventory(new Product("Coffee",3,32));
        while (true) {
            printInventoryValue();
            try {
                setProductIntoInventory(readProduct(new Scanner(System.in)));
            }catch (InputMismatchException e){
                System.out.println("[_You enter some wrong argument_]");
                continue;
            }
        }
    }
    public static void main(String[] args) {
        new Inventory();
    }
    private void setProductIntoInventory(Product p){
        String key = p.getName();
        Product product = inventory.get(key);
        if(product==null){
            product = p;
        }else{
            product.setPrice(product.getPrice()+p.getPrice());
            product.setQuantity(product.getQuantity()+p.getQuantity());
        }
        inventory.put(key,product);
    }
    private void printInventoryValue(){
        Set<String> keys = inventory.keySet();
        System.out.println("Inventory: ");
        for(String key:keys){
            System.out.println(inventory.get(key));
        }
    }
    private Product readProduct(Scanner scanner){
        System.out.println("[_Add a new product to inventory_]");
        System.out.println("Enter product name:");
        String name = scanner.next();
        System.out.println("Enter product price:");
        float price = scanner.nextFloat();
        System.out.println("Enter product quantity:");
        int quantity = scanner.nextInt();
        return new Product(name,price,quantity);
    }
}
