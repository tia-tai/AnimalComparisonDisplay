package com.example.animalcomparisondisplay;

import com.example.animalcomparisondisplay.Animals;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Mammal extends Animals {
    private int avgMass;
    static ArrayList<Mammal> mammals = new ArrayList<Mammal>();

    public Mammal(int rank, String name, float length, int maxMass, int avgMass) {
        super(rank, name, length, maxMass);
        this.avgMass = avgMass;
        mammals.add(this);
    }

    public static ArrayList<Mammal> getMammals() {
        return mammals;
    }

    public static void setMammals(ArrayList<Mammal> mammals) {
        Mammal.mammals = mammals;
    }

    public int getAvgMass() {
        return avgMass;
    }

    public void setAvgMass(int avgMass) {
        this.avgMass = avgMass;
    }

    public String toString() {
        return getName() + " has a max mass of " + getMaxMass() + "lb";
    }

    public static void readMammalData() throws Exception {
        File dataFile = new File("src/main/MammalData");
        Scanner fileScanner = new Scanner(dataFile);
        while (fileScanner.hasNextLine()) {
            String data = fileScanner.nextLine();
            String[] dataSegment = data.split("\t");
            if (dataSegment[0].equals("Rank") || dataSegment[0].split(" ")[0].equals("in")) {
                System.out.println("Line Skipped");
            } else {
                int rank = Integer.parseInt(dataSegment[0]);
                String name = dataSegment[1].split("\\[")[0];
                float length = Float.parseFloat(dataSegment[4].split("\\(")[1].split("\\)")[0]);
                int maxMass = (int) Float.parseFloat(dataSegment[3].split("\\[")[0])*2205;
                int avgMass = (int) Float.parseFloat(dataSegment[2].split("\\[")[0])*2205;
                new Mammal(rank, name, length, maxMass, avgMass);
            }
        }
    }
}
