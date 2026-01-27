public abstract class Bird extends Animal {

    private double flySpeed = 0;

    public Bird(String species, double age, String name, String sex, double flySpeed) {
        super(species, age, name, sex);
        this.flySpeed = flySpeed;
    }

    public double getFlySpeed() {
        return this.flySpeed;
    }

    public void setFlySpeed(double flyspeed) {
        this.flySpeed = flyspeed;
    }

    public String toString() {
        return super.toString() + " which can fly at " + this.flySpeed;
    }
}