package ch.juventus.se.problemstofix.person;

import java.time.LocalDate;


public class Person {

    public enum Sex { MALE, FEMALE }

    private String firstName;
    private String lastName;
    private LocalDate birthday;
    private Address address;
    private Double balance;
    private Sex sex;
    private Boolean hasKids;

    public Person(String firstName, String lastName, LocalDate birthday, Address address, Double balance, Sex sex, Boolean hasKids) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.address = address;
        this.balance = balance;
        this.sex = sex;
        this.hasKids = hasKids;
    }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Person(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public Boolean getHasKids() {
        return hasKids;
    }

    public void setHasKids(Boolean hasKids) {
        this.hasKids = hasKids;
    }

}
