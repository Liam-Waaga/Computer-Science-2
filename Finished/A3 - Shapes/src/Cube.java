
public class Cube implements PlatonicSolid {
    
    private double sideLength;
    private Point position;

    public Cube() {
        this.sideLength = 1;
        this.position = new Point(new double[] {0,0});
    }
    
    public Cube(double sideLength) {
        this.sideLength = sideLength;
        this.position = new Point(new double[] {0,0});
    }

    public Cube(double sideLength, Point position) {
        this.sideLength = sideLength;
        this.position = position;
    }

    public int numSides() {
        return 6;
    }

    public String name() {
        return "Cube";
    }

    public RegularPolygon side() {
        return new RegularPolygon(4, sideLength);
    }

    public Point getPosition() {
        return this.position;
    }

    public double volume() {
        return this.sideLength * this.sideLength * this.sideLength;
    }

    public double sideLength() {
        return this.sideLength;
    }

    public void setPosition(Point position) {
        this.position = position;
    }
}