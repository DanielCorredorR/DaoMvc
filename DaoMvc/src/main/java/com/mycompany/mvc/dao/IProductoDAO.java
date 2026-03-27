package com.mycompany.mvc.dao;

import com.mycompany.mvc.modelo.Producto;
import java.util.List;

/**
 * Interfaz que define las operaciones permitidas para los productos.
 * Sigue el principio de Abstracción del patrón DAO.
 */
public interface IProductoDAO {
    void insertar(Producto p);
    List<Producto> consultarTodos();
}