package com.mycompany.mvc.vista;

import javax.swing.JOptionPane;

/**
 * Vista: Se encarga exclusivamente de la interacción con el usuario.
 */
public class ProductoVista {

    public String solicitarDato(String mensaje) {
        return JOptionPane.showInputDialog(mensaje);
    }

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }

    public void mostrarError(String error) {
        JOptionPane.showMessageDialog(null, error, "Error de Sistema", JOptionPane.ERROR_MESSAGE);
    }
}