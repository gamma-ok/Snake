package main.java.com.snake.view;

import java.awt.Image;
import java.awt.Toolkit;
import java.net.URI;
import javax.swing.JOptionPane;

public class MenuPrincipal extends javax.swing.JFrame {
    public MenuPrincipal() {
        initComponents();
        setResizable(false);

        //Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("../recursos/iconBibliotecaFrm.png")); //icono del frm
        //this.setIconImage(icon);

        this.setLocationRelativeTo(null);
    }

    public void transparenciaButton() {
        btnGestionProveedores.setOpaque(false);
        btnGestionProveedores.setContentAreaFilled(false);
        btnGestionProveedores.setBorderPainted(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tituloForm = new javax.swing.JLabel();
        info = new javax.swing.JLabel();
        btnGestionProveedores = new javax.swing.JButton();
        bgBtnGestionProveedores = new javax.swing.JLabel();
        copyright = new javax.swing.JLabel();
        bg1 = new javax.swing.JLabel();
        bg2 = new javax.swing.JLabel();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menú Principal | By gamma");
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setName("frmMenuPrincipal"); // NOI18N
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tituloForm.setFont(new java.awt.Font("Trebuchet MS", 1, 28)); // NOI18N
        tituloForm.setForeground(new java.awt.Color(255, 140, 5));
        tituloForm.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tituloForm.setText("Menú Principal");
        getContentPane().add(tituloForm, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 420, 60));

        info.setBackground(new java.awt.Color(255, 255, 255));
        info.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        info.setForeground(new java.awt.Color(255, 255, 255));
        info.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        info.setText("<html><center>Centraliza la administración de funciones<p>clave para optimizar operaciones.<center><html>");
        getContentPane().add(info, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 420, 80));

        btnGestionProveedores.setBackground(new java.awt.Color(255, 140, 5));
        btnGestionProveedores.setFont(new java.awt.Font("Trebuchet MS", 1, 20)); // NOI18N
        btnGestionProveedores.setForeground(new java.awt.Color(255, 255, 255));
        btnGestionProveedores.setText(" Gestión de Proveedores");
        btnGestionProveedores.setBorder(null);
        btnGestionProveedores.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGestionProveedores.setFocusPainted(false);
        btnGestionProveedores.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnGestionProveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGestionProveedoresActionPerformed(evt);
            }
        });
        getContentPane().add(btnGestionProveedores, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 270, 280, 50));

        bgBtnGestionProveedores.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bgBtnGestionProveedores.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(bgBtnGestionProveedores, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, 420, 70));

        copyright.setFont(new java.awt.Font("Trebuchet MS", 3, 14)); // NOI18N
        copyright.setForeground(new java.awt.Color(255, 255, 255));
        copyright.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        copyright.setText("Copyright © 2026 | Developed by gamma");
        copyright.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        copyright.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                copyrightMousePressed(evt);
            }
        });
        getContentPane().add(copyright, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 530, -1, 20));

        bg1.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(bg1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 420, 60));

        bg2.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(bg2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 420, 80));
        getContentPane().add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -10, 560, 570));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void copyrightMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_copyrightMousePressed
        abrirURL("https://github.com/gamma-ok/BibliotecaUTP");
    }//GEN-LAST:event_copyrightMousePressed

    private void btnGestionProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGestionProveedoresActionPerformed
//        // Instanciar el modelo, el DAO a la vista
//        // Datos vacíos iniciales para el cliente
//        Proveedor modelo = new Proveedor(0, "", "", "", "", "", "");
//        ProveedorDAO dao = new ProveedorDAO();
//        frmGestionProveedores vista = new frmGestionProveedores();
//
//        // Instanciar el controlador
//        ProveedorController ctrl = new ProveedorController(modelo, dao, vista);
//
//        // Mostrar frm
//        vista.setVisible(true);
//        vista.setLocationRelativeTo(null); // Centrar frm
//        this.dispose(); // Cerrar vista actual
    }//GEN-LAST:event_btnGestionProveedoresActionPerformed

    private void abrirURL(String url) {
        try {
            java.awt.Desktop.getDesktop().browse(new URI(url));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo abrir la URL: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new MenuPrincipal().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bg;
    private javax.swing.JLabel bg1;
    private javax.swing.JLabel bg2;
    private javax.swing.JLabel bgBtnGestionProveedores;
    private javax.swing.JButton btnGestionProveedores;
    private javax.swing.JLabel copyright;
    private javax.swing.JLabel info;
    private javax.swing.JLabel tituloForm;
    // End of variables declaration//GEN-END:variables
}
