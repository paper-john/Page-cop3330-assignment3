package ex45;

/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 John Page
 */

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class WordFinder {

    public static void main(String[] args) throws IOException {

        // Create file path and declare file scanner
        File file = new File("src/exercise45_input.txt");
        Scanner sc = new Scanner(file);

        // Declare scanner to get user input
        Scanner s = new Scanner(System.in);

        // Have user create the name of the new file
        System.out.print("\nEnter the name of Output File : ");

        String outputFile = s.next();

        // Write the output file
        FileWriter writer = new FileWriter(" "+outputFile);
        try
        {
            // Loop until there is no new line and replace all instances of "utilize" with "use"
            while( sc.hasNext() )
            {
                String user = sc.nextLine();
                user = user.replaceAll("utilize", "use");
                writer.write(user);
                writer.write("\n");


            }
        }
        finally
        {
            sc.close();
        }

        // Close the writer and notify the user that the document has been updated
        writer.close();

        System.out.println("\nSuccessfully Modified!!");

    }
}

