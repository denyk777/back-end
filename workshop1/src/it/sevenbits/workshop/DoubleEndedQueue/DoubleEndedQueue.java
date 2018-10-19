package it.sevenbits.workshop.DoubleEndedQueue;

import it.sevenbits.workshop.Matrix.Matrix;

public class DoubleEndedQueue {
    private Node first;
    private Node last;
    private int size;

    public DoubleEndedQueue() {
        this.first = new Node();
        this.last = new Node();
        this.first.setNext(last);
        this.last.setPrev(first);
        this.size = 0;
        }

    public Matrix getFirst() {
        return this.first.getNext().getValue();
    }

    public Matrix getLast() {
        return this.last.getPrev().getValue();
    }

    public void addFirst(Matrix matrix) {
        Node second = first.getNext();
        Node currentFirst = new Node(first, second, matrix);
        first.setNext(currentFirst);
        second.setPrev(currentFirst);
        size++;
    }

    public void addLast(Matrix matrix) {
        Node prevLast = last.getPrev();
        Node currentLast = new Node(prevLast, last, matrix);
        last.setPrev(currentLast);
        prevLast.setNext(currentLast);
        size++;
    }

    public int getSize() {
        return this.size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node current = this.first.getNext();
        for(int i = 0; i < this.size; i++) {
            sb.append("--\n").append(current.getValue().toString()).append("--\n");
            current = current.getNext();
        }
        return sb.toString();
    }
}
