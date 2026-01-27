import java.util.Optional;

public abstract class Animal {
    private String name = "";
    private String species = "";
    /* years */
    private double age = 0;
    private String sex = "";
    /* kg */
    private double weight = 0;
    private boolean dead;

    protected abstract double MAX_AGE();
    protected abstract double MATURE_AGE();
    protected abstract double MATURE_WEIGHT();
    protected abstract double BABY_WEIGHT();

    public Animal(String species, double age, String name, String sex) {
        this.species = species;
        this.name = name;
        this.age = age;
        this.weight = 0;
        this.dead = false;
    }
    
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return this.species;
    }

    public double getAge() {
        return this.age;
    }

    public String getSex() {
        return this.sex;
    }

    public double getWeight() {
        return this.weight;
    }
    
    public String toString() {
        return this.sex + " " + this.species + " named " + this.name + " which weighs " + this.weight + "kg" + " and is " + (dead ? "" : "not ") + "dead";
    }
    
    public void die() {
        this.dead = true;
    }
    
    public boolean isAdult() {
        return getAge() >= MATURE_AGE();
    }

    public abstract Optional<Animal> bread(Animal other, String name);
    
    public void ageUp() {
        this.setAge(this.getAge() + 1);
        if (MAX_AGE() < getAge())
            die();
    }

    protected void setWeight(double weight) {
        this.weight = weight;
    }

    protected void setAge(double age) {
        this.age = age;
    }
    
    protected void setSex(String sex) {
        this.sex = sex;
    }

    protected void setSpecies(String species) {
        this.species = species;
    }
}