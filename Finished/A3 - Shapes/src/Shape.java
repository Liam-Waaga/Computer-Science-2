
public interface Shape {

    /*
     * Must return the number of "units" contained
     * if it is a 2d shape, then it is area, if it is 3d then it is volume
     */
    public double volume();
    public int numSides();
    public Point getPosition();
    public void setPosition(Point position);
    public String getName();
}