package org.example;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*
To Do:
- Ekstensja - done
- Ekstensja, trwałość - done
- Atrybut złożony - done
- Atrybut opcjonalny - done
- Atrybut powtarzalny
- Atrybut klasowy - done
- Atrybut pochodny - done
- Metoda klasowa - done
- Przesłonięcie, przeciążenie
 */

public class Prisoner implements Serializable {
    private static final String FILE_NAME = "prisoners.dat";

    private static class FullName implements Serializable {
        //private static final long serialVersionUID = 1L; // UID dla FullName
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

    // Variables & Resources
    private static List<Prisoner> prisoners = new ArrayList<>();
    private FullName name;
    private int id;
    private String crime;
    private Integer sentenceLength;

    private int yearOfBegining;
    private List<String> privileges;
    private static int totalPrisoners = 0;

    public Prisoner(int id, String firstName, String lastName, String crime, int yearOfBegining, Integer sentenceLength) {
        this.id = id;
        this.yearOfBegining = yearOfBegining;
        this.name = new FullName(firstName, lastName);
        this.crime = crime;
        this.sentenceLength = sentenceLength;
        this.privileges = new ArrayList<>();
        addExtent(this);
        saveExtent();
    }

    public static void clearExtent() {
        prisoners.clear();
        saveExtent();
    }

    public static void saveExtent() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(prisoners);
        } catch (IOException e) {
            System.err.println("Błąd zapisu ekstensji: " + e.getMessage());
        }
    }

    public static void loadExtent() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            prisoners = (List<Prisoner>) ois.readObject();
            totalPrisoners = prisoners.size();
        } catch (FileNotFoundException e) {
            System.out.println("Brak zapisanej ekstensji, rozpoczynamy od zera.");
            prisoners = new ArrayList<>();
            totalPrisoners = 0;

        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Błąd odczytu ekstensji: " + e.getMessage());
        }
    }

    public static List<Prisoner> getExtent() {
        return new ArrayList<>(prisoners);
    }

    private static void addExtent(Prisoner prisoner) {
        prisoners.add(prisoner);

    }

    public static void showExtent() {
        System.out.println("Extent of the class: " + Prisoner.class.getName());
        for (Prisoner prisoner : prisoners) {
            System.out.println(prisoner);
        }
    }

    public static int getTotalPrisoners() {
        return totalPrisoners;
    }

    public int getRemainingSentence() {
        return (this.sentenceLength != null) ? this.sentenceLength - (LocalDate.now().getYear() - yearOfBegining) : 0;
    }

    public List<String> getPrivileges() {
        return privileges;
    }

    @Override
    public String toString() {
        return "Prisoner: " + name.toString() + ", ID: " + id + ", Crime: " + crime + ", Sentence: " + (sentenceLength != null ? sentenceLength + " years" : "Life");
    }
}