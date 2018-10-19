package it.sevenbits.workshop.DoubleEndedQueue;

import it.sevenbits.workshop.Matrix.Matrix;

import java.util.Random;

class Node {
    private Matrix value;
    public final static int RANDOM_NODE = 1;
    private Node(){}

    public Node(Matrix matrix){SetValue(matrix);}

    public Node(int nodeClass){
        switch (nodeClass) {
            case RANDOM_NODE:
                Random rand = new Random();
                SetValue(new Matrix( rand.nextInt(3) + 1,rand.nextInt(3) + 1));
                break;

            default:
                break;
        }
    }

    public Matrix GetValue() {
        return value;
    }

    public void SetValue(Matrix newMatrix) {
        value = newMatrix;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("node contain: \n");
        sb.append(GetValue().toString());
        return sb.toString();
    }
}
