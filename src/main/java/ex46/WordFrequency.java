package ex46;

/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 John Page
 */

import java.util.*;
import java.io.*;

class WordFrequency {
    public static void main(String args[]) throws IOException {

        // Scan for input file and create a tree map
        Scanner file=new Scanner(new File("src/exercise46_input.txt"));
        Map<String,Integer> hm=new TreeMap<String,Integer>();

        // Read the input file and add them into the map
        while(file.hasNext()) {
            String str=file.next();
            if(hm.containsKey(str))
                hm.put(str,hm.get(str)+1);
            else
                hm.put(str,1);
        }

        // Print the histogram
        for(String key:hm.keySet()) {
            System.out.printf("%-10s",key+":");
            for(int i=hm.get(key);i>0;i--)
                System.out.print("*");
            System.out.println();
        }
    }
}
