/**
DISCLAIMER: I, Anthony Garza, am not the author of this file. This is written by Prof. Pogue.
            Prof. Pogue has given us right and access to utilize this file for our Swiss Army Knife Application in the Week 5 
            Lecture Video at roughly 47:20 mark of the video. I only added line 48 for command line confirmation IF a url parameter is present but the URL is not valid
 */

import java.net.URL;
import java.net.URLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class HttpRequest {
    protected String requestURL;
    protected ArrayList<String> urlContent;
    
    HttpRequest() {
        requestURL = "";
        urlContent = new ArrayList<String>();
    }

    HttpRequest(String urlIn) {
        requestURL = urlIn;
        urlContent = new ArrayList<String>();
    }

    public Boolean readURL() {
        return readURL(requestURL);
    }

    public Boolean readURL(String urlIn) {
        requestURL = urlIn;
        Boolean returnValue = false; 
        try {
            URL myURL = new URL(requestURL);
            URLConnection myConnection = myURL.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(myConnection.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                urlContent.add(inputLine);
                returnValue = true;
            }
            in.close();
        }
        catch (Exception e) {
            returnValue = false;
            System.out.println("Invalid URL. Please try again.");
        }
        
        return returnValue;
    }

    public String toString() {
        String returnValue = "URL: "+requestURL + "\n";
        for (String s : urlContent) {
            returnValue = returnValue + s + "\n";
        }
        return returnValue;
    }
}