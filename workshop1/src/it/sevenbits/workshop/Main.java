package it.sevenbits.workshop;

import it.sevenbits.workshop.DoubleEndedQueue.DoubleEndedQueue;
import it.sevenbits.workshop.Matrix.Matrix;

public class Main {
    public static void main(String[] args) {
        DoubleEndedQueue queue = new DoubleEndedQueue();
        Matrix firstMatrix = new Matrix(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
        Matrix secondMatrix = new Matrix(3, 3);
        Matrix thirdMatrix = new Matrix(4, 4);
        queue.addLast(secondMatrix);
        queue.addFirst(firstMatrix);
        queue.addLast(thirdMatrix);
        queue.addLast(secondMatrix);
        queue.addLast(firstMatrix);
        System.out.println(queue.toString());
        queue.addFirst(secondMatrix);
        queue.addLast(thirdMatrix);
        System.out.println(queue.getFirst());
        System.out.println(queue.getLast());
    }
}
