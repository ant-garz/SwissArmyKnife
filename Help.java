//This file is the class for Help method and is called in my sak file

class Help {
    public static void helpGuide() {

        //Guide to use Help Method
        System.out.println("\n***Call the Help Guide with this example below.\n");
        System.out.println("java sak -Help");

        //Guide to use HttpRequest Method
        System.out.println("\n***Use the HttpRequest Method by using the same formatting as the example below.\n");
        System.out.println("Formatting Example - - - - - - -");
        System.out.println("java sak -HttpRequest [URL]");
        System.out.println("Actual Use Example - - - - - - -");
        System.out.println("java sak -HttpRequest https://host-site-ag.azurewebsites.net/");

        //Guide to use HttpRequestIndex Method
        System.out.println("\n***Use the HttpRequestIndex Method by using the same formatting as the example below.\n");
        System.out.println("Formatting Example - - - - - - -");
        System.out.println("java sak -HttpRequestIndex [URL]");
        System.out.println("Actual Use Example - - - - - - -");
        System.out.println("java sak -HttpRequestIndex https://host-site-ag.azurewebsites.net/");     

        //empty line at end of help execution for formatting / clean console output
        System.out.println("");
    }
}