public class Point {
    
    private double[] coordinates;


    public Point(int dimensions) {
        if (dimensions < 1)
            dimensions = 1;

        this.coordinates = new double[dimensions];

        for (int i = 0; i < dimensions; i++) {
            coordinates[i] = 0;
        }
    }

    public Point clone() {
        return new Point(this.coordinates);
    }

    public Point(double[] coordinates) {
        this.coordinates = new double[coordinates.length];
        for (int i = 0; i < coordinates.length; i++) {
            this.coordinates[i] = coordinates[i];
        }
    }

    public void dimUp(double newCoord) {
        double[] newCoords = new double[coordinates.length + 1];
        for (int i = 0; i < coordinates.length; i++)
            newCoords[i] = coordinates[i];
        newCoords[newCoords.length] = newCoord;
    }

    public void dimUp() {
        dimUp(0);
    }

    public boolean setCoord(int index, double val) {
        if (index < coordinates.length && index >= 0) {
            coordinates[index] = val;
            return true;
        }
        return false;
    }

}