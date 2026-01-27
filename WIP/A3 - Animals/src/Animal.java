public abstract class Animal {
    private String name = "";
    private String species = "";
    /* years */
    private double age = 0;
    private String sex = "";
    /* kg */
    private double weight = 0;

    public Animal(String species, double age, String name, String sex, double weight) {
        this.species = species;
        this.name = name;
        this.age = age;
        this.weight = weight;
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

    public void setAge(double age) {
        this.age = age;
    }

    public String getSex() {
        return this.sex;
    }

    public double getWeight() {
        return this.weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String toString() {
        return this.sex + " " + this.species + " named " + this.name + " which weighs " + this.weight + "kg";
    }

    protected void setSex(String sex) {
        this.sex = sex;
    }

    protected void setSpecies(String species) {
        this.species = species;
    }
}