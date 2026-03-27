package com.mycompany.mvc.main;

import com.mycompany.mvc.controlador.ProductoControlador;
import com.mycompany.mvc.dao.IProductoDAO;
import com.mycompany.mvc.dao.ProductoDAOImpl;
import com.mycompany.mvc.vista.ProductoVista;

public class Main {
    public static void main(String[] args) {
        // 1. Inicializar la persistencia (DAO)
        IProductoDAO dao = new ProductoDAOImpl();
        
        // 2. Inicializar la interfaz (Vista)
        ProductoVista vista = new ProductoVista();
        
        // 3. Inicializar el cerebro (Controlador)
        ProductoControlador controlador = new ProductoControlador(dao);

        // 4. Ejecutar flujo de prueba
        try {
            String idStr = vista.solicitarDato("Ingrese el ID del producto:");
            String nombre = vista.solicitarDato("Ingrese el nombre:");
            String precioStr = vista.solicitarDato("Ingrese el precio:");

            controlador.agregarProducto(
                Integer.parseInt(idStr), 
                nombre, 
                Double.parseDouble(precioStr)
            );

            vista.mostrarMensaje("¡Proceso MVC completado!\nProductos en sistema: " + controlador.listarProductos().size());
            
        } catch (NumberFormatException e) {
            vista.mostrarError("Error: Ingrese valores numéricos válidos para ID y Precio.");
        }
    }
}