package it.sevenbits.practice4.planet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class FixedStorage implements IFixedStorage {
    final static Logger logger = LoggerFactory.getLogger(FixedStorage.class);
    Map<Integer, Planet> planets = new HashMap<Integer, Planet>();

    public void add(Integer number, Planet planet) {
        if (!contains(planet) && number < 7) {
            logger.info("Planet " + number + " has been added");
            planets.put(number, planet);
        } else if (contains(planet) && number < 6){
            logger.warn("Planet " + number + " was replace");
            planets.put(number, planet);
        } else if (number >= 6) {
            logger.error("Planet " + valueGet(number) + " not added");
        }
    }

    public void remove(Integer key) {
        for (Map.Entry<Integer, Planet> planetEntry: planets.entrySet()) {
            if (planetEntry.getKey().equals(key)) {
                planets.remove(key);
                logger.info("Planet " + key + " was remove");
                return;
            }
        }
    }

    public Planet valueGet(Integer key) {
        for (Map.Entry<Integer, Planet> planetEntry: planets.entrySet()) {
            if (planetEntry.getKey().equals(key)) {
                return planetEntry.getValue();
            }
        }
        logger.error("Key out of range");
        return null;
    }

    public boolean contains(Planet value) {
        for (Map.Entry<Integer, Planet> planetEntry: planets.entrySet()) {
            if (planetEntry.getValue().equals(value)) {
                return true;
            }
        }
        return false;
    }
}
