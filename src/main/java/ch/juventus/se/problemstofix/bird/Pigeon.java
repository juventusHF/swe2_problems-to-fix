package ch.juventus.se.problemstofix.bird;


import java.util.Objects;

public class Pigeon extends Bird {

    private String name;

    public Pigeon(int age, double weight, boolean isHealthy, String name) {
        super(age, weight, isHealthy);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Pigeon pigeon = (Pigeon) o;
        return Objects.equals(name, pigeon.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name);
    }
}
