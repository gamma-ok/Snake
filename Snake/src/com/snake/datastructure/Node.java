package com.snake.datastructure;

import com.snake.model.Position;

public class Node {
    private final Position data;
    private Node next;
    private Node previous;

    public Node(Position data) {
        this.data = data;
        this.next = null;
        this.previous = null;
    }

    public Position getData() {
        return data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPrevious() {
        return previous;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }
}
