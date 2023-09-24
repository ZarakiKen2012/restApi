package spingBootSecurityRest.restApi.service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spingBootSecurityRest.restApi.model.Person;
import spingBootSecurityRest.restApi.repositories.PersonRepository;

import java.util.List;
import java.util.Optional;


@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Transactional
    @Override
    public void addNewPerson(Person person) {
        personRepository.save(person);
    }

    @Override
    public Person getPersonById(int id) { return personRepository.getById(id); }

    @Override
    public Optional<Person> getPersonByName(String name){ return personRepository.findByFirstName(name); }
    @Override
    public List<Person> getAllPersons() { return personRepository.findAll(); }

    @Transactional
    @Override
    public void changePersonById(Person person) { personRepository.save(person); }

    @Transactional
    @Override
    public void deletePersonById(int id){ personRepository.deleteById(id); }
}
