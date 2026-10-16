package com.snake.input;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.KeyStroke;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import com.snake.controller.GameController;
import com.snake.model.Direction;

public class KeyboardHandler {

    public static void bind(
            JFrame frame,
            GameController controller) {

        JComponent root = frame.getRootPane();

        bindKey(root, controller, KeyEvent.VK_UP,
                "moveUp", Direction.UP);

        bindKey(root, controller, KeyEvent.VK_DOWN,
                "moveDown", Direction.DOWN);

        bindKey(root, controller, KeyEvent.VK_LEFT,
                "moveLeft", Direction.LEFT);

        bindKey(root, controller, KeyEvent.VK_RIGHT,
                "moveRight", Direction.RIGHT);

        // También permitir usar W, A, S y D
        bindKey(root, controller, KeyEvent.VK_W,
                "moveW", Direction.UP);

        bindKey(root, controller, KeyEvent.VK_S,
                "moveS", Direction.DOWN);

        bindKey(root, controller, KeyEvent.VK_A,
                "moveA", Direction.LEFT);

        bindKey(root, controller, KeyEvent.VK_D,
                "moveD", Direction.RIGHT);
    }

    private static void bindKey(
            JComponent component,
            GameController controller,
            int keyCode,
            String actionName,
            Direction direction) {

        component.getInputMap(
                JComponent.WHEN_IN_FOCUSED_WINDOW
        ).put(
                KeyStroke.getKeyStroke(keyCode, 0),
                actionName
        );

        component.getActionMap().put(
                actionName,
                new AbstractAction() {
                    @Override
                    public void actionPerformed(ActionEvent event) {
                        controller.changeDirection(direction);
                    }
                }
        );
    }
}
