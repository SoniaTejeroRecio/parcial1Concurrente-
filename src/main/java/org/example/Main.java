package org.example;

public class Main {
    public static void main(String[] args) {
        BufferCompartido buffer = new BufferCompartido(10);

        // Creación de productores para diferentes componentes
        Productor productor1 = new Productor(buffer, "Clavo");
        Productor productor2 = new Productor(buffer, "Bola");

        // Creación de consumidor (línea de ensamblaje)
        Consumidor ensamblador = new Consumidor(buffer);

        // Inicio de los hilos
        productor1.start();
        productor2.start();
        ensamblador.start();
    }
}
