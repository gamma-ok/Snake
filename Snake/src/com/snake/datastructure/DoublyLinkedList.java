package com.snake.datastructure;

import com.snake.model.Position;
import java.util.ArrayList;
import java.util.List;

public class DoublyLinkedList {
    private Node head;
    private Node tail;
    private int size;

    public DoublyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    // Agregar nodo al inicio
    public void addFirst(Position position) {
        Node newNode = new Node(position);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.setNext(head);
            head.setPrevious(newNode);
            head = newNode;
        }

        size++;
    }

    // Eliminar último nodo
    public void removeLast() {
        if (tail == null) {
            return;
        }

        if (head == tail) {
            head = null;
            tail = null;
        } else {
            tail = tail.getPrevious();
            tail.setNext(null);
        }

        size--;
    }

    // Obtener cabeza de la lista
    public Position getFirst() {
        if (head == null) {
            return null;
        }

        return head.getData();
    }

    // Obtejer última posición de la serpiente
    public Position getLast() {
        if (tail == null) {
            return null;
        }
        return tail.getData();
    }

    // Obtener tamaño de la lista
    public int size() {
        return size;
    }

    // Comprobar si una coord esta ocupada
    public boolean contains(Position position) {
        Node current = head;

        while (current != null) {
            Position data = current.getData();

            if (data.getX() == position.getX()
                    && data.getY() == position.getY()) {
                return true;
            }

            current = current.getNext();
        }

        return false;
    }

    // Mostrar todos los nodos (cabeza -> cola)
    public void print() {
        Node current = head;

        System.out.print("[");

        while (current != null) {
            System.out.print(current.getData());

            if (current.getNext() != null) {
                System.out.print(", ");
            }

            current = current.getNext();
        }

        System.out.println("]");
    }

    // Recorrer lista (cabeza -> cola)
    public List<Position> getPositions() {
        List<Position> positions = new ArrayList<>();

        Node current = head;

        while (current != null) {
            positions.add(current.getData());
            current = current.getNext();
        }

        return positions; // Devolver coords ordenadas (cabeza -> cola)
    }

}
