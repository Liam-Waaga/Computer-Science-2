public class Tetrahedron implements PlatonicSolid {
    private double sideLength;
    private Point position;

    public Tetrahedron() {
        this.sideLength = 1;
        this.position = new Point(new double[] {0,0});
    }
    
    public Tetrahedron(double sideLength) {
        this.sideLength = sideLength;
        this.position = new Point(new double[] {0,0});
    }

    public Tetrahedron(double sideLength, Point position) {
        this.sideLength = sideLength;
        this.position = position;
    }

    public int numSides() {
        return 4;
    }

    public double sideLength() {
        return this.sideLength;
    }

    public Point getPosition() {
        return this.position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    public String name() {
        return "Tetrahedron";
    }

    public RegularPolygon side() {
        return new RegularPolygon(3, sideLength);
    }

    public double volume() {
        return this.sideLength * this.sideLength * this.sideLength * Math.sqrt(2) / 12;
    }
}