package HttpObserver;

/**
 *
 * @author re
 */

interface Observer {
    //this method'll be called when Subject changes
    public void update(String websiteURL, String searchWord, String time);
}

class WebsiteObserver implements Observer{
    /*private String websiteURL;
    private String searchWord;
    private String time;*/
    
    private Subject WebsiteGrabber;

    public WebsiteObserver(Subject WebsiteGrabber) {
        //store reference, so i can make calls
        //to its methods
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