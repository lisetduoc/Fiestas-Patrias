package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        GestorFonda gestor = new GestorFonda();
        BebidaAlcoholica chicha = new BebidaAlcoholica("Chicha", 1000,40,12,false);
        BebidaAlcoholica piscoSour = new BebidaAlcoholica("Pisco Sour", 500,25,18,true);
        BebidaSinAlcohol chichaSinAlcohol = new BebidaSinAlcohol("Chicha", 1000,60,95);
        BebidaSinAlcohol moteConHuesillo = new BebidaSinAlcohol("Mote Con Huesillo", 400,50,70);

        gestor.registrar(chicha);
        gestor.registrar(piscoSour);
        gestor.registrar(chichaSinAlcohol);
        gestor.registrar(moteConHuesillo);
        System.out.println();
        System.out.println("----BUSQUEDA POR NOMBRE----");
        List<Bebida>resultado = gestor.buscarPorNombre("Chicha");
        for (Bebida bebida : resultado) {
            System.out.println(bebida.obtenerDetalle());
        }
        System.out.println();
        System.out.println("----DETALLE DE LAS BEBIDAS----");
        for (Bebida bebida: gestor.obtenerTodas()){
            System.out.println(bebida.obtenerDetalle());
        }
        System.out.println();
        System.out.println("----VENTAS----");
        gestor.vender("Pisco Sour",  2);
        gestor.vender("Pisco Sour",5);
        chicha.restringirVenta();
        gestor.vender("Chicha", 1);
        gestor.vender("Mote Con Huesillo",  6);
    }
}