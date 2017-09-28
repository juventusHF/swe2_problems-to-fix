package ch.juventus.se.problemstofix.bird;

/**
 * @author: Linda Krüger
 * @since: 21.09.17
 */
public abstract class Bird {

    private int age;
    private double weight;
    private boolean isHeathy;
    private int id;

    public Bird(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public boolean isHeathy() {
        return isHeathy;
    }

    public void setHeathy(boolean heathy) {
        isHeathy = heathy;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
