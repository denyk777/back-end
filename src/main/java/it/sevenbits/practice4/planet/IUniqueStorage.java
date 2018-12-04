package it.sevenbits.practice4.planet;

public interface IUniqueStorage {
    void add(Planet planet);
    void remove(int id);
    boolean contains(Planet planet);
    Planet valueGet(int number);
}
