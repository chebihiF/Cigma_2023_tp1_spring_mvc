package metier;

import dao.PersonDao;
import entities.Person;

import java.util.List;

public class PersonMetierImpl implements PersonMetier {

    private PersonDao dao ; // null

    public void setDao(PersonDao dao) {
        this.dao = dao;
    }

    @Override
    public Person subscribe(Person person) throws Exception {
        if(!person.getEmail().contains("@gmail.com"))
            throw new Exception("email not authorized");

        return dao.addPerson(person);
    }

    @Override
    public Person editProfile(Person person) throws Exception {
        // code BL
        return dao.updatePerson(person);
    }

    @Override
    public Person deletePerson(Person person) throws Exception {
        // ...
        return dao.deletePerson(person);
    }

    @Override
    public Person getPerson(Long id) throws Exception {
        return dao.getPerson(id);
    }

    @Override
    public List<Person> getAll() throws Exception {
        return dao.getAll();
    }
}
