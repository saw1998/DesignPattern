interface Shape{
	void draw();
}

class Circle implements	Shape{
	@Override
	public void draw(){
		System.out.println("Drawing Cirle"); 
	}
}

class Square implements	Shape{
	@Override	
	public void draw(){
		System.out.println("Drawing Square");
	}
}

class ShapeFactory{
	public Shape getShape(String type){
		if(type == "Circle") return new Circle();
		else if(type == "Square") return new Square();
		return null;
	}
}

public class FactoryPatternDemo{
	public static void main(String [] args) {
		System.out.println("Inside main method of FactoryPatternDemo");
		ShapeFactory factory = new ShapeFactory();
		Shape shape = factory.getShape("Circle");
		shape.draw(); // Drawing Circle
		Shape shape2 = factory.getShape("Square");
		shape2.draw(); // Drawing Square
	}
}