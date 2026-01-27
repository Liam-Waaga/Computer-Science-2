import java.lang.Math;
import java.util.Optional;

public class Bee extends Insect {

    protected double MAX_AGE() {return 1/2;}
    protected double MATURE_AGE() {return 0;}
    protected double MATURE_WEIGHT() {return 0.000113;}
    protected double BABY_WEIGHT() {return MATURE_WEIGHT();}

    public Bee(String name) {
        super("Bee", 0, name, "female", 8, true);

        String sex;
        double age;
        double rand;
        if ((rand = Math.random()) > 1 - 1/50000) {
            sex = "Queen";
            age = Math.random() * 5;
        } else if (rand > 0.95) {
            sex = "Male";
            age = Math.random() * 0.2;
        } else {
            sex = "Female";
            age = Math.random() * 0.15;
        }

        super.setAge(age);
        super.setSex(sex);
        super.setWeight(MATURE_WEIGHT());
    }

    public Bee(String name, String sex, double age) {
        super("Bee", age, name, sex, 8, true);
        if (age > MAX_AGE())
            die();
        setWeight(MATURE_WEIGHT());
    }

    public Optional<Animal> bread(Animal other, String name) {
        if (other.getClass().equals(this.getClass())) {
            if (other.getSex().equals("Male") || this.getSex().equals("Male")) {
                if (other.getSex().equals("Queen") || this.getSex().equals("Queen")) {
                    return Optional.of(new Bee(name));
                }
            }
        }
        return Optional.empty();
    }

    public void ageUp() {
        setAge(getAge() + 1/52);
        if (getAge() > MAX_AGE())
            die();
    }
}
