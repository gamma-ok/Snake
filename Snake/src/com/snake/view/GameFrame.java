package com.snake.view;

import com.snake.controller.GameController;
import com.snake.input.KeyboardHandler;

public class GameFrame extends javax.swing.JFrame {

    private GameController controller;
    
    public GameFrame() {
        initComponents();

        setTitle("Snake Game");
        setSize(640, 700);
        setLocationRelativeTo(null);
        setResizable(false);
    }
    
    public void setController(GameController controller) {
        this.controller = controller;

        KeyboardHandler.bind(this, controller);
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 640, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
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
    // End of variables declaration//GEN-END:variables
}
