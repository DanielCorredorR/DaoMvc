package com.mycompany.mvc.controlador;

import com.mycompany.mvc.dao.IProductoDAO;
import com.mycompany.mvc.modelo.Producto;
import java.util.List;

/**
 * Controlador: Orquesta la comunicación entre la Vista y el DAO.
 */
public class ProductoControlador {
    private final IProductoDAO dao;

    public ProductoControlador(IProductoDAO dao) {
        this.dao = dao;
    }

    public void agregarProducto(int id, String nombre, double precio) {
        // Aquí podrías validar: ej. que el precio no sea negativo
        Producto p = new Producto(id, nombre, precio);
        dao.insertar(p);
    }

    public List<Producto> listarProductos() {
        return dao.consultarTodos();
    }
}