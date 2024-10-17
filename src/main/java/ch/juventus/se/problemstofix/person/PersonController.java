package ch.juventus.se.problemstofix.person;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;


public class PersonController {

    public List<Person> removeAllLindas (List<Person> people) {
        Iterator<Person> iterator = people.iterator();
        while (iterator.hasNext()) {
            Person person = iterator.next();
            if(person.getFirstName().equals("Lina")) {
                iterator.remove();
            }
        }
        return people;
    }

    public List<Person> removeAllUnderage (List<Person> people) {

        LocalDate today = LocalDate.now();

        for(Person person : people) {
            if(person.getBirthday().isAfter(today.minusYears(18))) {
                people.remove(person);
            }
        }

        return people;
    }

    public List<Person> removeAllWitLetterAInName(List<Person> people) {

        Iterator<Person> iterator = people.iterator();
        while (iterator.hasNext()) {
            if(iterator.next().getLastName().toLowerCase().startsWith("a")) {
                iterator.remove();
            }
        }

        return people;
    }
}
