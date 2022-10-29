package mainPackage.dao;

import mainPackage.models.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonDAO
{
    private static int PEOPLE_COUNT;
    private List<Person> people;
    private int num;

    {
        people = new ArrayList<>();
        people.add(new Person(++PEOPLE_COUNT,"Tom"));
        people.add(new Person(++PEOPLE_COUNT,"Mike"));
        people.add(new Person(++PEOPLE_COUNT,"Bob"));
    }

    public List<Person> index()
    {
        return people;
    }
    public  Person show(int id){
        return people.stream().filter(person -> person.getId()==id).findAny().orElse(null);
    }

}
