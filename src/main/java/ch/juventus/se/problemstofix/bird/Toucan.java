package ch.juventus.se.problemstofix.bird;


import java.util.Objects;

public class Toucan extends Bird {

    private final String habitat;

    public Toucan(int age, double weight, boolean isHealthy, String habitat) {
        super(age, weight, isHealthy);
        this.habitat = habitat;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Toucan toucan = (Toucan) o;
        return Objects.equals(habitat, toucan.habitat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), habitat);
    }
}
