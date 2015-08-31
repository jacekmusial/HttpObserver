package HttpObserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;
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
        
        WebsiteParser websiteParser;
        websiteParser = new WebsiteParser("http://onet.pl", "uczniów");
        
        ScheduledExecutorService scheduler;
        scheduler = Executors.newScheduledThreadPool(2);
        
        final ScheduledFuture<?> websiteParserHandle;
        //(try to) parse website 4 times in one minute
        websiteParserHandle = scheduler.scheduleWithFixedDelay(
                websiteParser, 2, 15, TimeUnit.SECONDS); 
    }
}