package com.example.animalcomparisondisplay;

import java.io.Serializable;
import java.util.ArrayList;

public class Animals implements Serializable {
    private static final long serialVersionUID = 1L;
    private int rank;
    private String name;
    private float length;
    private int maxMass;
    static ArrayList<Animals> animals = new ArrayList<>();

    public Animals(int rank, String name, float length, int maxMass) {
        this.rank = rank;
        this.name = name;
        this.length = length;
        this.maxMass = maxMass;
        animals.add(this);
    }

    public static ArrayList<Animals> getAnimals() {
        return animals;
    }

    public static void setAnimals(ArrayList<Animals> animals) {
        Animals.animals = animals;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public int getMaxMass() {
        return maxMass;
    }

    public void setMaxMass(int maxMass) {
        this.maxMass = maxMass;
    }

    public String toString() {
        return getName() + " has a max mass of " + getMaxMass() + "lb";
    }

    public static void summarize() {
        float avgLength = 0f;
        int avgMaxMass = 0;

        for (Animals animal: getAnimals()) {
            avgLength += animal.getLength();
            avgMaxMass += animal.getMaxMass();
        }

        System.out.println("\nThere are " + getAnimals().size() + " animals in the dataset");

        System.out.println("The total length of the animals is " + avgLength + " feet\n" + "The total max mass of the animals is " + avgMaxMass + " lbs");

        avgLength = avgLength / getAnimals().size();
        avgMaxMass = avgMaxMass / getAnimals().size();

        System.out.println("\nThe average length of the animals is " + avgLength + " feet\n" + "The average max mass of the animals is " + avgMaxMass + " lbs");
    }
}