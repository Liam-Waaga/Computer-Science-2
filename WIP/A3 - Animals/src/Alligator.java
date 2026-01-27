import java.util.Optional;

public class Alligator extends Reptile {

    private double peopleEaten;
    protected double MAX_AGE() {return 60;}
    protected double MATURE_AGE() {return 15;}
    protected double MATURE_WEIGHT() {return 400;}
    protected double BABY_WEIGHT() {return 0.75;}

    public Alligator(double age, String name, String sex) {
        super("Alligator", age, name, sex);
        double weight = 0;
        if (age < MATURE_AGE()) {
            weight = (MATURE_WEIGHT() - BABY_WEIGHT()) / MATURE_AGE() + BABY_WEIGHT();
        } else {
            weight = MATURE_WEIGHT();
        }
        peopleEaten = 0;
        this.setWeight(weight);
        if (MAX_AGE() < age)
            die();
    }

    public void chomp() {
        System.out.printf("Chomp");
        peopleEaten += 0.5;
    }

    public String toString() {
        return super.toString() + " which has eaten " + peopleEaten + " people";
    }

    public Optional<Animal> bread(Animal other, String name) {
        if (other.getClass().equals(this.getClass())) {
            if (other.getSex().equals("Male") || this.getSex().equals("Male")) {
                if (other.getSex().equals("Female") || this.getSex().equals("Female")) {
                    if (other.isAdult() && this.isAdult()) {
                        return Optional.of(new Alligator(0, name, (Math.random() > .5) ? "Male" : "Female"));
                    }
                }
            }
        }
        return Optional.empty();
    }

    public void ageUp() {
        this.setAge(this.getAge() + 1);
        if (MAX_AGE() < getAge())
            die();
    }
}
