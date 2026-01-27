public abstract class Insect extends Animal {
    /* m/s */
    private double movementSpeed = 0;
    private boolean canFly = false;

    public Insect(String species, double age, String name, String sex, double weight, double movementSpeed, boolean canFly) {
        super(species, age, name, sex, weight);
        this.movementSpeed = movementSpeed;
        this.canFly = canFly;
    }

    public double getMovementSpeed() {
        return this.movementSpeed;
    }

    public void setMovementSpeed(double movementSpeed) {
        this.movementSpeed = movementSpeed;
    }

    public boolean canFly() {
        return this.canFly;
    }

    public void setCanFly(boolean canFly) {
        this.canFly = canFly;
    }

    public String toString() {
        return super.toString() + " which moves at " + this.movementSpeed + " and can" + (this.canFly ? "" : "'t") + "fly";
    }
}