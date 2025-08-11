package Structural.Bridge;

/*
 * Imagine we have 2 dimensions
 *  Shape (Circle, Square)
 *  Color (Red, Blue)
 * 
 * Note they do not depend on each other
 * So, Instead of making classes like RedCircle, BlueCircle, RedSquare, BlueSquare, we bridge them.
 */


/*
 * Implementor : Color Interface
 */
interface Color{
    void applyColor();
}

/*
 * Concrete Implementors
 */
class RedColor implements Color{
    @Override
    public void applyColor(){
        System.out.println("Applying Red Color");
    }
}
class BlueColor implements Color{
    @Override
    public void applyColor(){
        System.out.println("Applying Blue Color");
    }
}

/*
 * Abstraction : Shape
 */
abstract class Shape{
    protected Color color; //Bridge link

    public Shape(Color color){
        this.color = color;
    }

    abstract void draw();
}

/*
 * Refined Abstractions
 */
class Circle extends Shape{
    public Circle(Color color){
        super(color);
    }

    @Override
    void draw() {
        System.out.print("Drawing Circle with ");
        color.applyColor();
    }
}
class Square extends Shape{
    public Square(Color color){
        super(color);
    }
    @Override
    void draw(){
        System.out.print("Drawing Square with ");
        color.applyColor();
    }
}

/*
 * Client
 */

public class ShapeAndColorDemo {
    public static void main(String[] args){
        Shape redCircle = new Circle(new RedColor());
        Shape blueSquare = new Square(new BlueColor());

        redCircle.draw();
        blueSquare.draw();
    }
}

/*
Key Points for Interview
Difference from Adapter: Adapter makes two incompatible interfaces work together. Bridge separates abstraction from implementation.

Difference from Strategy: Strategy changes behavior at runtime, Bridge decouples abstraction from implementation hierarchy.

When not to use: If you have a stable abstraction and only one implementation.

Advantages:

Avoids class explosion

Abstraction and implementation evolve independently

Promotes composition over inheritance
 */