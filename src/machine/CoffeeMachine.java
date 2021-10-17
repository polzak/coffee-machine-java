package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {

        final int WATER = 200;
        final int MILK = 50;
        final int BEANS = 15;

        final Scanner scanner = new Scanner(System.in);

        System.out.println("Write how many ml of water the coffee machine has:");
        int waterAmount = scanner.nextInt();
        System.out.println("Write how many ml of milk the coffee machine has:");
        int milkAmount = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        int beansAmount = scanner.nextInt();
        System.out.println("Write how many cups of coffee you will need:");
        int cupsNeeded = scanner.nextInt();

        int waterAble = waterAmount / WATER;
        int milkAble = milkAmount / MILK;
        int beansAble = beansAmount / BEANS;

        int able = 0;

        if (waterAble > milkAble) {
            able = milkAble;
            if (able > beansAble) {
                able = beansAble;
            }
        } else {
            able = waterAble;
            if (able > beansAble) {
                able = beansAble;
            }
        }

        if (cupsNeeded == able) {
            System.out.println("Yes, I can make that amount of coffee\n");
        } else if (cupsNeeded < able) {
            System.out.println("Yes, I can make that amount of coffee (and even " + (able - cupsNeeded) + " more than that)");
        } else {
            System.out.println("No, I can make only " + able + " cup(s) of coffee\n");
        }
    }
}
