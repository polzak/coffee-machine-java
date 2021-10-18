package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {

        final Scanner scanner = new Scanner(System.in);

        //espresso
        final int WATER_1 = 250;
        final int MILK_1 = 0;
        final int BEANS_1 = 16;
        final int PRICE_1 = 4;
        //latte
        final int WATER_2 = 350;
        final int MILK_2 = 75;
        final int BEANS_2 = 20;
        final int PRICE_2 = 7;
        //cappuccino
        final int WATER_3 = 200;
        final int MILK_3 = 100;
        final int BEANS_3 = 12;
        final int PRICE_3 = 6;

        int water = 400;
        int milk = 540;
        int beans = 120;
        int waterNeeded = 0;
        int milkNeeded = 0;
        int beansNeeded = 0;
        int price = 0;
        int cups = 9;
        int money = 550;
        String action;
        String menu;

        boolean exit = false;
        boolean notEnough = false;

        while (!exit) {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            action = scanner.next();
            System.out.println();

            if (action.equals("exit")) {
                exit = true;
                break;
            }

            if (action.equals("remaining")) {
                display(water, milk, beans, cups, money);
                System.out.println();
                continue;
            }

            if (action.equals("buy")) {
                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
                menu = scanner.next();

                switch (menu) {
                    case "1":
                        waterNeeded = WATER_1;
                        milkNeeded = MILK_1;
                        beansNeeded = BEANS_1;
                        price = PRICE_1;
                        break;
                    case "2":
                        waterNeeded = WATER_2;
                        milkNeeded = MILK_2;
                        beansNeeded = BEANS_2;
                        price = PRICE_2;
                        break;
                    case "3":
                        waterNeeded = WATER_3;
                        milkNeeded = MILK_3;
                        beansNeeded = BEANS_3;
                        price = PRICE_3;
                        break;
                    case "back":
                        System.out.println();
                        continue;
                    default:
                        break;
                }

                notEnough = notEnoughReminder(water, milk, beans, waterNeeded, milkNeeded, beansNeeded);
                System.out.println();

                if (!notEnough) {
                    water -= waterNeeded;
                    milk -= milkNeeded;
                    beans -= beansNeeded;
                    money += price;
                    cups--;
                }

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
                System.out.println();
            }
        }
    }

    public static void display(int water, int milk, int beans, int cups, int money) {
        System.out.println("The coffee machine has:");
        System.out.println(water + " ml of water");
        System.out.println(milk + " ml of milk");
        System.out.println(beans + " g of coffee beans");
        System.out.println(cups + " disposable cups");
        System.out.println("$" + money + " of money");
    }

    public static boolean notEnoughReminder(int water, int milk, int beans, int waterNeeded, int milkNeeded, int beansNeeded) {
        boolean notEnough = false;

        if (water < waterNeeded) {
            System.out.println("Sorry, not enough water!");
            notEnough = true;
        }
        if (milk < milkNeeded) {
            System.out.println("Sorry, not enough milk!");
            notEnough = true;
        }
        if (beans < beansNeeded) {
            System.out.println("Sorry, not enough coffee beans!");
            notEnough = true;
        }

        if (!notEnough) {
            System.out.println("I have enough resources, making you a coffee!");
        }

        return notEnough;
    }

}
