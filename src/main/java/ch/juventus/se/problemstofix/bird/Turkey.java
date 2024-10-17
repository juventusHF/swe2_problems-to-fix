package ch.juventus.se.problemstofix.bird;


import java.util.Objects;

public class Turkey extends Bird {

    private final String color;

    public Turkey(int age, double weight, boolean isHealthy, String color) {
        super(age, weight, isHealthy);
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Turkey turkey = (Turkey) o;
        return Objects.equals(color, turkey.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), color);
    }
}
