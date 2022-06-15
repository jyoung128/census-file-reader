package edu.cscc;
/*
Jonah Young
10/29/2019
Lab 9
Read file I/O to print names from 2010 census
 */
public class Main {
    private final static String CENSUSDATAFNAME = "Surnames_2010Census.csv";

    public static void main(String[] args) {

        Surname[] namelist = Census.loadCensusData(CENSUSDATAFNAME);

        if (namelist != null) {
            System.out.println("Rank\tName");
            for (Surname name : namelist) {
                if(name != null) {
                    System.out.println(name.getRank() + "\t\t" + name.getName());
                }
            }
        }
    }
}