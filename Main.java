package HttpObserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
        
        Random rand = new Random();
        /*ArrayList<WebsiteParser> websiteParser;
        websiteParser = new ArrayList<>(3);
        websiteParser.add(new WebsiteParser("asda"+rand.nextInt()+"asd",
        "zcx"));
        
        websiteParser.add(new WebsiteParser("XD"+rand.nextInt()+"asd",
        "x"));*/
        
        WebsiteParser websiteParser = new WebsiteParser(
                "http://powiatsuski24.pl", "sucha beskidzka");
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        
        final ScheduledFuture<?> websiteParserHandle;
        websiteParserHandle = scheduler.scheduleWithFixedDelay(
            websiteParser, 0, 1, TimeUnit.DAYS);
        if (websiteParserHandle.cancel(true)) {
            System.out.println("asda");
        }
 
       
    }
}