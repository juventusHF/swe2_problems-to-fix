package ch.juventus.se.problemstofix.person;

import ch.juventus.se.problemstofix.person.Address;

import java.util.Date;

/**
 * @author: Linda Krüger
 * @since: 12.09.17
 */
public class Person {

    public enum Sex { MALE, FEMALE }

    private String firstName;
    private String lastName;
    private Date birthday;
    private Address address;
    private Double balance;
    private Sex sex;
    private Boolean hasKids;

    public Person(String firstName, String lastName, Date birthday, Address address, Double balance, Sex sex, Boolean hasKids) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.address = address;
        this.balance = balance;
        this.sex = sex;
        this.hasKids = hasKids;
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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
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

    // Solution
//    @Override
//    public String toString() {
//        return "Person{" +
//                "firstName='" + firstName + '\'' +
//                ", lastName='" + lastName + '\'' +
//                ", birthday=" + birthday +
//                ", address=" + address +
//                ", balance=" + balance +
//                ", sex=" + sex +
//                ", hasKids=" + hasKids +
//                '}';
//    }

    //Solution
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        Person person = (Person) o;
//
//        if (firstName != null ? !firstName.equals(person.firstName) : person.firstName != null) return false;
//        if (lastName != null ? !lastName.equals(person.lastName) : person.lastName != null) return false;
//        if (birthday != null ? !birthday.equals(person.birthday) : person.birthday != null) return false;
//        if (address != null ? !address.equals(person.address) : person.address != null) return false;
//        if (balance != null ? !balance.equals(person.balance) : person.balance != null) return false;
//        if (sex != person.sex) return false;
//        return hasKids != null ? hasKids.equals(person.hasKids) : person.hasKids == null;
//    }
//
//    @Override
//    public int hashCode() {
//        int result = firstName != null ? firstName.hashCode() : 0;
//        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
//        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
//        result = 31 * result + (address != null ? address.hashCode() : 0);
//        result = 31 * result + (balance != null ? balance.hashCode() : 0);
//        result = 31 * result + (sex != null ? sex.hashCode() : 0);
//        result = 31 * result + (hasKids != null ? hasKids.hashCode() : 0);
//        return result;
//    }
}
