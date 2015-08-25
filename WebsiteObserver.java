package HttpObserver;

/**
 *
 * @author re
 */

interface Observer {
    //this method'll be called when Subject changes
    public void update(String websiteURL, String searchWord, String time);
}

public class WebsiteObserver implements Observer{
    /*private String websiteURL;
    private String searchWord;
    private String time;*/
    
    //global counter
    private static int observerIDTracker = 0;
    
    //its to track observers
    private int observerID;
    
    private Subject WebsiteGrabber;

    public WebsiteObserver(Subject WebsiteGrabber) {
        //store reference, so i can make calls
        //to its methods
        this.WebsiteGrabber = WebsiteGrabber;

        this.observerID = ++observerIDTracker;
        
        System.out.println("new observer: " + this.observerID);
        WebsiteGrabber.register(this);
    }
    
    @Override
    public void update(String websiteURL, String searchWord, String time) {
        /*this.websiteURL = websiteURL;
        this.searchWord = searchWord;
        this.time = time;*/
        System.out.printf("Found %s word on %s website, at %s time\n"  , 
                websiteURL, searchWord, time);
    }
}