# parcial1Concurrente-

Link al repositorio: https://github.com/SoniaTejeroRecio/parcial1Concurrente-.git


# Simulación de la Máquina de Galton en la Fábrica de Campanas de Gauss

Proyecto de Sonia Tejero y Sira González-Madroño

## Descripción

Este proyecto simula el funcionamiento de una fábrica que produce máquinas basadas en el tablero de Galton, un dispositivo que demuestra la distribución normal. La simulación utiliza hilos para modelar la concurrencia en la producción de componentes y su posterior ensamblaje en la línea de producción. La visualización de la distribución de bolas en los contenedores inferiores se realiza utilizando JavaFX.

## Estructura del Proyecto

### Clases Principales

1. **Main**:

   - Punto de entrada de la aplicación.
   - Crea el buffer compartido y los hilos para los productores y el consumidor.
   - Inicia la producción de componentes y el ensamblaje.
2. **BufferCompartido**:

   - Implementa un buffer que permite la sincronización entre los productores y el consumidor.
   - Contiene métodos `producir` y `consumir` que gestionan la producción y el consumo de componentes.
   - Utiliza `synchronized` para evitar condiciones de carrera y asegurar la coherencia de los datos.
3. **Productor**:

   - Extiende la clase `Thread` y representa una estación de trabajo que produce componentes.
   - En su método `run`, llama al método `producir` del `BufferCompartido` en un bucle infinito, simulando el tiempo de producción entre cada componente.
4. **Consumidor**:

   - También extiende `Thread` y representa la línea de ensamblaje que consume los componentes producidos.
   - En su método `run`, llama al método `consumir` del `BufferCompartido`, y luego ejecuta el proceso de ensamblaje.
5. **GaltonBoard**:

   - Representa el tablero de Galton utilizando JavaFX.
   - Crea una visualización de los contenedores donde las bolas caen, simulando el lanzamiento de bolas que se distribuyen en los contenedores inferiores.
   - Utiliza animaciones para mostrar el movimiento de las bolas a medida que caen a través del tablero.
6. **FabricaComponentes**:

   - Clase responsable de la creación de componentes necesarios para la máquina de Galton.
   - Implementa un método que produce diferentes tipos de componentes según la demanda.
7. **Componente**:

   - Clase que representa los diferentes componentes que pueden ser producidos por la fábrica, como clavos y bolas.
   - Incluye propiedades que describen cada componente, como el tipo y la cantidad.
8. **Clavo**:

   - Clase que extiende `Componente` y representa los clavos que forman parte de la máquina de Galton.
   - Contiene métodos específicos para la producción y manipulación de clavos.
9. **Bola**:

   - Clase que extiende `Componente` y representa las bolas que caen a través del tablero de Galton.
   - Incluye propiedades relacionadas con el comportamiento de las bolas durante la simulación.
10. **Scheduler**:

    - Clase que gestiona la ejecución de los hilos productores utilizando un algoritmo de *Round Robin Scheduling*.
    - Asegura que cada productor tenga un tiempo de ejecución equitativo para la producción de componentes.
    - Recibe una lista de productores y un tiempo fijo por turno para cada uno.

## Funcionamiento

- La aplicación comienza creando una instancia de `BufferCompartido`, que actúa como el punto de comunicación entre los hilos productores y el consumidor.
- Se inician varios hilos productores, cada uno de los cuales produce un tipo de componente diferente.
- Un hilo consumidor se encarga de ensamblar los componentes producidos, tomando componentes del buffer compartido.
- El `BufferCompartido` se sincroniza para evitar que los productores intenten añadir componentes cuando el buffer está lleno y para que el consumidor no intente consumir cuando el buffer está vacío.
- La clase `GaltonBoard` se encarga de visualizar cómo las bolas, al caer a través de los contenedores, se distribuyen en una forma que se asemeja a la curva de campana de la distribución normal.
