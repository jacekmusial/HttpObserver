package HttpObserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author re
 */
public class Main {
    private String websiteURL;
    private String searchWord;
    
    //ask user to type website&word for searching
    public void promptUser() {
        //blabla.. some msgbox2user
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try {
            this.websiteURL = in.readLine();
            this.searchWord = in.readLine();
        }catch (IOException e) {} //yep, it's bad idea
        
    }
    
    public static void main (String[] args) {
        //is there better way to handle threads&observers?
        WebsiteParser[] websiteParser = new WebsiteParser[2]; 
        websiteParser[0] = new WebsiteParser("http://onet.pl", "uczniów");
        websiteParser[1] = new WebsiteParser("https://github.com", "reposit");
        
        ScheduledExecutorService scheduler 
                = Executors.newScheduledThreadPool(2);
        
        for (WebsiteParser wp : websiteParser ) {
            scheduler.scheduleWithFixedDelay(wp, 2, 5, TimeUnit.MINUTES);
            wp.run();
        }
        
        /*final ScheduledFuture<?> websiteParserHandle;
        websiteParserHandle = scheduler.scheduleWithFixedDelay(
        websiteParser, 2, 5, TimeUnit.SECONDS); */
        
    }
}