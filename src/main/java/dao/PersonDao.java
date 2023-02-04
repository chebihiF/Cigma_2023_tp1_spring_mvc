package dao;

import entities.Person;

import java.util.List;

public interface PersonDao {
    public Person addPerson(Person person) throws Exception; //C
    public Person updatePerson(Person person) throws Exception; //U
    public Person deletePerson(Person person) throws Exception; // D
    public Person getPerson(Long id) throws Exception; //R
    public List<Person> getAll() throws Exception; //R

}
