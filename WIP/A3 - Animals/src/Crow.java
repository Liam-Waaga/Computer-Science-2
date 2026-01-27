import java.util.Optional;

public class Crow extends Bird {
    
    protected double MAX_AGE() {return 25;}
    protected double MATURE_AGE() {return 2;}
    protected double MATURE_WEIGHT() {return 1500;}
    protected double BABY_WEIGHT() {return 35;}

    public Crow(double age, String name, String sex) {
        super("Crow", age, name, sex, 22);
    }

    public Optional<Animal> bread(Animal other, String name) {
        if (other.getClass().equals(this.getClass())) {
            if (other.getSex().equals("Male") || this.getSex().equals("Male")) {
                if (other.getSex().equals("Female") || this.getSex().equals("Female")) {
                    return Optional.of(new Crow(0, name, (Math.random() >= .5) ? "Male" : "Female"));
                }
            }
        }
        return Optional.empty();
    }
}
