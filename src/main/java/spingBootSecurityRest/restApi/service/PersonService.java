package spingBootSecurityRest.restApi.service;





import spingBootSecurityRest.restApi.model.Person;

import java.util.List;
import java.util.Optional;

public interface PersonService {
    void addNewPerson(Person person);
    Person getPersonById(int id);
    Optional<Person> getPersonByName(String name);
    public List<Person> getAllPersons();
    void changePersonById(Person person);
    void deletePersonById(int id);
}
