/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.restaurantordersystem3;
import java.util.*;
/**
 *
 * @author zheig
 */
public class RestaurantOrderSystem3 {
    private static int customerNumberCounter = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Name of your Restaurant: ");
        String restaurantName = scanner.nextLine();

        int customerNumber = getCustomerNumber();

        System.out.print("Enter customer name: ");
        String customerName = scanner.nextLine();

        Order order = createOrder(scanner, customerNumber, customerName);

        order.printReceipt();

        scanner.close();
    }

    private static int getCustomerNumber() {
        return customerNumberCounter++;
    }

    private static Order createOrder(Scanner scanner, int customerNumber, String customerName) {
        System.out.println("\nMenu:");
        System.out.println("Pasta Dishes:");

        Pasta[] pastaMenu = {
                new Pasta("Pesto", 25.50),
                new Pasta("Tinapa Flakes", 23.65),
                new Pasta("Truffle", 38.90)
        };

        displayMenu(pastaMenu);

        System.out.println("\nPastries:");
        Pastry[] pastryMenu = {
                new Pastry("Cinnamon Roll", 15.95),
                new Pastry("Croissant", 17.55),
                new Pastry("Blueberry Cheesecake", 17.25),
                new Pastry("Strawberry Shortcake", 16.80)
        };

        displayMenu(pastryMenu);

        System.out.println("\nBeverages:");
        Beverage[] beverageMenu = {
                new Beverage("Cappuccino", 3.30, 5.75, 8.25),
                new Beverage("Caramel Macchiato", 4.20, 6.40, 9.85),
                new Beverage("Matcha Latte", 2.20, 4.90, 7.00)
        };

        displayMenu(beverageMenu);

        System.out.print("\nEnter table number: ");
        int tableNumber = scanner.nextInt();

        Order order = new Order(customerNumber, customerName, tableNumber);

        boolean continueOrdering = true;

        while (continueOrdering) {
            System.out.print("\nEnter the category (Pasta/Pastry/Beverage) and item number you want to order (0 to finish): ");
            String category = scanner.next().toLowerCase();

            if (category.equals("pasta") || category.equals("pastry") || category.equals("beverage")) {
                int itemNumber = scanner.nextInt();

                System.out.print("Enter the quantity: ");
                int quantity = scanner.nextInt();

                MenuItem selectedItem = null;

                switch (category) {
                    case "pasta":
                        if (itemNumber > 0 && itemNumber <= pastaMenu.length) {
                            selectedItem = pastaMenu[itemNumber - 1];
                        }
                        break;
                    case "pastry":
                        if (itemNumber > 0 && itemNumber <= pastryMenu.length) {
                            selectedItem = pastryMenu[itemNumber - 1];
                        }
                        break;
                    case "beverage":
                        if (itemNumber > 0 && itemNumber <= beverageMenu.length) {
                            System.out.print("Enter the size (Tall/Grande/Venti): ");
                            String size = scanner.next();
                            selectedItem = beverageMenu[itemNumber - 1];
                            ((Beverage) selectedItem).getPrice(size);
                        }
                        break;
                }

                if (selectedItem != null) {
                    order.addItem(new OrderItem(selectedItem, quantity));
                } else {
                    System.out.println("Invalid item number or category. Please try again.");
                }
            } else if (category.equals("0")) {
                continueOrdering = false;
            } else {
                System.out.println("Invalid category. Please try again.");
            }
        }

        return order;
    }

    private static void displayMenu(MenuItem[] menu) {
        System.out.println("0. No " + menu[0].getClass().getSimpleName());
        for (int i = 1; i <= menu.length; i++) {
            System.out.println(i + ". " + menu[i - 1].toString() + "\t$" + menu[i - 1].getPrice());
        }
    }
}