package dao;

import entities.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

public class PersonDaoImpl implements PersonDao {

    private SessionFactory factory = HibernateUtil.getFactory();
    private Session session ;

    @Override
    public Person addPerson(Person person) throws Exception {

        try {
            if(session.isOpen())
                session = factory.getCurrentSession();
            else
                session = factory.openSession();
            session.beginTransaction();
            session.save(person);
            session.getTransaction().commit();
            return person;
        }catch (Exception exception){
            // save error => BD_Exception
            // save => log
            session.getTransaction().rollback();
            throw new Exception(person.getId()+" cannot be registered");
        }finally {
            session.close();
        }
    }

    @Override
    public Person updatePerson(Person person) throws Exception {
        try {
            if(session.isOpen())
                session = factory.getCurrentSession();
            else
                session = factory.openSession();
            session.beginTransaction();
            session.update(person);
            session.getTransaction().commit();
            return person;
        }catch (Exception exception){
            // save error => BD_Exception
            // save => log
            session.getTransaction().rollback();
            throw new Exception(person.getId()+" cannot be updated");
        }finally {
            session.close();
        }
    }

    @Override
    public Person deletePerson(Person person) throws Exception {
        try {
            if(session.isOpen())
                session = factory.getCurrentSession();
            else
                session = factory.openSession();
            session.beginTransaction();
            session.delete(person);
            session.getTransaction().commit();
            return person;
        }catch (Exception exception){
            // save error => BD_Exception
            // save => log
            session.getTransaction().rollback();
            throw new Exception(person.getId()+" cannot be deleted");
        }finally {
            session.close();
        }
    }

    @Override
    public Person getPerson(Long id) throws Exception {
        Person person = null ;
        try {
            if(session.isOpen())
                session = factory.getCurrentSession();
            else
                session = factory.openSession();
            session.beginTransaction();
            person = session.get(Person.class, id);
            session.getTransaction().commit();
            return person;
        }catch (Exception exception){
            // save error => BD_Exception
            // save => log
            session.getTransaction().rollback();
            throw new Exception(person.getId()+" not found");
        }finally {
            session.close();
        }
    }

    @Override
    public List<Person> getAll() throws Exception {

        List<Person> people = new ArrayList<>();
        try {
            if(session.isOpen())
                session = factory.getCurrentSession();
            else
                session = factory.openSession();
            session.beginTransaction();
            people = session.createQuery("from Person p", Person.class).getResultList();
            session.getTransaction().commit();
            return people;
        }catch (Exception exception){
            // save error => BD_Exception
            // save => log
            session.getTransaction().rollback();
            throw new Exception("Error");
        }finally {
            session.close();
        }

        return null;
    }
}
