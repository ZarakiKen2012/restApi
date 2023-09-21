package spingBootSecurityRest.restApi.service;



import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spingBootSecurityRest.restApi.model.Person;
import spingBootSecurityRest.restApi.repositories.PeopleRepository;

import java.util.List;
import java.util.Optional;


@Service
public class PersonServiceImpl implements PersonService {

    private final PeopleRepository peopleRepository;
    @Autowired
    public PersonServiceImpl(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    @Transactional
    @Override
    public void addNewPerson(Person person) {
        peopleRepository.save(person);
    }

    @Override
    public Person getPersonById(int id) { return peopleRepository.getById(id); }

    @Override
    @Transactional
    public Optional<Person> getPersonByName(String name){
        Optional<Person> optionalPerson = peopleRepository.findByFirstName(name);
        Hibernate.initialize(optionalPerson.get().getRoles());
        return optionalPerson;
    }
    @Override
    public List<Person> getAllPersons() { return peopleRepository.findAll(); }

    @Transactional
    @Override
    public void changePersonById(Person person) { peopleRepository.save(person); }

    @Transactional
    @Override
    public void deletePersonById(int id){ peopleRepository.deleteById(id); }
}
