/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restaurantordersystem3;
import java.util.*;
public class Order {
    private int orderNumber;
    private String name;
    private int tableNumber;
    private ArrayList<OrderItem> items;

    public Order(int orderNumber, String name, int tableNumber) {
        this.orderNumber = orderNumber;
        this.name = name;
        this.tableNumber = tableNumber;
        this.items = new ArrayList<>();
    }

    public void addItem(OrderItem item) {
        items.add(item);
    }

    public double calculateTotal() {
        double total = 0;
        for (OrderItem item : items) {
            total += item.getTotalCost();
        }
        return total;
    }

    public void printReceipt() {
        System.out.println("BJ Alex's Diner\nOfficial Receipt\n");
        System.out.println("Order Number: " + orderNumber);
        System.out.println("Name: " + name);
        System.out.println("Table Number: " + tableNumber + "\n");

        System.out.println("Order(s):");
        for (OrderItem item : items) {
            System.out.println(item.toString());
        }

        System.out.println("\nTotal Cost: $" + calculateTotal());
    }
}
