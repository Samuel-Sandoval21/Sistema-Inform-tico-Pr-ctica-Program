/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.appsistemainformatico;

import javax.swing.SwingUtilities;

/**
 *
 * @author HP
 */
public class AppSistemaInformatico {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new VentanaPrincipal().setVisible(true);
        });
    }
}
