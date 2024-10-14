package LLD.FactoryPattern;

public class ShapeFactory {
    public Shape getShape(String input){
        switch (input){
            case"RECTANGLE":
                return new Rectangle();
            case "SQUARE":
                return new Square();
            default:
                return null;
        }
    }
}
