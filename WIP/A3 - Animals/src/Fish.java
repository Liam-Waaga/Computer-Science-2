public abstract class Fish extends Animal {

    private double swimSpeed = 0;

    public Fish(String species, double age, String name, String sex, double weight, double swimSpeed) {
        super(species, age, name, sex, weight);
        this.swimSpeed = swimSpeed;
    }

    public double getSwimSpeed() {
        return this.swimSpeed;
    }

    public void setSwimSpeed(double swimSpeed) {
        this.swimSpeed = swimSpeed;
    }

    public String toString() {
        return super.toString() + " that swims at " + this.swimSpeed;
    }
}