package com.mycompany.mvc.modelo;

/**
 * Representa la entidad Producto en el sistema.
 * Es la base de la capa MODELO.
 */
public class Producto {
    private int id;
    private String nombre;
    private double precio;

    public Producto(int id, String nombre, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
    }

    // Getters
    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }

    @Override
    public String toString() {
        return "Producto[ID=" + id + ", Nombre=" + nombre + ", Precio=" + precio + "]";
    }
}