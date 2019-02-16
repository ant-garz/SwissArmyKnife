import java.net.URL;
import java.net.URLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class HttpRequestIndex {
    protected String requestURL;
    protected ArrayList<String> urlContent;
    protected ArrayList<String> urlsFound;
    
    //default constructor
    HttpRequestIndex() {
        requestURL = "";
        urlContent = new ArrayList<String>();
    }

    HttpRequestIndex(String urlIn) {
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
            URLConnection myURLConnection = myURL.openConnection();
            BufferedReader readerIn = new BufferedReader(new InputStreamReader(myURLConnection.getInputStream()));
            String inputLine;
            while ((inputLine = readerIn.readLine()) != null) {
                System.out.println(inputLine);
                //parse main file and look for "http" inside the content to identify and store additonal URLs in order to make requests to them down the line.
                String[] elements = inputLine.split("\"");
                if (elements.length > 1) {
                    if (elements[11].indexOf("http") > -1) {
                        System.out.println("Element 11:" + elements[11]);
                        urlsFound.add(elements[11]);
                        returnValue = true;
                    }
                }
            }
            readerIn.close();
        }
        catch (Exception e) {
            returnValue = false;
            System.out.println("Invalid URL. Please try again.");
        }
        
        return returnValue;
    }

    public Boolean additonalURLRequests() {
        Boolean returnValue = true;
        for (String s : urlsFound) {
            HttpRequest additionalRequest = new HttpRequest(s);
            if (additionalRequest.readURL()) {
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

        System.out.println("Data from addtional URLs found on page:\n");
        for (String string : urlsFound) {
            returnValue = returnValue + string + "\n";
        }
        return returnValue;
    }
}