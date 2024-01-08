/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restaurantordersystem3;

/**
 *
 * @author zheig
 */
public class OrderItem {
    private MenuItem menuItem;
    private int quantity;

    public OrderItem(MenuItem menuItem, int quantity) {
        this.menuItem = menuItem;
        this.quantity = quantity;
    }

    public double getTotalCost() {
        return menuItem.getPrice() * quantity;
    }

    @Override
    public String toString() {
        return menuItem.toString() + "\t$" + menuItem.getPrice() + "\n" + quantity + "x\t\t\t$" + getTotalCost();
    }
}
