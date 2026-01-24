import java.lang.Math;

public class RegularPolygon implements Shape {
    private double sideLength;
    private Point position;

    private final int numSides;

    public RegularPolygon(int numSides) {
        if (numSides < 3) numSides = 3;
        this.numSides = numSides;
        this.sideLength = 1;
        this.position = new Point(new double[] {0,0});
    }
    
    public RegularPolygon(int numSides, double sideLength) {
        if (numSides < 3) numSides = 3;
        this.numSides = numSides;
        this.sideLength = sideLength;
        this.position = new Point(new double[] {0,0});
    }
    
    public RegularPolygon(int numSides, double sideLength, Point position) {
        if (numSides < 3) numSides = 3;
        this.numSides = numSides;
        this.sideLength = sideLength;
        this.position = position;
    }

    public double volume() {
        double area;
        double triangleArea = sideLength * sideLength / Math.tan(Math.PI / numSides) / 4;
        return triangleArea * numSides;
    }

    public int numSides() {
        return numSides;
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    public double getSideLength() {
        return sideLength;
    }

    public void setSideLength(double sideLength) {
        this.sideLength = sideLength;
    }

}