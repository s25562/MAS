package org.example;

class Guard {
    protected String name;
    private int id;

    public Guard(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public void patrol() {
        System.out.println(name + " is patrolling.");
    }
}