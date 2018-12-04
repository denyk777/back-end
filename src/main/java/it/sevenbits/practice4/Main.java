package it.sevenbits.practice4;

import it.sevenbits.practice4.planet.*;

import java.util.ArrayList;

public class Main {


    public static void main(String[] args) {
        ArrayList<Planet> list = new ArrayList<Planet>();
        list.add(new Planet("Mercury"));
        list.add(new Planet("Venus"));
        list.add(new Planet("Earth"));
        list.add(new Planet("Mars"));
        list.add(new Planet("Jupiter"));
        list.add(new Planet("Saturn"));
        list.add(new Planet("Uranus"));

        IUniqueStorage storage = new UniqueStorage();
        storage.add(list.get(0));
        storage.add(list.get(1));
        storage.add(list.get(2));
        storage.add(list.get(3));
        storage.add(list.get(4));
        storage.add(list.get(5));
        storage.add(list.get(6));
        storage.add(list.get(6));
        storage.remove(6);
        storage.add(list.get(6));

        IFixedStorage fixedStorage = new FixedStorage();
        fixedStorage.add(0, list.get(0));
        fixedStorage.add(1, list.get(1));
        fixedStorage.add(2, list.get(2));
        fixedStorage.add(3, list.get(3));

        fixedStorage.add(4, list.get(4));
        fixedStorage.remove(4);
        fixedStorage.add(4, list.get(4));

        fixedStorage.add(5, list.get(6));
        fixedStorage.add(5, list.get(5));

        fixedStorage.add(6, list.get(1));
        fixedStorage.add(6, list.get(6));

        for (int i = 0; i < 7; i++) {
            if (storage.valueGet(i).equals(fixedStorage.valueGet(i))) {
                System.out.println("Item " + i + " equals");
            } else {
                System.out.println("Item " + i + " not equals");
            }
        }
    }
}
