/**
@author Anthony Garza
Project: Swiss Army Knife
Purpose: This application is meant to act as a command line application that takes HTTP requests and stores data returned from the request 
        in an arraylist of strings. It will also  take a URL as an input parameter, open JSON referenced by the URL, parse the file for additional URLs,
        make an HTTP request to get each of the files identified in the file, and print the results of each of the additional URLs to the console. 
 */

 public class sak {
    public static void main(String[] args){
        System.out.println("Starting Swiss Army Knife...");

        //declare timer variables 
        long startTimer;
        long endTimer; 

        if (args.length < 1) {
            //starts off the application if user only types "java sak" by automatically calling help method.
            System.out.println("This application needs at least one argument to function properly.");
            System.out.println("Please reference the -Help method below for more information on how to use the application.\n");

            System.out.println("Help Method Executing...\n");
            
            //Call Help Method with timer for execution
            //time help method execution take nanotime then convert to microseconds by dividing returned value by 1000000
            startTimer = System.nanoTime();
            Help.helpGuide();
            endTimer = System.nanoTime();
            System.out.printf("Help Method Exeuction Time Elapsed: %.2f milliseconds", ((endTimer - startTimer) / 1E6));
        }
        //calling Help method
        else if (args[0].equalsIgnoreCase("-Help")) {
            System.out.println("Help Method Executing...\n");

            //Call Help Method with timer for execution
            startTimer = System.nanoTime();
            Help.helpGuide();          
            endTimer = System.nanoTime();
            System.out.printf("Help Method Exeuction Time Elapsed: %.2f milliseconds", ((endTimer - startTimer) / 1E6));
        }
        //calling HttpRequest Method
        else if (args[0].equalsIgnoreCase("-HttpRequest")) {
            System.out.println("HttpRequest Method Executing...\n");

            //call HttpRequest Method with timer for execution
            startTimer = System.nanoTime(); //starting timer above the nested if statement so if it fails out then it still validly counts execution time
            if (args.length < 2) {
                System.out.println("Please enter in a valid URL in order for the HttpRequest Method to properly work.\n");
                endTimer = System.nanoTime(); //end timer and print execution time elapsed
                System.out.printf("HttpRequest Method Exeuction Time Elapsed: %.2f milliseconds", ((endTimer - startTimer) / 1E6));
            } 
            else {
                //look for URL as second parameter of command line argument
                String URL = args[1];
                HttpRequest urlRequest = new HttpRequest();
                if (urlRequest.readURL(URL)) {
                    System.out.println(urlRequest);
                    endTimer = System.nanoTime(); //end timer and print execution time elapsed
                    System.out.printf("HttpRequest Method Exeuction Time Elapsed: %.2f milliseconds", ((endTimer - startTimer) / 1E6));
                }
                else {
                    //end timer for invalid URL in second parameter
                    endTimer = System.nanoTime(); //end timer and print execution time elapsed
                    System.out.printf("HttpRequest Method Exeuction Time Elapsed: %.2f milliseconds", ((endTimer - startTimer) / 1E6));
                }
            }
        }
        //calling HttpRequestIndex Method
        else if (args[0].equalsIgnoreCase("-HttpRequestIndex")) {
            System.out.println("HttpRequestIndex Method Executing...\n");

            //call HttpRequestIndex Method with timer for execution
            startTimer = System.nanoTime(); //starting timer above the nested if statement so if it fails out then it still validly counts execution time
            if (args.length < 2) {
                System.out.println("Please enter in a valid URL in order for the HttpRequestIndex Method to properly work.\n");
                endTimer = System.nanoTime(); //end timer and print execution time elapsed
                System.out.printf("HttpRequestIndex Method Exeuction Time Elapsed: %.2f milliseconds", ((endTimer - startTimer) / 1E6));
            } 
            else {
                //look for URL as second parameter of command line argument
                String URL = args[1];
                HttpRequest urlRequest = new HttpRequest();
                if (urlRequest.readURL(URL)) {
                    System.out.println(urlRequest);
                    endTimer = System.nanoTime(); //end timer and print execution time elapsed
                    System.out.printf("HttpRequestIndex Method Exeuction Time Elapsed: %.2f milliseconds", ((endTimer - startTimer) / 1E6));
                }
                else {
                    //end timer for invalid URL in second parameter
                    endTimer = System.nanoTime(); //end timer and print execution time elapsed
                    System.out.printf("HttpRequestIndex Method Exeuction Time Elapsed: %.2f milliseconds", ((endTimer - startTimer) / 1E6));
                }
            }
        }
    }
 }