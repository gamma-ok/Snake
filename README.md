# Snake 🐍

Juego clásico de **Snake** desarrollado en **Java** con **Swing**.

## Funcionalidades actuales

- Movimiento automático de la serpiente.
- Control mediante las flechas del teclado o las teclas **WASD**.
- Detección de colisiones con las paredes y con el cuerpo.
- Tablero y serpiente dibujados en un `JPanel`.
- Visualización de las coordenadas en la consola.

## ¿Cómo funciona?

La serpiente se representa mediante una **lista doblemente enlazada implementada manualmente**. Cada nodo almacena la posición de un segmento.

En cada actualización del juego, el controlador calcula la siguiente posición, comprueba si existe una colisión y, si el movimiento es válido, agrega una nueva cabeza y elimina la cola. Después, la interfaz se vuelve a dibujar.

## Tecnologías

- Java
- Java Swing (`JFrame Form`, `JPanel` y `Timer`)
- Maven

## Ejecución

1. Abre el proyecto en **Apache NetBeans**.
2. Espera a que Maven cargue las dependencias.
3. Ejecuta la clase `com.snake.app.Main`.
4. Controla la serpiente con las **flechas** o **WASD**.

> Proyecto en desarrollo.
