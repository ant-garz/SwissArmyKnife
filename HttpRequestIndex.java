// //This file is the class for HttpRequestIndex method and is called in my sak file

import java.net.URL;
import java.net.URLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class HttpRequestIndex {
    protected String requestURL;
    protected ArrayList<String> urlContent;
    protected ArrayList<String> urlsFound;
    
    //default constructor
    HttpRequestIndex() {
        requestURL = "";
        urlContent = new ArrayList<String>();
        urlsFound = new ArrayList<String>();
    }

    HttpRequestIndex(String urlIn) {
        requestURL = urlIn;
        urlContent = new ArrayList<String>();
        urlsFound = new ArrayList<String>();
    }

    public Boolean readAllURL() {
        return readAllURL(requestURL);
    }

    public Boolean readAllURL(String urlIn) {
        requestURL = urlIn;
        Boolean returnValue = false; 
        try {
            URL myURL = new URL(requestURL);
            URLConnection myURLConnection = myURL.openConnection();
            BufferedReader readerIn = new BufferedReader(new InputStreamReader(myURLConnection.getInputStream()));
            String inputLine;
            while ((inputLine = readerIn.readLine()) != null) {
                urlContent.add(inputLine);
                //parse main file and look for "http" inside the content to identify and store additonal URLs in order to make requests to them down the line.
                //This uses regex to find a patter of URL with line below
                String regexUrlPattern = "\\b(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";

                Pattern urlPattern = Pattern.compile(regexUrlPattern);
                Matcher urlMatcher = urlPattern.matcher(inputLine);
                while (urlMatcher.find()){
                    urlsFound.add(urlMatcher.group());
                }
                returnValue = true;
            }
            readerIn.close();
        }
        catch (IOException e) {
            returnValue = false;
            System.out.println("Invalid URL. Please try again.");
        }
        
        return returnValue;
    }

    public Boolean additonalURLRequests() {
        Boolean returnValue = true;
        for (String s : urlsFound) {
            HttpRequestIndex additionalRequest = new HttpRequestIndex(s);
            if (additionalRequest.readAllURL()) {
                System.out.println(additionalRequest);
            } else {
                returnValue = false;
            }
        }
        return returnValue;
    }

    public String toString() {
        String returnValue = "URL: "+ requestURL + "\n";
        for (String string : urlContent) {
            returnValue = returnValue + string + "\n";
        }
        additonalURLRequests();
        return returnValue;
    }
}