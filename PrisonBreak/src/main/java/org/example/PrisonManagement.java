package org.example;


import java.sql.Date;
import java.time.LocalDate;

public class PrisonManagement {
    public static void main(String[] args) {
        Prisoner.loadExtent();

        System.out.println("Lista więźniów przed dodaniem nowych:");
        for (Prisoner p : Prisoner.getExtent()) {
            System.out.println(p);
        }

        // Dodajemy nowych więźniów
        Prisoner p1 = new Prisoner(1, "Kuba", "Amerek", "Robbery", 2002, 30);
        Prisoner p2 = new Prisoner(2, "Anna", "Amerek", "Robbery", 1995, null);

        System.out.println("\nLista więźniów po dodaniu nowych:");
        for (Prisoner p : Prisoner.getExtent()) {
            System.out.println(p);
        }

        Prisoner.loadExtent();

        var z = p1.getRemainingSentence();
        System.out.println(z);



    }
}