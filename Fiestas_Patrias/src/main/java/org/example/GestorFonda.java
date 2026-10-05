package org.example;

import java.util.ArrayList;
import java.util.List;
public class GestorFonda {
    private List<Bebida> bebidas;
    public GestorFonda(){
        bebidas = new ArrayList<>();
    }
    public void registrar(Bebida bebida){
        bebidas.add(bebida);
        System.out.println(bebida.getNombre() + " Registrada correctamente");

    }
    public List<Bebida> buscarPorNombre(String nombre) {
        List<Bebida> resultados = new ArrayList<>();
        for (Bebida bebida : bebidas) {
            if (bebida.getNombre().equalsIgnoreCase(nombre)) {
                resultados.add(bebida);
            }
        }
        return resultados;
    }
    public void vender(String nombre, int unidades){
        List<Bebida> resultados = buscarPorNombre(nombre);
        if (resultados.isEmpty()){
            System.out.println("No se encontro la bebida ");
            return;
        }
        Bebida bebida = resultados.get(0);
        if (bebida instanceof ConsumoResponsable){
            ConsumoResponsable consumo = (ConsumoResponsable) bebida;
            if (consumo.tieneVentaRestringida()){
                System.out.println("Venta rechazada: " + nombre + " tiene la venta restringida");
                return;
            }
            if (consumo.superaLimite(unidades)){
                System.out.println("Venta rechazada: " + "Supera el limite de 3 unidades por cliente");
                return;
            }
        }
        if (unidades > bebida.getStock()){
            System.out.println("No hay suficiente stock");
            return;
        }
        double total = bebida.calcularPrecio()* unidades;
        int nuevoStock = bebida.getStock() - unidades;
        if (nuevoStock > 0){
            bebida.setStock(nuevoStock);
        }
        System.out.println("Venta autorizada: " + unidades + "x" + nombre + "Total: $" + (int)total);
    }
    public List<Bebida> obtenerTodas(){
        return bebidas;
    }
}
