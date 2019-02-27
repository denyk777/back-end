package it.sevenbits.courses.servlet;

public class Task {
    private static int counterID = 0;

    private String name = null;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Task(String name) {
        this.name = name;
        this.ID = counterID;
        counterID++;
    }

    private Task(){}

    private int ID;
}
