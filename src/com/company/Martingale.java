package com.company;

import java.util.Scanner;

public class Martingale {

    // The function play() will randomly give a result of 1 (true/win) or 0 (false/lose).
    public static boolean play() {
        int random = (int) ((Math.random()*2));
        boolean winOrLose = true;
        if (random == 0) {
            winOrLose = false;
        } return winOrLose;
    }

    public static int martingale() {
        /*  Initial money is €1000 and target is € 1200.
            The initial bet is € 10.
            With every lost play, the bet will be doubled.
            With every won play, the bet resets at € 10.
            The function will stop if:
            1. The goal of € 1200 is reached.
            2. There is not enough money left to bet again. */

        int money = 1000;
        int target = 1200;
        int bet = 10;
            while (money >= bet) {
                boolean win = play();
                //50% chance for a "win" on each play.
                if (win) {
                    money += bet;
                    bet = 10;
                } else {
                    //50% chance for a "loss" on each play.
                    money -= bet;
                    bet *= 2;

                    if(money <= bet){
                        bet = 10;
                    }
                }
                if (money >= target)
                    break;
            }
            System.out.println(money); //Prints if we achieve all or nothing.
            return money;
            }

    public static void main(String[] args) {

        System.out.println("\nLet's calculate the odds to win money by playing a coin flipping betting game using the Martingale betting system. " +
                "\nThe initial balance is 1000, the initial betting amount is 10 and the desired stopping amount is 1200." +
                "\n" +
                "\nThe rules are simple:" +
                "\nIf you guess correct (heads or tails), you win the bet and start over with the initial betting amount." +
                "\nIf you guess wrong, you will double the bet each time until you have won." +
                "\nIf you do not have enough money left to double the bet, the betting amount will be reset to 10." +
                "\nThe game ends when the desired amount of 1200 is obtained, or if you have lost all your money.");
        Scanner scanner = new Scanner(System.in);  // Create a Scanner object
        System.out.println("How many times would you like the program to run for statistics? I suggest a minimum of 10000 times.");
        int amountOfTries = scanner.nextInt();  // Read user input

        double numberOfWins = 0; //Count how many times we achieve our goal of €1200.
        for(int i = 1; i<=amountOfTries; i++) {
            martingale();
            if(martingale() == 1200){
                numberOfWins++;//increases numberOfWins each time our goal of €1200 is achieved.
            }
        } //Calculate our chances to achieve all or nothing!
        System.out.println("There is a chance of " + numberOfWins/amountOfTries*100 + " % to reach the goal of € 1200.");
    }
}

