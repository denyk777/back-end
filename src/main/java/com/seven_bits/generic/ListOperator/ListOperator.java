package com.seven_bits.generic.ListOperator;

import java.util.List;

/**
 * generic class
 * @param <T> some class
 */
public class ListOperator<T extends Comparable<T>> {
    private T first = null;

    /**
     *
     * @param list array with classes
     * @param startNumber start number
     * @param finishNumber finish number
     * @return maximum value
     */
    public T max(final List<T> list, final int startNumber, final int finishNumber) {
        try {
            first = list.get(startNumber);
            for (int i = startNumber; i <= finishNumber; i++) {
                if (compareTo(list.get(i)) < 0) {
                    first = list.get(i);
                }
            }
            return first;
        } catch (Exception e) {
            System.out.println("Out of range");
        }
        return null;
    }

    private int compareTo(final T t) {
        return first.compareTo(t);
    }

    /**
     *
     * @param list array with classes
     * @param firstNumber first number
     * @param secondNumber second number
     */
    public void changeElementsPosition(final List<T> list, final int firstNumber, final int secondNumber) {
        try {
            first = list.get(firstNumber);
            T second = list.get(secondNumber);
            list.set(firstNumber, second);
            list.set(secondNumber, first);
            System.out.println("Changed " + firstNumber + " and " + secondNumber);
        } catch (Exception e) {
            System.out.println("Field have not been changed");
        }
    }

    /**
     *
     * @param list array with classes
     */
    public void printList(final List<T> list) {
        for (T element: list) {
            System.out.println(element.toString());
        }
    }
}