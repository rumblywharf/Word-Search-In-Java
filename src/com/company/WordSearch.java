package com.company;

import java.security.SecureRandom;
import java.util.Random;
import java.util.Scanner;

public class WordSearch {
    private int columns = 0;
    private int rows = 0;
    private Scanner keyboard = new Scanner(System.in);
    private char[][] gameboard;
    private String[] words;
    //runs every method given
    public WordSearch() {
        gameboard = new char[getColumns()][getRows()];
        getwords();
        fillBoard();
        displayWordsInGameboard();
    }
    //input columns and validates them
    public int getColumns() {
        do {
            System.out.printf("%nEnter a number of columns (2-15): ");
            columns = keyboard.nextInt();
            if (columns > 15 || columns < 2) {
                System.out.println("Your number is not valid. Enter a valid number");
            }
        } while (columns < 2 || columns > 15);
        return columns;
    }
    //input rows and validates them
    public int getRows() {
        do {
            System.out.printf("%nEnter a number of rows (2-15): ");
            rows = keyboard.nextInt();
            if (rows < 2 || rows > 15) {
                System.out.println("Your number is not valid. Enter a valid number");
            }
        } while (rows < 2 || rows > 15);
        return rows;
    }
    //fill the board with random letters
    public char[][] fillBoard() {
        Random random = new Random();
        char letter;
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for (int row = 0; row < columns; row++) {
            for (int col = 0; col < rows; col++) {
                letter = alphabet.charAt(random.nextInt(alphabet.length()));
                gameboard[row][col] = letter;
            }
        }
        return gameboard;
    }
    //asks the user for words to enter and validates them
    public String[] getwords() {
        words = new String[rows];
        for (int i = 0; rows > i; i++) {
            do {
                System.out.printf("Enter a word with %d letters or less: ", columns);
                Scanner wordsToString = new Scanner(System.in);
                words[i] = wordsToString.nextLine().trim().toUpperCase();
                if (2 > words[i].length())
                    System.out.printf("Your word is too short. Your word must be at least 2 letters long.%n");
                if (columns < words[i].length())
                    System.out.printf("Your word is too long. Your word must have a max of %d letters.%n", columns);
                if (words[i].contains(" "))
                    System.out.printf("Your word cannot contain spaces.%n");
            } while (columns < words[i].length() || words[i].length() < 2 || words[i].contains(" "));
        }
        return words;
    }
    //converts the gameboard into a string
    public String boardToString() {

        String wordinString = "";

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                wordinString += gameboard[col][row] + "    ";
            }
            wordinString += "\n";
        }
        return wordinString;
    }
    //places the words into the gameboard and prints the word list
    public String displayWordsInGameboard() {
        SecureRandom rng = new SecureRandom();
        int num;
        String printwords = "";
        for (int x = 0; x < rows; x++) {
            num = rng.nextInt(columns - words[x].length() + 1);
            for (int y = 0; y < columns; y++) {
                if (y < (words[x].length() + num) && y >= num)
                    gameboard[y][x] = words[x].charAt(y - num);
            }
        }
        System.out.println("The words to find:");
        for (int x = 0; rows > x; x++) {
            printwords += words[x] + "\n";
        }
        return printwords;
    }
}