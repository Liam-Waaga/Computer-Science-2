import java.lang.Math;

public class Bee extends Insect {
    
    public Bee(String name) {
        super("Bee", 0, name, "female", 0.0001, 8, true);

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
    }

    public Bee(String name, String sex, double age) {
        super("Bee", age, name, sex, age, 8, true);
    }
}
