package edu.cscc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Census {
    public static Surname[] loadCensusData(String fname) {
        // Keep track of lines of file we've read
        int lines = 0;
        Surname[] namelist = new Surname[101];

        // TODO - Add code to read file and populate array of Surname objects

        String[] fields;

        File file = new File("Surnames_2010Census.csv");
        try (Scanner input = new Scanner(file)) {
            while (input.hasNext() && lines < 101) {
                String s = input.nextLine();

                fields = s.split(",");
                if (lines != 0) {
                    try {
                        namelist[lines] = new Surname(fields[0], Integer.parseInt(fields[1]), Integer.parseInt(fields[2]), Double.parseDouble(fields[3]));
                    } catch (NumberFormatException ex) {
                        System.err.println("Bad number format on line " + lines + ".");
                    }
                }
                lines++;
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Cannot access file " + fname);
            return null;
        }

        return namelist;
    }
}