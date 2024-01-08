/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restaurantordersystem3;

/**
 *
 * @author zheig
 */
public class Beverage extends MenuItem{
    private double tallPrice;
    private double grandePrice;
    private double ventiPrice;

    public Beverage(String name, double tallPrice, double grandePrice, double ventiPrice) {
        super(name);
        this.tallPrice = tallPrice;
        this.grandePrice = grandePrice;
        this.ventiPrice = ventiPrice;
    }

    @Override
    public double getPrice() {
        // Assuming the default size is tall
        return tallPrice;
    }

    public double getPrice(String size) {
        switch (size.toLowerCase()) {
            case "tall":
                return tallPrice;
            case "grande":
                return grandePrice;
            case "venti":
                return ventiPrice;
            default:
                return tallPrice;
        }
    }
}
