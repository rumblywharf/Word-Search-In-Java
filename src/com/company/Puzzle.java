package com.company;

public class Puzzle {
    public static void main(String[] args) {
        WordSearch game = new WordSearch();
        System.out.println(game.boardToString());
        System.out.println(game.displayWordsInGameboard());
    }
}