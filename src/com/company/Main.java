package com.company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        getNum();
    }
    private static void getNum(){
        int rows = 0;
        int columns = 0;
        Scanner keyboard = new Scanner(System.in);
        do {
            System.out.printf("%nEnter a number of rows (2-15): ");
            rows = keyboard.nextInt();
            if (rows > 15 || rows < 2) {
                System.out.println("Your number is not valid. Enter a valid number");
            }
        }while(rows < 2|| rows > 15);
        do{
            System.out.printf("%nEnter a number of columns (2-15): ");
            columns = keyboard.nextInt();
            if (columns < 2|| columns > 15 ) {
                System.out.println("Your number is not valid. Enter a valid number");
            }
            }while(columns < 2|| columns > 15);
    }
}
