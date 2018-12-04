package it.sevenbits.practice4.planet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

public class UniqueStorage implements IUniqueStorage {
    final static Logger logger = LoggerFactory.getLogger(UniqueStorage.class);
    private ArrayList<Planet> planets = new ArrayList<Planet>();

    public void add(Planet planet) {
        if (!contains(planet)) {
            logger.info("Planet has been added");
            planets.add(planet);
        }
    }

    public void remove(int id) {
        logger.info("Planet has been removed");
        planets.remove(id);
    }

    public boolean contains(Planet planet) {
        for (Planet plnt: planets) {
            if (plnt.equals(planet)) {
                logger.error("Exist it planet");
                return true;
            }
        }
        return false;
    }

    public Planet valueGet (int number) {
        return planets.get(number);
    }
}
