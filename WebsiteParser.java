package HttpObserver;

/**
 *
 * @author re
 */
public class WebsiteParser  {

    public static void main (String[] args) {
        //Subject object
        WebsiteGrabber websiteGrabber = new WebsiteGrabber();
        
        WebsiteObserver websiteObserver1 = new WebsiteObserver(websiteGrabber);
        
        /* pretend that we are parsing websites */
        // and finally we found searched word on given website
        websiteGrabber.setWebsiteWhichWasChanged(
                "http://fajna/strona/com", "niemożliw", "dzisiaj");
        
        WebsiteObserver websiteObserver2 = new WebsiteObserver(websiteGrabber);
        
        websiteGrabber.setWebsiteWhichWasChanged(
                "http://ADAS/strona/com", "piwnica", "jutro");
    }
}