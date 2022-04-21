package ch.juventus.se.problemstofix.bird;


import java.util.Objects;

public abstract class Bird {

    private int age;
    private double weight;
    private boolean isHealthy;

    public Bird(int age, double weight, boolean isHealthy) {
        this.age = age;
        this.weight = weight;
        this.isHealthy = isHealthy;
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

    public boolean isHealthy() {
        return isHealthy;
    }

    public void setHealthy(boolean healthy) {
        isHealthy = healthy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bird bird = (Bird) o;
        return age == bird.age && Double.compare(bird.weight, weight) == 0 && isHealthy == bird.isHealthy;
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, weight, isHealthy);
    }
}
