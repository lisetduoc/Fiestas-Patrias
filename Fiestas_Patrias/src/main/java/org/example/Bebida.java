package org.example;

public abstract class Bebida {
    private String nombre;
    private int volumenML;
    private int stock;

    public Bebida(String nombre, int volumenML, int stock) {
        setNombre(nombre);
        setVolumenML(volumenML);
        setStock(stock);
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        if (nombre == null) {
            throw new IllegalArgumentException("El nombre no puede ser vacio");
        }
        if (nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede ser vacio");
        }
        this.nombre = nombre;
    }
    public int getVolumenML() {
        return volumenML;
    }
    public void setVolumenML(int volumenML) {
        if (volumenML < 100) {
            throw new IllegalArgumentException("El volumen debe ser mayor o igual a 100ml");
        }
        if (volumenML > 3000) {
            throw new IllegalArgumentException("El volumen debe ser menor o igual a 3000ml");
        }
        this.volumenML = volumenML;
    }
    public int getStock() {
        return stock;
    }
    public void setStock(int stock) {
        if (stock <= 0) {
            throw new IllegalArgumentException("El stock debe ser mayor que 0");
        }
        this.stock = stock;
    }
    public abstract double calcularPrecio();
    public abstract String obtenerDetalle();

    @Override
    public String toString() {
        return "Nombre: " + nombre + "Volumen: " + volumenML + "ml";
    }
}
