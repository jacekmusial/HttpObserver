package HttpObserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author re
 */
final class WebsiteParser implements Runnable {
    private Thread taskThread;
    private String websiteURL;
    private String searchWord;
    private URL mainURL;
    private Boolean isDone;
    
    public boolean isValidURL(String url) {  
        URL u;

        try {  
            u = new URL(url);  
        } catch (MalformedURLException e) {  
            return false;  
        }
        
        try {  
            u.toURI();  
        } catch (URISyntaxException e) {  
            return false;  
        }  
        mainURL = u;
        return true;
    } 
    
    public WebsiteParser(String websiteURL, String searchWord) {
        this.isDone = false;
        
        if (isValidURL(websiteURL)) {
            this.websiteURL = websiteURL;
            this.searchWord = searchWord;
            this.run();
        }
        else {
            System.out.println("URL is incorrect. Exiting: -1");
            System.exit(-1);
        }
    }

    @Override
    public void run() {
      while(!isDone) { 
          isDone = true; // we can finish, our job is done
        if (websiteURL.length() <= 3 ||
            searchWord.length() <= 3 ) {
            System.err.println(".length of websiteURL OR searchWord is <= 3.");
            return;
        }
        WebsiteGrabber websiteGrabber = new WebsiteGrabber();
        WebsiteObserver websiteObserver1 = new WebsiteObserver(websiteGrabber);
       
        
        
        URLConnection yc;
        try {
            String inputLine;
            yc = mainURL.openConnection();
            
            try (BufferedReader in = new BufferedReader(new InputStreamReader(
            yc.getInputStream()))) {
                int counter = 0;
                System.out.println("?");         
                while ((inputLine = in.readLine()) != null) {
                    if (inputLine.contains(searchWord)) {
                        ++counter;
                        System.out.println(".");
                    }
                }
                if (counter > 0) {
                    Date date = Calendar.getInstance().getTime();
                    System.out.printf(
                        "%d matches on %s website, found at %s",
                        counter, this.websiteURL, date.toString()
                    );
                    
                }
            }
        } catch (IOException ex) {
            System.out.println("IOException: "+ ex.getMessage());
        }
        }
    }
}