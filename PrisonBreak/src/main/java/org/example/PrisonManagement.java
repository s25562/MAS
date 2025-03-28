package org.example;

import java.util.Optional;

public class PrisonManagement {
    public static void main(String[] args) {
        Prisoner p1 = new Prisoner("John", "Doe", 101, "Robbery", Optional.of(10));
        Prisoner p2 = new Prisoner("Mark", "Smith", 102, "Fraud", null);

        p1.addPrivilege("Library access");
        p2.addPrivilege("Gym access");

        System.out.println(p1);
        System.out.println("Privileges: " + p1.getPrivileges());
        System.out.println("Remaining sentence: " + p1.getRemainingSentence(3) + " years");

        Guard g1 = new Guard("Mike", 201);
        SeniorGuard sg1 = new SeniorGuard("Steve", 301, 15);

        g1.patrol();
        sg1.patrol();
        sg1.patrol("Sector B");
    }
}