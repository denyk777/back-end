package it.sevenbits.workshop.DoubleEndedQueue;

import it.sevenbits.workshop.Matrix.Matrix;

import java.util.Arrays;

public class DoubleEndedQueue {
    private Node[] nodeQueue = {}; // мог использовать Linked/Array List, но это тоже коллекция, так что предпочел более простой вариант для воркшопа
    private int queueMaxSize;
    public static int RANDOM_NODE = 1;

    private DoubleEndedQueue(){}

    public DoubleEndedQueue(int queueMaxSize) {
        this.queueMaxSize = queueMaxSize;

    }
    public Node GetFirst(){
        return nodeQueue[0];
    }

    public Node GetLast(){
        return nodeQueue[nodeQueue.length - 1];
    }

    public void AddFirst(Matrix matrix){
        if (nodeQueue.length + 1 <= queueMaxSize) {
            nodeQueue = Arrays.copyOf(nodeQueue, nodeQueue.length + 1);
            for (int i = nodeQueue.length - 1; i > 0; i--) {
                nodeQueue[i + 1] = nodeQueue[i];
            }
            nodeQueue[0] = new Node(matrix);
        } else {
            System.out.println("Error!Queue overloaded!Remove at least one element");
        }
    }

    public void AddFirst(int nodeClass) {
        if (nodeQueue.length + 1 <= queueMaxSize) {
            nodeQueue = Arrays.copyOf(nodeQueue, nodeQueue.length + 1);
            for (int i = nodeQueue.length - 2; i > 0; i--) {
                nodeQueue[i + 1] = nodeQueue[i];
            }
            nodeQueue[0] = new Node(nodeClass);
        } else {
            System.out.println("Error!Queue overloaded!Remove at least one element");
        }
    }

    public void AddLast(Matrix matrix){
        if(nodeQueue.length + 1 <= queueMaxSize) {
        nodeQueue = Arrays.copyOf(nodeQueue,nodeQueue.length + 1);
        nodeQueue[nodeQueue.length - 1] = new Node(matrix);
        } else {
            System.out.println("Error!Queue overloaded!Remove at least one element");
        }
    }

    public void AddLast(int nodeClass){
        if(nodeQueue.length + 1 <= queueMaxSize) {
            nodeQueue = Arrays.copyOf(nodeQueue,nodeQueue.length + 1);
            nodeQueue[nodeQueue.length - 1] = new Node(nodeClass);
        } else {
            System.out.println("Error!Queue overloaded!Remove at least one element");
        }
    }

    public boolean IsEmpty(){
        return nodeQueue.length > 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Queue contain:").append("\n");
        for (int i = 0; i < nodeQueue.length; i++) {
            sb.append(i).append(' ');
            sb.append(nodeQueue[i].toString());
        }
        sb.append(" \n");
        return sb.toString();
    }
}
