package ex44;

/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 John Page
 */

// import json tool from simple.json library
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Iterator;

public class ProductSearch {
    public static void main(String[] args) {

        // create parser to organize json file
        JSONParser parser = new JSONParser();
        try {

            //Read json file using parser and store it in obj
            Object obj = parser.parse(new FileReader("src/exercise44_input.json"));
            JSONObject jsonObject = (JSONObject)obj;

            //Reading products array from  the file
            JSONArray subjects = (JSONArray)jsonObject.get("products");

            //Create buffered reader object to take user input
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            // Get product name from the user and initialize flag at 0
            String input;
            int flag = 0;
            System.out.print("What is the product name? ");
            input = bufferedReader.readLine();

            //Create iterator for products array
            Iterator iterator = subjects.iterator();
            while (iterator.hasNext()) {
                JSONObject json = (JSONObject) iterator.next();
                String name = (String)json.get("name");

                // Compare user input with product from the array
                if(input.toLowerCase().equals(name.toLowerCase())){

                    // Print product information
                    System.out.println("Name: "+name);
                    System.out.println("Price: "+json.get("price"));
                    System.out.println("Quantity: "+json.get("quantity"));
                    flag = 1; //set flag equal to 1 instead of 0 to leave while loop
                }
            }
            //If flag value is zero, then value is not found
            if(flag == 0){
                System.out.println("Sorry, that product was not found in our inventory");
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}