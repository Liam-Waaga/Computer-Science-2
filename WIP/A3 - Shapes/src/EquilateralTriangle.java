
public class EquilateralTriangle extends RegularPolygon {


    public EquilateralTriangle() {
        super(3);
    }

    public EquilateralTriangle(double sideLength) {
        super(3, sideLength);
    }
    
    public EquilateralTriangle(double sideLength, Point position) {
        super(3, sideLength, position);
    }

    public double volume() {
        return getSideLength() * getSideLength() * Math.sqrt(3) / 4;
    }
}