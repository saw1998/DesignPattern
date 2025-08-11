package Creational.AbstractFactory;

interface Chair{
    void sit();
}

interface Sofa{
    void relax();
}

class VictorianChair implements Chair{
    @Override
    public void sit(){
        System.out.println("Sitting on Victorian Chair");
    }
}

class ModernChair implements Chair{
    @Override
    public void sit(){
        System.out.println("Sitting on Modern Chair");
    }
}

class VictorianSofa implements Sofa{
    @Override
    public void relax(){
        System.out.println("Relaxing on Victorian Sofa");
    }
}

class ModernSofa implements Sofa{
    @Override
    public void relax(){
        System.out.println("Relaxing on Modern Sofa");
    }
}

interface FurnitureFactory{
    Chair createChair();
    Sofa createSofa();
}

class VictorianFactory implements FurnitureFactory {
    @Override
    public Chair createChair(){
        return new VictorianChair();
    }

    @Override
    public Sofa createSofa(){
        return new VictorianSofa();
    }
}

class ModernFactory implements FurnitureFactory{
    @Override
    public Chair createChair(){
        return new ModernChair();
    }

    @Override
    public Sofa createSofa(){
        return new ModernSofa();
    }
}


public class AbstractFactoryDemo {
    public static void main(String[] args){
        FurnitureFactory factory = new VictorianFactory();
        Chair chair = factory.createChair();
        chair.sit();
    }    
}


/*
 * ✅ Interview note: Abstract Factory is like a Factory of Factories.
 */