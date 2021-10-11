package ex43;

/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 John Page
 */

import java.io.*;
import java.util.Scanner;

public class Website
{
    public static void main(String[] args)
    {
        // Declare scanner and website variables
        Scanner SC = new Scanner(System.in);
        String currentPath, author, siteName;

        // js and css are defined as 'N'
        char js = 'N';
        char css = 'N';

        // Gets user input for website details
        System.out.print("Site name: ");
        siteName = SC.nextLine();
        System.out.print("Author: ");
        author = SC.nextLine();
        System.out.print("Do you want a folder for JavaScript? ");
        js = SC.next().charAt(0);
        System.out.print("Do you want a folder for CSS? ");
        css = SC.next().charAt(0);
        currentPath = System.getProperty("user.dir");
        currentPath += "\\"+siteName;

        // creates file under current path
        File website = new File(currentPath);
        boolean websiteCreated = website.mkdir();

        // If website is created file path is made
        if(websiteCreated)
        {
            System.out.println("Created " + currentPath);
            try
            {
                FileWriter skeletonWriter = new FileWriter(new File(currentPath+"\\index.html"));
                skeletonWriter.write("<!DOCTYPE html>\n<html lang=\"en\">\n<head>\n");
                skeletonWriter.write("\t<meta author=\""+author+"\">\n");
                skeletonWriter.write("\t<title>"+siteName+"</title>\n");
                skeletonWriter.write("</head>\n<body>\n\n</body>\n</html>");
                skeletonWriter.close();

                System.out.println("Created " + currentPath+"\\index.html");

                // If js and css is set to true yes the appropriate folder for each is created
                if(js == 'y' || js == 'Y')
                {
                    File jsFolder = new File(currentPath+"\\js");
                    boolean jsCreated = jsFolder.mkdir();
                    if(jsCreated)
                    {
                        System.out.println("Created " + jsFolder+"\\");
                    }
                    else
                    {
                        System.out.println("Js folder not created!!");
                    }
                }
                if(css == 'y' || css == 'Y')
                {
                    File cssFolder = new File(currentPath+"\\css");
                    boolean cssCreated = cssFolder.mkdir();

                    if(cssCreated)
                    {
                        System.out.println("Created " + cssFolder+"\\");
                    }

                    else
                    {
                        System.out.println("CSS folder not created!!");
                    }
                }
            }

            catch(IOException e)
            {
                System.out.println("index.html not created as required!!");
            }
        }

        // Website is not created
        else
        {
            System.out.println("Website folder not created!!");
        }

        SC.close();
    }
}
