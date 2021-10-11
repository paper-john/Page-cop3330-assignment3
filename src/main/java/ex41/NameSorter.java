package ex41;

/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 John Page
 */

import java.io.*;
import java.util.*;

public class NameSorter {

    // Scan names into a list until there is a new line
    public static void readNames(Scanner input, ArrayList<String> names) {

        while (input.hasNextLine()) {

            names.add(input.nextLine());
        }
    }

    // Write names into a created text file
    public static void outputNames(ArrayList<String> names) throws IOException {

        FileWriter output = new FileWriter("exercise41_output.txt");
        output.write("Total of " + names.size() + " names\n");
        output.write("--------------------\n");

        for (String i : names) {

            output.write(i + "\n");

        }

        output.close();
    }

    // Scans for input file name and reads the name
    public static void main(String[] args) throws FileNotFoundException {

        Scanner inputFile = new Scanner(new File("src/exercise41_input.txt"));

        ArrayList<String> names = new ArrayList<String>();

        readNames(inputFile, names);

        Collections.sort(names, String.CASE_INSENSITIVE_ORDER);

        inputFile.close();

        // Outputs list of sorted names into file
        try {
            outputNames(names);
        }

        catch (Exception e) {
            System.out.println(e);
        }
    }
}