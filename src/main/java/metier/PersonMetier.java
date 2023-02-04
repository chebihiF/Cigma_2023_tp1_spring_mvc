package metier;

import entities.Person;

import java.util.List;

public interface PersonMetier {
    Person subscribe(Person person) throws Exception;
    Person editProfile(Person person) throws Exception;
    Person deletePerson(Person person) throws Exception;
    public Person getPerson(Long id) throws Exception;
    public List<Person> getAll() throws Exception;
}
