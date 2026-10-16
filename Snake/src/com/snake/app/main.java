package com.snake.app;

import com.snake.controller.GameController;
import com.snake.view.GameFrame;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {

            GameController controller = new GameController();

            GameFrame frame = new GameFrame();
            frame.setController(controller);
            frame.setVisible(true);

            controller.start();
        });
    }
}
