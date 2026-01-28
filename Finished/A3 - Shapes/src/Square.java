
public class Square extends RegularPolygon {
    
    public Square() {
        super(4);
    }

    public Square(double sideLength) {
        super(4, sideLength);
    }
    
    public Square(double sideLength, Point position) {
        super(4, sideLength, position);
    }

    public double volume() {
        return getSideLength() * getSideLength();
    }

    public String getName() {
        return "Square";
    }
}