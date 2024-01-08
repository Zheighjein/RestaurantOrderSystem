/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restaurantordersystem3;

/**
 *
 * @author zheig
 */
abstract class MenuItem {
    protected String name;

    public MenuItem(String name) {
        this.name = name;
    }

    public abstract double getPrice();

    @Override
    public String toString() {
        return name;
    }
}
