package com.snake.controller;

import com.snake.model.Direction;
import com.snake.model.Snake;

public class GameController {

    private final Snake snake;
    private int movements;

    public GameController() {
        snake = new Snake();
        movements = 0;
    }

    public void moveSnake() {
        snake.move();
        movements++;

        System.out.println(
            "\n=== MOVIMIENTO " + movements + " ==="
        );

        System.out.println(
            "Direccion: " + snake.getDirection()
        );

        System.out.println(
            "Cabeza: " + snake.getHead()
        );

        snake.printBody();

        System.out.println(
            "Longitud: " + snake.getLength()
        );
    }

    public void changeDirection(Direction direction) {
        snake.changeDirection(direction);
    }

    public void showInitialState() {
        System.out.println("=== SNAKE GAME ===");
        System.out.println("Estado inicial:");
        snake.printBody();
    }
}
