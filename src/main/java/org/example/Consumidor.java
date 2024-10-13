package org.example;

import org.example.Componentes.Componente;

public class Consumidor extends Thread {
    private BufferCompartido buffer;

    public Consumidor(BufferCompartido buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Componente componente = buffer.consumir();
                componente.ensamblar(); //Llama al método ensamblar del componente
                Thread.sleep(1500); //Simula el tiempo de ensamblaje
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
