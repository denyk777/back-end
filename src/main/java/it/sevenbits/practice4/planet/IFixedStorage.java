package it.sevenbits.practice4.planet;

public interface IFixedStorage {
    void add(Integer number, Planet planet);
    void remove(Integer key);
    Planet valueGet(Integer key);
    boolean contains(Planet value);
}
