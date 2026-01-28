import java.util.ArrayList;

public class ShapesTester {
    public static void main(String[] args) {
        ArrayList<Shape> shapes = new ArrayList<Shape>();
        shapes.add(new Circle(2));
        shapes.add(new Cube(4));
        shapes.add(new EquilateralTriangle(3.5));
        shapes.add(new RegularPolygon(7));
        shapes.add(new Sphere(3));
        shapes.add(new Square(8));
        shapes.add(new Tetrahedron(8));

        for (Shape shape : shapes) {
            System.out.println("Name: " + shape.getName() + " Volume: " + shape.volume() + " Numsides: " + shape.numSides() + " Point: " + shape.getPosition());
        }

    }
}
