import java.util.Optional;

public class Salmon extends Fish {
    protected double MAX_AGE() {return 10;}
    protected double MATURE_AGE() {return 2;}
    protected double MATURE_WEIGHT() {return 4;}
    protected double BABY_WEIGHT() {return 0.05;}


    public Salmon(double age, String name, String sex) {
        super("Salmon", age, name, sex, 9);
        double weight = 0;
        if (age < MATURE_AGE()) {
            weight = (MATURE_WEIGHT() - BABY_WEIGHT()) / MATURE_AGE() + BABY_WEIGHT();
        } else {
            weight = MATURE_WEIGHT();
        }
        this.setWeight(weight);
        if (MAX_AGE() < age)
            die();
    }

    public Optional<Animal> bread(Animal other, String name) {
        if (other.getClass().equals(this.getClass())) {
            if (other.getSex().equals("Male") || this.getSex().equals("Male")) {
                if (other.getSex().equals("Female") || this.getSex().equals("Female")) {
                    if (other.isAdult() && this.isAdult()) {
                        return Optional.of(new Salmon(0, name, (Math.random() >= .5) ? "Male" : "Female"));
                    }
                }
            }
        }
        return Optional.empty();
    }
    
}
