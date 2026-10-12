package com.snake.model;

public class Position {
    private final int x; // final -> posición inmutable
    private final int y; // final -> posición inmutable

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
