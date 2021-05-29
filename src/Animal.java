import java.util.Objects;

public class Animal {

    enum Kind {
        BIRD, FISH, MAMMAL, REPTILE, AMPHIBIAN
    }

    private final String name;
    private final Kind kind;
    private int age;
    private final double weight;
    private final double maxSpeed;

    public Animal(String name, Kind kind, int age, double weight, double maxSpeed) {
        this.name = name;
        this.kind = kind;
        this.age = age;
        this.weight = weight;
        this.maxSpeed = maxSpeed;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Kind getKind() {
        return kind;
    }

    public int getAge() {
        return age;
    }

    public double getWeight() {
        return weight;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return age == animal.age && Double.compare(animal.weight, weight) == 0 && Double.compare(animal.maxSpeed, maxSpeed) == 0 && Objects.equals(name, animal.name) && kind == animal.kind;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, kind, age, weight, maxSpeed);
    }

    @Override
    public String toString() {
        return "\n" + name + " is a " + kind +" (age: " + age + ", weight: " + weight + ", max speed: " + maxSpeed + ")";
    }
}
