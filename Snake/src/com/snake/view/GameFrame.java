package com.snake.view;

import com.snake.controller.GameController;
import com.snake.input.KeyboardHandler;
import java.awt.BorderLayout;

public class GameFrame extends javax.swing.JFrame {
    private GameController controller;
    private GamePanel gamePanel;

    public GameFrame() {
        initComponents();

        setTitle("Snake | By gamma-ok");
        setSize(640, 700);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    public void setController(GameController controller) {
        this.controller = controller;

        // Crear panel para el tablero
        gamePanel = new GamePanel(controller);

        // El panel personalizado ocupará todo el contenedor
        pnlGameBoard.setLayout(new BorderLayout());
        pnlGameBoard.add(gamePanel, BorderLayout.CENTER);

        // Conectar los controles del teclado
        KeyboardHandler.bind(this, controller);

        // Redibujar cuando cambie el estado del juego
        controller.setStateChangeListener(() -> {
            if (gamePanel != null) {
                gamePanel.repaint();
            }
        });

        pnlGameBoard.revalidate();
        pnlGameBoard.repaint();
    }

    @Override
    public void dispose() {
        if (controller != null) {
            controller.stop();
        }

        super.dispose();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlGameBoard = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout pnlGameBoardLayout = new javax.swing.GroupLayout(pnlGameBoard);
        pnlGameBoard.setLayout(pnlGameBoardLayout);
        pnlGameBoardLayout.setHorizontalGroup(
            pnlGameBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 640, Short.MAX_VALUE)
        );
        pnlGameBoardLayout.setVerticalGroup(
            pnlGameBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlGameBoard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlGameBoard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            GameController game = new GameController();

            GameFrame frame = new GameFrame();
            frame.setController(game);
            frame.setVisible(true);

            game.start();
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel pnlGameBoard;
    // End of variables declaration//GEN-END:variables
}
