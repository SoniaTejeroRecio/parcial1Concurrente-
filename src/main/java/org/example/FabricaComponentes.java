package org.example;

import org.example.Componentes.Bola;
import org.example.Componentes.Clavo;
import org.example.Componentes.Componente;

//Clase que implementará el patrón factory para producir diferentes tipos de componentes
public class FabricaComponentes {
    public static Componente crearComponente(String tipo) {
        switch (tipo) {
            case "Clavo":
                return new Clavo();
            case "Bola":
                return new Bola();
            default:
                throw new IllegalArgumentException("Componente no reconocido: " + tipo);
        }
    }
}
