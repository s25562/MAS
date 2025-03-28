package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

class Prisoner {
    // A class attribute
    private static int lifeSentenceCount = 0;

    // A complex attribute (full name as an object)
    static class FullName {
        String firstName;
        String lastName;

        public FullName(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        @Override
        public String toString() {
            return firstName + " " + lastName;
        }
    }

    private static List<Prisoner> extent = new ArrayList<>(); // Class extent – persistence

    private FullName name;
    private int id;
    private String crime;
    private Optional<Integer> sentenceLength; // An optional attribute
    private List<String> privileges; // A multi-value attribute

    public Prisoner(String firstName, String lastName, int id, String crime, Optional<Integer> sentenceLength) {
        this.name = new FullName(firstName, lastName);
        this.id = id;
        this.crime = crime;
        this.sentenceLength = sentenceLength;
        this.privileges = new ArrayList<>();
        if (sentenceLength == null) {
            lifeSentenceCount++;
        }
        extent.add(this);
    }



    // A class method
    public static Prisoner findPrisonerById(int id) {
        for (Prisoner p : extent) {
            if (p.id == id) {
                return p;
            }
        }
        return null; // If prisoner doesn't exist
    }

    // A derived attribute (remaining sentence time in years)
    public int getRemainingSentence(int yearsServed) {
        return (sentenceLength.isEmpty()) ? Math.max(0, (sentenceLength.get() - yearsServed)) : 0;
    }

    public void addPrivilege(String privilege) {
        privileges.add(privilege);
    }

    public List<String> getPrivileges() {
        return privileges;
    }

    public void showSentencedDeath(){
        System.out.println("Liczba więźniów skazanych na dożywocie: " + lifeSentenceCount);
    }

    @Override
    public String toString() {
        return "Prisoner: " + name + ", ID: " + id + ", Crime: " + crime + ", Sentence: " + (sentenceLength.isPresent() ? sentenceLength.get() + " years" : "Life");
    }
}


