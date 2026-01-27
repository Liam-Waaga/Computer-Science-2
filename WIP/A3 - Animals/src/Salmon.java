import java.util.Optional;

public class Salmon extends Fish {

    public Salmon(double age, String name, String sex, double weight) {
        super("Salmon", age, name, sex, weight, 9);
    }

    public Optional<Animal> bread(Animal other, String name) {
        if (other.getClass().equals(this.getClass())) {
            if (other.getSex().equals("Male") || this.getSex().equals("Male")) {
                if (other.getSex().equals("Female") || this.getSex().equals("Female")) {
                    return Optional.of(new Salmon(0, name, (Math.random() >= .5) ? "Male" : "Female", 0.0002));
                }
            }
        }
        return Optional.empty();
    }
    
}
