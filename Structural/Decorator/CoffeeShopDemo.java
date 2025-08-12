package Structural.Decorator;

/*
 * Component interface - all coffee types (plain or decorated)
 */
interface Coffee{
    String getDescription();
    double getCost();
}

/*
 * Concrete component - plain coffee with no extras
 */
class SimpleCoffee implements Coffee{

    @Override
    public String getDescription() {
        return "Simple Coffee";
    }

    @Override
    public double getCost() {
        return 2.0; //base price
    }
}

/*
 * Decorator : base wrapper class
 * It implements Coffee so that decorators can be used anywhere coffee is expected
 */
abstract class CoffeeDecorator implements Coffee{
    protected Coffee decoratedCoffee;

    public CoffeeDecorator(Coffee coffee){
        this.decoratedCoffee = coffee;
    }

    @Override
    public String getDescription(){
        return decoratedCoffee.getDescription(); //delegate to wrapped object
    }

    @Override
    public double getCost(){
        return decoratedCoffee.getCost(); //delegate to wrapped object
    }
}

/*
 * Concrete decorators
 */
class MilkDecorator extends CoffeeDecorator{
    public MilkDecorator(Coffee coffee){
        super(coffee);
    }

    @Override
    public String getDescription(){
        return super.getDescription() + ", Milk";
    }

    @Override
    public double getCost(){
        return super.getCost() + 0.5;
    }
}

class SugarDecorator extends CoffeeDecorator{
    public SugarDecorator(Coffee coffee){
        super(coffee);
    }

    @Override
    public String getDescription(){
        return super.getDescription() + ", Sugar";
    }

    @Override
    public double getCost(){
        return super.getCost() + 0.2;
    }
}

class WippedCreamDecorator extends CoffeeDecorator {
    public WippedCreamDecorator(Coffee coffee){
        super(coffee);
    }

    @Override
    public String getDescription(){
        return super.getDescription() + ", Wipped Cream";
    }

    @Override
    public double getCost(){
        return super.getCost() + 0.7;
    }
}

/*
 * Client
 */
public class CoffeeShopDemo {
    public static void main(String[] args){
        //Start with simple coffee
        Coffee coffee = new SimpleCoffee();
        System.out.println(coffee.getDescription() + " $" + coffee.getCost());

        //Add Milk
        coffee = new MilkDecorator(coffee);
        System.out.println(coffee.getDescription() + " $" + coffee.getCost());

        //Add Sugar
        coffee = new SugarDecorator(coffee);
        System.out.println(coffee.getDescription() + " $" + coffee.getCost());

        //Add wipped cream
        coffee = new WippedCreamDecorator(coffee);
        System.out.println(coffee.getDescription() + " $" + coffee.getCost());

    }
}
