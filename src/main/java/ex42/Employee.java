package ex42;

/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 John Page
 */

import java.util.*;
import java.io.*;

public class Employee {

    // Prints input file into table using file name as parameter
    public void printDetails(String filename) {
        try {
            File file = new File(filename);
            Scanner sc = new Scanner(file);

            // Scan continues until new line
            while (sc.hasNext()) {
                String s = sc.nextLine();
                String[] temp = s.split(",");
                System.out.printf("%-17s%-17s%-17s\n", temp[0], temp[1], temp[2]); // Creates a placeholder for the table
            }
        // Input file is not in the appropriate place
        } catch (FileNotFoundException ex) {
            System.out.println("Error: File Not Found!!");
        }
    }

    // Driver method to test the code
    public static void main(String[] args) {

        Employee emp = new Employee();
        System.out.printf("%-17s%-17s%-17s\n", "Last", "First", "Salary"); // Inserts data into placeholder
        System.out.println("----------------------------------------");
        emp.printDetails("exercise42_input.txt");
    }
}