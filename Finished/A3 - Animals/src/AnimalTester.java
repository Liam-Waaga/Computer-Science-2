import java.util.ArrayList;

public class AnimalTester {
    public static void main(String[] args) {
        ArrayList<Animal> animals = new ArrayList<Animal>();
        animals.add(new Bee("Buzz", "Queen", 0));
        animals.add(new Alligator(0, "Bob", "Male"));
        animals.add(new Crow(0, "Bob1", "Female"));
        animals.add(new Cow(0, "Betsy", "Female"));
        animals.add(new Crow(0, "George", "Male"));
        animals.add(new Salmon(0, "Mr. Salmon", "Male"));

        while (!animals.isEmpty()) {
            for (int i = 0; i < animals.size(); i++) {
                System.out.println(animals.get(i));
                animals.get(i).ageUp();
                
                /* remove dead animals */
                if (animals.get(i).isDead())
                    animals.remove(i);
            }
            System.out.println();
        }


    }
}
