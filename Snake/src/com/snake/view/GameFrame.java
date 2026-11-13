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

        // Mostrar valores iniciales
        lblScore.setText("Puntuación: " + controller.getScore());
        lblLength.setText("Longitud: " + controller.getSnakeLength());

        // Actualizar la interfaz cuando cambie el juego
        controller.setStateChangeListener(() -> {
            lblScore.setText("Puntuación: " + controller.getScore());
            lblLength.setText("Longitud: " + controller.getSnakeLength());

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

        pnlDashboard = new javax.swing.JPanel();
        lblScore = new javax.swing.JLabel();
        lblLength = new javax.swing.JLabel();
        pnlGameBoard = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(20, 24, 33));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlDashboard.setBackground(new java.awt.Color(20, 24, 33));

        lblScore.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblScore.setForeground(new java.awt.Color(255, 255, 255));
        lblScore.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblScore.setText("Puntuación: 0");
        lblScore.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lblLength.setBackground(new java.awt.Color(20, 24, 33));
        lblLength.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblLength.setForeground(new java.awt.Color(255, 255, 255));
        lblLength.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLength.setText("Longitud: 3");
        lblLength.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout pnlDashboardLayout = new javax.swing.GroupLayout(pnlDashboard);
        pnlDashboard.setLayout(pnlDashboardLayout);
        pnlDashboardLayout.setHorizontalGroup(
            pnlDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDashboardLayout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(lblScore, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblLength, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(64, Short.MAX_VALUE))
        );
        pnlDashboardLayout.setVerticalGroup(
            pnlDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(lblScore, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(lblLength, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(pnlDashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 40));

        pnlGameBoard.setBackground(new java.awt.Color(20, 24, 33));

        javax.swing.GroupLayout pnlGameBoardLayout = new javax.swing.GroupLayout(pnlGameBoard);
        pnlGameBoard.setLayout(pnlGameBoardLayout);
        pnlGameBoardLayout.setHorizontalGroup(
            pnlGameBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlGameBoardLayout.setVerticalGroup(
            pnlGameBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 660, Short.MAX_VALUE)
        );

        getContentPane().add(pnlGameBoard, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 640, 660));

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
    private javax.swing.JLabel lblLength;
    private javax.swing.JLabel lblScore;
    private javax.swing.JPanel pnlDashboard;
    private javax.swing.JPanel pnlGameBoard;
    // End of variables declaration//GEN-END:variables
}
