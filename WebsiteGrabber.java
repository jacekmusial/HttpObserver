package HttpObserver;

import java.util.ArrayList;

/**
 *
 * @author re
 */

interface Subject {
    public void register(Observer o);
    public void unregister(Observer o);
    public void notifyObserver();
}

class WebsiteGrabber implements Subject{
    protected ArrayList<Observer> observers;
    private String websiteURL;
    private String searchWord;
    private String time;

    public WebsiteGrabber() {
        observers = new ArrayList<>();
    }
    
    @Override
    public void register(Observer o) {
        observers.add(o);
    }

    @Override
    public void unregister(Observer o) {
        int observerIndex = observers.indexOf(o);
        observers.remove(observerIndex);
    }

    @Override
    public void notifyObserver() {
        //notify all observers about the update
        observers.stream().forEach((observer) -> {
            observer.update(websiteURL, searchWord, time);
        });
    }
    
    public void setWebsiteWhichWasChanged(String websiteURL,
        String searchWord, String time) {
        this.websiteURL = websiteURL;
        this.searchWord = searchWord;
        this.time = time;
        notifyObserver();
    }
}