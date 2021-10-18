package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {

        final Scanner scanner = new Scanner(System.in);

        int water = 400;
        int milk = 540;
        int beans = 120;
        int cups = 9;
        int money = 550;
        String action;
        int menu;

        display(water, milk, beans, cups, money);
        System.out.println();
        System.out.println("Write action (buy, fill, take):");
        action = scanner.next();

        if (action.equals("buy")) {
            System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
            menu = scanner.nextInt();
            switch (menu) {
                case 1:
                    water -= 250;
                    beans -= 16;
                    money += 4;
                    break;
                case 2:
                    water -= 350;
                    milk -= 75;
                    beans -= 20;
                    money += 7;
                    break;
                case 3:
                    water -= 200;
                    milk -= 100;
                    beans -= 12;
                    money += 6;
                    break;
            }
            cups--;
        } else if (action.equals("fill")) {
            System.out.println("Write how many ml of water you want to add:");
            int waterAdded = scanner.nextInt();
            System.out.println("Write how many ml of milk you want to add:");
            int milkAdded = scanner.nextInt();
            System.out.println("Write how many grams of coffee beans you want to add:");
            int beansAdded = scanner.nextInt();
            System.out.println("Write how many disposable cups of coffee you want to add:");
            int cupsAdded = scanner.nextInt();
            System.out.println("");
            water += waterAdded;
            milk += milkAdded;
            beans += beansAdded;
            cups += cupsAdded;
        } else if (action.equals("take")) {
            System.out.println("I gave you $" + money);
            money = 0;
        }
        System.out.println();
        display(water, milk, beans, cups, money);
    }

    public static void display(int water, int milk, int beans, int cups, int money) {
        System.out.println("The coffee machine has:");
        System.out.println(water + " ml of water");
        System.out.println(milk + " ml of milk");
        System.out.println(beans + " g of coffee beans");
        System.out.println(cups + " disposable cups");
        System.out.println("$" + money + " of money");
    }
}
