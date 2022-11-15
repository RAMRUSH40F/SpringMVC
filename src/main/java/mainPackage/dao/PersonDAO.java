package mainPackage.dao;

import mainPackage.models.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Data access object.
 * Contains data itself for now.
 */
@Component
public class PersonDAO {

    private static int          PEOPLE_COUNT;
    private        List<Person> people;
    private        int          num;


    {
        people = new ArrayList<>();
        people.add(new Person(++PEOPLE_COUNT, "Tom",(byte) 55,"TomHolland@gmail.com"));
        people.add(new Person(++PEOPLE_COUNT, "Mike", (byte) 23, "MikeKrap@gmail.com"));
        people.add(new Person(++PEOPLE_COUNT, "Bob",(byte) 48,"ragfaegaww@aga.com"));
    }

    public void save(Person person) {
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }

    public List<Person> getPeople() {
        return people;
    }

    public Person show(int id) {
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public void update(int id, Person updatedPerson) {

        Person personTobeUpdated = show(id);
        personTobeUpdated.setName(updatedPerson.getName());
        personTobeUpdated.setEmail(updatedPerson.getEmail());
        personTobeUpdated.setAge(updatedPerson.getAge());

    }

    public void delete(int id) {
        people.removeIf(p -> p.getId() == id);
    }

}
