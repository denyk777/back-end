package it.sevenbits.workshop.DoubleEndedQueue;

import it.sevenbits.workshop.Matrix.Matrix;

class Node {
    private Node next;
    private Node prev;
    private Matrix value;

    public Node(){
        this.next = null;
        this.prev = null;
        this.value = null;
    }

    public Node(Node prev, Node next, Matrix matrix){
       this.next = next;
       this.prev = prev;
       this.value = matrix;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public Matrix getValue() {
        return value;
    }

    public void setValue(Matrix value) {
        this.value = value;
    }
}
