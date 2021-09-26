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
            2. There is not enough money left to double the bet again. */

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
                    bet *= 2; /*if there was not enough money left to double, the function would stop
                                here and the remaining balance would be shown.
                                But if this is the case, we will reset the bet to €10
                                in order to achieve all (€1200) or nothing (€0). */
                    if(money <= bet){
                        bet = 10;
                    }
                }
                if (money >= target)
                    break;
            }
            System.out.println(money); //Prints if we achieve €1200 or €0.
            return money;
            }

    public static void main(String[] args) {
	// write your code here
        int amountOfTries = 100000; //How many times do we want the function to run for statistics?
        double numberOfWins = 0; //We will count how many times we achieve our goal of €1200.
        for(int i = 1; i<=amountOfTries; i++) {
            martingale();
            if(martingale()==1200){
                numberOfWins++;//increases numberOfWins each time our goal of €1200 is achieved.
            }
        } //Time to calculate our chances to achieve our goal of € 1200!
        System.out.println("There is a chance of " + numberOfWins/amountOfTries*100 + " % to reach the goal of € 1200.");
    }
}

