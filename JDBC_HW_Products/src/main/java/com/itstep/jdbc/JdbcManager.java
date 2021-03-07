package com.itstep.jdbc;

import com.itstep.jdbc.model.Item;
import com.itstep.jdbc.service.DbService;
import com.itstep.jdbc.service.DbServiceImpl;

import java.util.Scanner;

public class JdbcManager {
    public static void main(String[] args) {
        ShowMenu();
    }

    public static void ShowMenu() {
        Scanner input = new Scanner(System.in);
        DbService service = new DbServiceImpl();

        int choice = 5;
        while (choice != 0) {
            System.out.println("PRESS [1] TO ADD ITEMS\n" +
                    "PRESS [2] TO LIST ITEMS\n" +
                    "PRESS [3] TO DELETE ITEMS\n" +
                    "PRESS [0] TO EXIT");
            choice = input.nextInt();
            if (choice == 1) {
                Scanner input2 = new Scanner(System.in);
                System.out.println("Enter the Name of product you want to add");
                String name = input2.nextLine();
                System.out.println("Enter the Price of product");
                Double price = input.nextDouble();
                Item item = new Item();
                item.setName(name);
                item.setPrice(price);
                service.setNewItem(item);
            } else if (choice == 2) {
                System.out.println("List of Items");
                System.out.println(service.getAllItems());
            } else if (choice == 3) {
                System.out.println("Enter the ID of product you want to delete");
                Integer id = input.nextInt();
                service.deleteItem(id);
            } else if (choice < 0 || choice > 3) {
                System.out.println("You chose wrong. Try again!");
            }
        }
        System.out.println("Transition is completed");
    }
}
