
/*
 * subject interface
 * common interface for both realImage and proxy image
 */

interface Image{
    void display();
}

/*
 * Real Image
 * This is actual heavy object that loads from disk
 */
class RealImage implements Image{
    private String filename;

    public RealImage(String filename){
        this.filename = filename;
        loadFromDisk(); //simulating a heavy operation
    }

    private void loadFromDisk(){
        System.out.println("Loading image from disk: " + filename);
    }

    @Override
    public void display() {
        System.out.println("Displaying image: " + filename);
    }
}

/*
 * proxy
 * proxy controls loading of image when needed (lazy loading)
 */

class ProxyImage implements Image{
    private RealImage realImage;
    private String filename;

    public ProxyImage(String filename){
        this.filename = filename;
    }

    @Override
    public void display() {
        if(realImage == null){
            realImage = new RealImage(filename);
        }
        realImage.display();
    }
}

/*
 * Client
 */

public class LazyLoadingImageDemo {
    public static void main(String[] args){
        Image image = new ProxyImage("photo.png");

        //Image not loaded yet
        System.out.println("First call to display: ");
        image.display();

        System.out.println("\n second call to dispaly: ");
        image.display();
    }
}
