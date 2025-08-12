package Structural.Facade;

/*
 * Subsystem 1
 */
class DVDPlayer {
    public void on() {System.out.println("DVD Player ON");}
    public void play(String movie) {System.out.println("Playing movie :" + movie);}
    public void stop() {System.out.println("DVD Player Stopped");}
    public void off() {System.out.println("DVD Player OFF");}
}

/*
 * Subsystem 2
 */
class Projector{
    public void on() {System.out.println("Projector ON");}
    public void wideScreenMode() {System.out.println("Projector in wide screen mode");}
    public void off() {System.out.println("Projector OFF");}
}

/*
 * Subsystem 3
 */
class SurroundSoundSystem{
    public void on(){System.out.println("Surround Sound ON");}
    public void setVolume(int level){System.out.println("Volume set to: " + level);}
    public void off(){System.out.println("Surround Sound OFF");}
}

/*
 * Facade class
 * It hides the complexity of multiple Subsystem
 */

class HomeTheaterFacade{
    private DVDPlayer dvd;
    private Projector projector;
    private SurroundSoundSystem sound;

    public HomeTheaterFacade(DVDPlayer dvd, Projector projector, SurroundSoundSystem sound){
        this.dvd = dvd;
        this.projector = projector;
        this.sound = sound;
    }

    //simplified method to watch a movie
    public void  watchMovie(String movie){
        System.out.println("Get ready to watch a movie...");
        projector.on();
        projector.wideScreenMode();
        sound.on();
        sound.setVolume(8);
        dvd.on();
        dvd.play(movie);
    }

    //simplified method to end movie
    public void endMovie(){
        System.out.println("Shutting movie theater down...");
        dvd.stop();
        dvd.off();
        sound.off();
        projector.off();
    }
}

/*
 * Client
 */
public class HomeTheaterDemo {
    public static void main(String[] args){
        DVDPlayer dvd = new DVDPlayer();
        Projector projector = new Projector();
        SurroundSoundSystem sound = new SurroundSoundSystem();

        HomeTheaterFacade homeTheaterFacade = new HomeTheaterFacade(dvd, projector, sound);

        //Client uses on this two method
        homeTheaterFacade.watchMovie("Hulk");
        homeTheaterFacade.endMovie();
    }
    
}
