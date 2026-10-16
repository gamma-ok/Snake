package com.snake.view;

import com.snake.config.GameConfig;
import com.snake.controller.GameController;
import com.snake.model.Position;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.List;
import javax.swing.JPanel;

public class GamePanel extends JPanel {

    private final GameController controller;

    private static final Color BACKGROUND_COLOR =
            new Color(18, 28, 22);

    private static final Color BOARD_COLOR =
            new Color(30, 45, 34);

    private static final Color GRID_COLOR =
            new Color(43, 61, 46);

    private static final Color SNAKE_HEAD_COLOR =
            new Color(190, 245, 145);

    private static final Color SNAKE_BODY_COLOR =
            new Color(91, 196, 101);

    public GamePanel(GameController controller) {
        this.controller = controller;

        setBackground(BACKGROUND_COLOR);
        setOpaque(true);

        setPreferredSize(new Dimension(
                GameConfig.BOARD_COLUMNS * GameConfig.CELL_SIZE,
                GameConfig.BOARD_ROWS * GameConfig.CELL_SIZE
        ));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g.create();

        try {
            g2.setRenderingHint(
                    RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON
            );

            int cellSize = GameConfig.CELL_SIZE;

            int boardWidth =
                    GameConfig.BOARD_COLUMNS * cellSize;

            int boardHeight =
                    GameConfig.BOARD_ROWS * cellSize;

            // Centrar el tablero dentro del panel
            int offsetX = (getWidth() - boardWidth) / 2;
            int offsetY = (getHeight() - boardHeight) / 2;

            // Fondo del tablero
            g2.setColor(BOARD_COLOR);

            g2.fillRect(
                    offsetX,
                    offsetY,
                    boardWidth,
                    boardHeight
            );

            // Dibujar las líneas de la cuadrícula
            g2.setColor(GRID_COLOR);

            for (int col = 0;
                    col <= GameConfig.BOARD_COLUMNS;
                    col++) {

                int x = offsetX + col * cellSize;

                g2.drawLine(
                        x,
                        offsetY,
                        x,
                        offsetY + boardHeight
                );
            }

            for (int row = 0;
                    row <= GameConfig.BOARD_ROWS;
                    row++) {

                int y = offsetY + row * cellSize;

                g2.drawLine(
                        offsetX,
                        y,
                        offsetX + boardWidth,
                        y
                );
            }

            // Obtener una copia de las posiciones
            List<Position> positions =
                    controller.getSnakePositions();

            // Dibujar la serpiente
            for (int i = positions.size() - 1;
                    i >= 0;
                    i--) {

                Position position = positions.get(i);

                int x = offsetX
                        + position.getX() * cellSize;

                int y = offsetY
                        + position.getY() * cellSize;

                // La cabeza tiene un color distinto
                if (i == 0) {
                    g2.setColor(SNAKE_HEAD_COLOR);
                } else {
                    g2.setColor(SNAKE_BODY_COLOR);
                }

                g2.fillRoundRect(
                        x + 2,
                        y + 2,
                        cellSize - 4,
                        cellSize - 4,
                        7,
                        7
                );

                // Ojos de la cabeza
                if (i == 0) {
                    g2.setColor(new Color(25, 48, 30));

                    g2.fillOval(
                            x + cellSize / 3,
                            y + cellSize / 4,
                            4,
                            4
                    );

                    g2.fillOval(
                            x + (2 * cellSize) / 3 - 2,
                            y + cellSize / 4,
                            4,
                            4
                    );
                }
            }

        } finally {
            g2.dispose();
        }
    }
}
