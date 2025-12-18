package com.example.animalcomparisondisplay;

import com.example.animalcomparisondisplay.Animals;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;

import javax.imageio.ImageIO;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Mammal extends Animals implements Serializable {
    private static final long serialVersionUID = 1L;
    private int avgMass;
    transient private Image img;
    static ArrayList<Mammal> mammals = new ArrayList<Mammal>();

    public boolean isFirstOn() {
        return firstOn;
    }

    public void setFirstOn(boolean firstOn) {
        this.firstOn = firstOn;
    }

    private boolean firstOn;

    public Mammal(int rank, String name, float length, int maxMass, int avgMass, Image img, boolean firstOn) {
        super(rank, name, length, maxMass);
        this.avgMass = avgMass;
        this.img = img;
        this.firstOn = firstOn;
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

    public Image getImg() {
        return img;
    }

    public void setImg(Image img) {
        this.img = img;
    }

    public static void readMammalData() throws Exception {
        restoreData();
        if (Mammal.getMammals().isEmpty()) {
            File dataFile = new File("src/main/mammalData");
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
                    Image imgFile = null;
                    new Mammal(rank, name, length, maxMass, avgMass, imgFile, false);
                }
            }
        }
    }

    public static void deleteMammalData(Mammal mammal) throws Exception {
        mammals.remove(mammal);
        System.out.println("removed");
    }

    static void saveData() throws Exception {
        FileOutputStream fileOut = new FileOutputStream("src/main/mammalSavedData");
        ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
        objectOut.writeObject(Mammal.getMammals());
        objectOut.close();
        fileOut.close();
    }

    static void restoreData() {
        try {
            FileInputStream fileIn = new FileInputStream("src/main/mammalSavedData");
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            Mammal.setMammals((ArrayList<Mammal>) objectIn.readObject());
            objectIn.close();
            fileIn.close();
        } catch (Exception e) {

        }
    }

    @Serial
    private void writeObject(ObjectOutputStream s) throws IOException {
        s.defaultWriteObject();
        if (img != null) {
            ImageIO.write(SwingFXUtils.fromFXImage(img, null), "png", s);
        }
    }

    @Serial
    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        Image savedImage = null;
        try {
            savedImage = SwingFXUtils.toFXImage(ImageIO.read(s), null);
        } catch (Exception ex) {
        }
        this.img = savedImage;
    }


}
