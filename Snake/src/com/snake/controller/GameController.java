package com.snake.controller;

import com.snake.config.GameConfig;
import com.snake.model.Direction;
import com.snake.model.Food;
import com.snake.model.Position;
import com.snake.model.Snake;
import javax.swing.Timer;

public class GameController {
    private final Snake snake;
    private Timer timer;
    private int movements;
    private boolean gameOver;
    private Runnable stateChangeListener;
    private Food food;
    private int score;

    public GameController() {
        snake = new Snake();
        movements = 0;
        gameOver = false;

        food = new Food();
        score = 0;

        food.generateFood(snake.getBodyPositions());
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

        // Comprobar límites del tablero
        boolean wallCollision
                = nextHead.getX() < 0
                || nextHead.getX() >= GameConfig.BOARD_COLUMNS
                || nextHead.getY() < 0
                || nextHead.getY() >= GameConfig.BOARD_ROWS;

        // Comprobar colisión con cuerpo
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

        // Comprobar si la serpiente alcanza la comida
        Position foodPosition = food.getPosition();

        boolean eating = foodPosition != null
                && nextHead.getX() == foodPosition.getX()
                && nextHead.getY() == foodPosition.getY();

        // Mover serpiente; si come, aumenta su longitud
        snake.move(eating);
        movements++;

        // Si come, sumar puntos y generar otra comida
        if (eating) {
            score += 10;

            food.generateFood(snake.getBodyPositions());

            System.out.println("\n¡COMIDA CONSUMIDA!");
            System.out.println("Puntuacion: " + score);
        }

        System.out.println("\n##### MOVIMIENTO " + movements + " #####");

        printState();

        // Actualizar interfaz
        notifyStateChanged();

        // Comprobar si ya no quedan posiciones libres
        if (!food.isAvailable()) {
            finishGame("¡La serpiente ha ocupado todo el tablero!");
        }
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

    public Position getFoodPosition() {
        return food.getPosition();
    }

    public int getScore() {
        return score;
    }

    public int getSnakeLength() {
        return snake.getLength();
    }
}
