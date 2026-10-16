package com.snake.datastructure;

import com.snake.model.Position;

public class DoublyLinkedList {
    private Node head;
    private Node tail;
    private int size;

    public DoublyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    // Agregar un nodo al inicio
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

    // Eliminar el último nodo
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

    // Obtener la cabeza de la lista
    public Position getFirst() {
        if (head == null) {
            return null;
        }

        return head.getData();
    }
    
    // Obtejer la última posición de la serpiente
    public Position getLast() {
        if (tail == null) {
            return null;
        }
        return tail.getData();
    }


    // Obtener el tamaño de la lista
    public int size() {
        return size;
    }

    // Comprobar si una coordenada ya está ocupada
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

    // Mostrar todos los nodos desde la cabeza hasta la cola
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
}
