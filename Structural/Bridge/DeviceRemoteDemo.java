package Structural.Bridge;

/*
Think of remote controls and TVs:
Remote control = abstraction
TV = implementation

You can have different remotes for different TVs, without changing either class.
 */


/*
 * Implementor interface
 */
interface Device{
    void turnOn();
    void turnOff();
    void setVolume(int volume);
}
/*
 * Concrete Implementor
 */
class TV implements Device{

    @Override
    public void turnOn() {
        System.out.println("TV turn ON");
    }

    @Override
    public void turnOff() {
        System.out.println("TV turn OFF");
    }

    @Override
    public void setVolume(int volume) {
        System.out.println("TV volume set to " + volume);
    }
}

class Radio implements Device{

    @Override
    public void turnOn() {
        System.out.println("Radio turn ON");
    }

    @Override
    public void turnOff() {
        System.out.println("Radio turn OFF");
    }

    @Override
    public void setVolume(int volume) {
        System.out.println("Radio volume set to " + volume);
    }
}

/*
 * Abstraction : holds a reference to a Device
 */
abstract class RemoteControl{
    protected Device device;
    public RemoteControl(Device device){
        this.device = device;
    }
    public abstract void turnOn();
    public abstract void turnOff();
    public abstract void volumeUp();
}

/*
 * Refined Abstraction
 */
class BasicRemote extends RemoteControl{
    private int volume = 10;
    public BasicRemote(Device device){
        super(device);
    }

    @Override
    public void turnOn() {
        device.turnOn();
    }

    @Override
    public void turnOff() {
        device.turnOff();
    }

    @Override
    public void volumeUp() {
        volume++;
        device.setVolume(volume);
    }
}


public class DeviceRemoteDemo {
    public static void main(String[] args){
        //Basic remote with TV
        RemoteControl tvRemote = new BasicRemote(new TV());
        tvRemote.turnOn();
        tvRemote.volumeUp();
        tvRemote.turnOff();

        RemoteControl radioRemote = new BasicRemote(new Radio());
        radioRemote.turnOn();
        radioRemote.volumeUp();
        radioRemote.turnOff();
    }
}
