
public class Circle implements Shape {
    
    private double radius;
    private Point center;
    
    public Circle() {
        this.radius = 1;
        this.center = new Point(new double[] {0,0});
    }
    
    public Circle(double radius) {
        this.radius = radius;
        this.center = new Point(new double[] {0,0});
    }

    public Circle(double radius, Point center) {
        this.radius = radius;
        this.center = center;
    }

    public double volume() {
        return radius * radius * Math.PI;
    }

    public int numSides() {
        return ~0;
    }

    public Point getPosition() {
        return center;
    }

    public void setPosition(Point center) {
        this.center = center;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double sideLength) {
        this.radius = sideLength;
    }
}