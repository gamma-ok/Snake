package com.snake.model;

import com.snake.datastructure.DoublyLinkedList;

public class Snake {

    private final DoublyLinkedList body;
    private Direction direction;

    public Snake() {
        body = new DoublyLinkedList();
        direction = Direction.RIGHT;

        // Posiciones iniciales | Crear serpiente de 3 segmentos
        body.addFirst(new Position(3, 5));
        body.addFirst(new Position(4, 5));
        body.addFirst(new Position(5, 5));
    }

    public void changeDirection(Direction newDirection) {
        if (newDirection == null) {
            return;
        }

        // Impedir que la serpiente gire directamente hacia la dirección opuesta
        if ((direction == Direction.UP
                && newDirection == Direction.DOWN)
                || (direction == Direction.DOWN
                && newDirection == Direction.UP)
                || (direction == Direction.LEFT
                && newDirection == Direction.RIGHT)
                || (direction == Direction.RIGHT
                && newDirection == Direction.LEFT)) {
            return;
        }

        direction = newDirection;
    }

    // Calcular la posición que tendrá la próxima cabeza
    public Position getNextHeadPosition() {
        Position head = body.getFirst();

        int x = head.getX();
        int y = head.getY();

        switch (direction) {
            case UP:
                y--;
                break;
            case DOWN:
                y++;
                break;
            case LEFT:
                x--;
                break;
            case RIGHT:
                x++;
                break;
        }

        return new Position(x, y);
    }

    // Mover la serpiente un segmento
    public void move() {
        Position newHead = getNextHeadPosition();

        body.addFirst(newHead);
        body.removeLast();
    }

    public void printBody() {
        System.out.print("Cuerpo: ");
        body.print();
    }

    public Position getHead() {
        return body.getFirst();
    }

    public Direction getDirection() {
        return direction;
    }

    public int getLength() {
        return body.size();
    }

    public Position getTail() {
        return body.getLast();
    }

    public boolean willCollideWithBody(Position nextHead) {
        if (!body.contains(nextHead)) {
            return false;
        }

        // Como todavía no hay comida, la cola se desplazará
        // y abandonará su posición en el próximo movimiento.
        Position tail = body.getLast();

        if (tail != null
                && tail.getX() == nextHead.getX()
                && tail.getY() == nextHead.getY()) {
            return false;
        }

        return true;
    }

}
