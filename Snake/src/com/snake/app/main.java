package com.snake.app;

import com.snake.controller.GameController;
import com.snake.model.Direction;

public class Main {
    public static void main(String[] args) {

        GameController game = new GameController();

        game.showInitialState();

        // Movimiento 1: Derecha
        game.moveSnake();

        // Movimiento 2: Derecha
        game.moveSnake();

        // Cambiar direccion hacia abajo
        game.changeDirection(Direction.DOWN);

        // Movimiento 3: Abajo
        game.moveSnake();

        // Movimiento 4: Abajo
        game.moveSnake();

        // Cambiar direccion hacia izquierda
        game.changeDirection(Direction.LEFT);

        // Movimiento 5: Izquierda
        game.moveSnake();
    }
}
