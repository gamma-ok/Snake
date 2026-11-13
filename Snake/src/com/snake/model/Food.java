package com.snake.model;

import com.snake.config.GameConfig;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Food {
    private Position position;
    private final Random random;

    public Food() {
        random = new Random();
    }

    public void generateFood(List<Position> snakePositions) {

        List<Position> availablePositions = new ArrayList<>();

        // Buscar celdas que no ocupe la serpiente
        for (int x = 0; x < GameConfig.BOARD_COLUMNS; x++) {
            for (int y = 0; y < GameConfig.BOARD_ROWS; y++) {
                boolean occupied = false;

                for (Position segment : snakePositions) {
                    if (segment.getX() == x && segment.getY() == y) {
                        occupied = true;
                        break;
                    }
                }

                // Guardar solo posiciones libres
                if (!occupied) {
                    availablePositions.add(new Position(x, y));
                }
            }
        }

        // Si no quedan posiciones libres
        if (availablePositions.isEmpty()) {
            position = null;
            return;
        }

        // Seleccionar posición aleatoria libre
        int index = random.nextInt(availablePositions.size());
        position = availablePositions.get(index);
    }

    public Position getPosition() {
        return position;
    }

    public boolean isAvailable() {
        return position != null;
    }
}
