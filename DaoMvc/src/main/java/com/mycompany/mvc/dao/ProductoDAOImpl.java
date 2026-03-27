package com.mycompany.mvc.dao;

import com.mycompany.mvc.modelo.Producto;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementación concreta del DAO. 
 * Aquí es donde realmente se guardan los objetos.
 */
public class ProductoDAOImpl implements IProductoDAO {
    
    // Nuestra "base de datos" temporal
    private final List<Producto> listaProductos;

    public ProductoDAOImpl() {
        this.listaProductos = new ArrayList<>();
    }

    @Override
    public void insertar(Producto p) {
        listaProductos.add(p);
        System.out.println("[DAO] Insertado en memoria: " + p.getNombre());
    }

    @Override
    public List<Producto> consultarTodos() {
        // Devolvemos una copia para proteger la lista original
        return new ArrayList<>(listaProductos);
    }
}