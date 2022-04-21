package ch.juventus.se.problemstofix.bird;


import java.util.Objects;

public class Duck extends Bird{

    private boolean isHungry;

    public Duck(int age, double weight, boolean isHealthy, boolean isHungry) {
        super(age, weight, isHealthy);
        this.isHungry = isHungry;
    }

    public boolean isHungry() {
        return isHungry;
    }

    public void setHungry(boolean hungry) {
        isHungry = hungry;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Duck duck = (Duck) o;
        return isHungry == duck.isHungry;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), isHungry);
    }
}
