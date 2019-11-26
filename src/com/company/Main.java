package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {
    private static int rows = 0;
    private static int columns = 0;
    private static Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) {
        getNum();
        getwords();
        fillBoard();
    }
    private static void getNum(){
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
    private static void fillBoard(){
        Random random = new Random();
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        char [][] gameboard = new char [rows][columns];
        for(int i = 0; i < rows; i++) {
            for(int x = 0; x < columns; x++) {
                char letter = alphabet.charAt(random.nextInt(alphabet.length()));
                gameboard[i][x] = (letter);
                System.out.printf("%c   ",gameboard[i][x]);
            }
            System.out.printf("%n");
        }
    }
    private static void getwords() {
        String words;
        int wordLength = rows;
        for (int z = 0; columns > z; z++) {
            do {
                System.out.printf("Enter a word with %d letters or less: ", wordLength - 1);
                Scanner wordsToString = new Scanner(System.in);
                words = wordsToString.nextLine();
                if (1 >= words.length())
                    System.out.printf("Your word is too short. Your word must be at least 2 letters long.%n");
                if ((wordLength - 1) < words.length())
                    System.out.printf("Your word is too long. Your word must have a max of %d letters.%n", wordLength);
                words = words.trim();
                if (words.contains(" "))
                    System.out.printf("Your word cannot contain spaces.%n");
            } while ((wordLength - 1) < words.length() || words.length() <= 1 || words.contains(" "));
        }
    }
}
