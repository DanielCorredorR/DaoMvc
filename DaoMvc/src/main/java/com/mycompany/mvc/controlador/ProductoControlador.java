package com.mycompany.mvc.controlador;

import com.mycompany.mvc.dao.IProductoDAO;
import com.mycompany.mvc.modelo.Producto;
import com.mycompany.mvc.util.FileLogger; // Importamos el logger
import java.util.List;

public class ProductoControlador {
    private final IProductoDAO dao;

    public ProductoControlador(IProductoDAO dao) {
        this.dao = dao;
    }

    public void agregarProducto(int id, String nombre, double precio) {
        try {
            // Validación de negocio
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new IllegalArgumentException("El nombre del producto es obligatorio.");
            }

            Producto p = new Producto(id, nombre, precio);
            dao.insertar(p);
            
            // Log de éxito
            FileLogger.log("INFO", "Producto agregado: " + nombre, null);

        } catch (Exception e) {
            // Log de excepción con el formato de milisegundos
            FileLogger.log("ERROR", "Falló el registro del producto", e);
            throw e; // Relanzamos para que la Vista lo muestre
        }
    }

    public List<Producto> listarProductos() {
        return dao.consultarTodos();
    }
}