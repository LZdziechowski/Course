package com.kodilla.patterns.builder.checkers;

public class Checkers {

    private final Board board;
    private final String playerOne;
    private final String playerTwo;

    public Checkers(Board board, String playerOne, String playerTwo) {
        this.board = board;
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    public Board getBoard() {
        return board;
    }

    public String getPlayerOne() {
        return playerOne;
    }

    public String getPlayerTwo() {
        return playerTwo;
    }

    public static class CheckerBuilder() {

        private Board board = new Board();
        private String playerOne = "";
        private String playerTwo =  "";

        public CheckerBuilder playerOne() {

        }

    }
}
