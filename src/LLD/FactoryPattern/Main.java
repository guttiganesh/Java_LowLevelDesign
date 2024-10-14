package LLD.FactoryPattern;

public class Main {
    public static void main(String[] args){
        ShapeFactory shapeFactory = new ShapeFactory();
        Shape shape = shapeFactory.getShape("SQUARE");
        shape.draw();
    }
}
