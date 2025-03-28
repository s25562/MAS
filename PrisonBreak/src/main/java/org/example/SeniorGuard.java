package org.example;

class SeniorGuard extends Guard {
    private int experience;

    public SeniorGuard(String name, int id, int experience) {
        super(name, id);
        this.experience = experience;
    }


    // Method overriding
    @Override
    public void patrol() {
        System.out.println("Senior guard " + name + " with " + experience + " years of experience is patrolling.");
    }

    // Method overloading
    public void patrol(String sector) {
        System.out.println("Senior guard " + name + " is patrolling sector " + sector + ".");
    }
}