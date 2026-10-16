package com.snake.controller;

import com.snake.config.GameConfig;
import com.snake.model.Direction;
import com.snake.model.Position;
import com.snake.model.Snake;
import javax.swing.Timer;

public class GameController {
    private final Snake snake;
    private Timer timer;
    private int movements;
    private boolean gameOver;
    private Runnable stateChangeListener;

    public GameController() {
        snake = new Snake();
        movements = 0;
        gameOver = false;
    }

    public void start() {
        if (timer != null && timer.isRunning()) {
            return;
        }

        if (gameOver) {
            return;
        }

        System.out.println("##### SNAKE #####");
        System.out.println("Iniciando Juego...");
        System.out.println("Direccion: " + snake.getDirection());
        printState();

        timer = new Timer(
                GameConfig.TICK_DELAY,
                event -> updateGame()
        );

        timer.start();
    }

    private void updateGame() {
        if (gameOver) {
            return;
        }

        Position nextHead = snake.getNextHeadPosition();

        // Comprobar los límites del tablero
        boolean wallCollision
                = nextHead.getX() < 0
                || nextHead.getX() >= GameConfig.BOARD_COLUMNS
                || nextHead.getY() < 0
                || nextHead.getY() >= GameConfig.BOARD_ROWS;

        // Comprobar colisión con el cuerpo
        boolean bodyCollision
                = snake.willCollideWithBody(nextHead);

        if (wallCollision || bodyCollision) {
            finishGame(
                    wallCollision
                            ? "La serpiente chocó con una pared."
                            : "La serpiente chocó con su cuerpo."
            );
            return;
        }

        snake.move();
        movements++;
        notifyStateChanged();

        System.out.println("\n##### MOVIMIENTO " + movements + " #####");

        printState();
    }

    private void printState() {
        System.out.println("Direccion: " + snake.getDirection());
        System.out.println("Cabeza: " + snake.getHead());
        snake.printBody();
        System.out.println("Longitud: " + snake.getLength());
    }

    private void finishGame(String reason) {
        gameOver = true;

        if (timer != null) {
            timer.stop();
        }

        System.out.println("\n##### GAME OVER #####");
        System.out.println(reason);
        System.out.println("Movimientos realizados: " + movements);
        System.out.println("Longitud final: " + snake.getLength());
        
        notifyStateChanged();
    }

    public void changeDirection(Direction direction) {
        if (gameOver || direction == null) {
            return;
        }

        snake.changeDirection(direction);
    }

    public void stop() {
        if (timer != null) {
            timer.stop();
        }
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void setStateChangeListener(Runnable listener) {
        this.stateChangeListener = listener;
    }

    public void notifyStateChanged() {
        if (stateChangeListener != null) {
            stateChangeListener.run();
        }
    }

    public java.util.List<com.snake.model.Position>
            getSnakePositions() {
        return snake.getBodyPositions();
    }
}
