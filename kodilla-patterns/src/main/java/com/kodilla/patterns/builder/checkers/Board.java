package com.kodilla.patterns.builder.checkers;

import java.util.Arrays;

public class Board {

    public final static int MAX_INDEX = 9;
    public final static int MIN_INDEX = 0;
    private final Figure[][] board = new Figure[10][];

    public Board() {
        for (int i = 0; i < 10; i++) {
            board[i] = new Figure[10];
        }
    }

    public Figure getFigure(int x, int y) {
        return board[x][y];
    }

    public void setFigure(Figure figure, int x, int y) {
        board[x][y] = figure;
    }

    @Override
    public String toString() {
        String result = "";
        for (int i = MIN_INDEX; i <= MAX_INDEX; i++) {
            result += "|";
            for (int n = MIN_INDEX; n <= MAX_INDEX; n++) {
                if (board[i][n] == null) {
                    result += "  ";
                } else {
                    result += (board[i][n].getColor().equals(Figure.BLACK) ? "b" : "w");
                    result += (board[i][n] instanceof Pawn ? "P" : "Q");
                }
                result += "|";
            }
            result += "\n";
        }
        return result;
    }
}
