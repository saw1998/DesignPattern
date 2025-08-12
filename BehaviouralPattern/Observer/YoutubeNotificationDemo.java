package BehaviouralPattern.Observer;

import java.util.ArrayList;
import java.util.List;

/*
 * Observer interface - al the observers must implement this
 */
interface Subscriber{
    void update(String videoTitle);
}

/*
 * Concrete observer representing Subscriber
 */
class User implements Subscriber{
    private String name;

    public User(String name){
        this.name = name;
    }

    @Override
    public void update(String videoTitle){
        System.out.println("Hey " + name + ", new video uploaded: " + videoTitle);
    }
}

/*
 * Subject interface - defines metods to attach/detach observers
 */
interface Channel{
    void subscribe(Subscriber subscriber);
    void unsuscribe(Subscriber subscriber);
    void notifySubscribers(String videoTitle);
}

/*
 * Concrete class
 */
class YoutubeChannel implements Channel{
    private List<Subscriber> subscribers;
    private String channelName;

    public YoutubeChannel(String channelName){
        this.channelName = channelName;
        subscribers = new ArrayList<>();
    }


    @Override
    public void subscribe(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    @Override
    public void unsuscribe(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    @Override
    public void notifySubscribers(String videoTitle) {
        for(Subscriber subscriber : subscribers){
            subscriber.update(videoTitle);
        }
    }

    public void uploadVideo(String videoTitle){
        System.out.println("Uploading video : " + videoTitle + " to channel:" + channelName);
        notifySubscribers(videoTitle);
    }
}

/*
 * Client
 */

public class YoutubeNotificationDemo {
    public static void main(String[] args){
        Subscriber user1 = new User("John");
        Subscriber user2 = new User("Monty");
        Subscriber user3 = new User("Canta");

        YoutubeChannel parkar = new YoutubeChannel("Apna parkar");
        YoutubeChannel kagar = new YoutubeChannel("Tisra kagar");

        parkar.subscribe(user1);
        parkar.subscribe(user2);
        kagar.subscribe(user3);

        parkar.uploadVideo("Parker Video 1");
        kagar.uploadVideo("Mera Naya video");
    }
}
