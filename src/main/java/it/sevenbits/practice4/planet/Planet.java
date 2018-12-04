package it.sevenbits.practice4.planet;

import java.util.UUID;

public class Planet {
    private String name;
    private String id;

    public Planet(final String name) {
        this.name = name;
        this.id = UUID.randomUUID().toString();
    }
}
