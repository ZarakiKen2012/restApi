package spingBootSecurityRest.restApi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spingBootSecurityRest.restApi.dto.PersonDTO;
import spingBootSecurityRest.restApi.model.Person;
import spingBootSecurityRest.restApi.service.PersonService;

import java.util.List;

@RestController
@RequestMapping(value = "api/admin/")
public class AdminRestController {
    private final PersonService personService;

    @Autowired
    public AdminRestController(PersonService personService) {
        this.personService = personService;
    }


    @GetMapping()
    public List<Person> getAllPerson() {
        return personService.getAllPersons();
    }

    @GetMapping(value = "/{id}")
    public PersonDTO getPerson(@PathVariable("id") int id) {
        return covertToPersonDTO(personService.getPersonById(id));
    }

    @PatchMapping()
    public void updatePerson(@RequestBody Person person){
        personService.changePersonById(person);
    }

    @DeleteMapping(value = "/{id}")
    public void deletePerson(@PathVariable("id") int id){
        personService.deletePersonById(id);
    }
    @PostMapping()
    public int savePerson(@RequestBody Person person){
        personService.addNewPerson(person);
        return personService.getPersonByName(person.getFirstName()).get().getId();
    }
    private PersonDTO covertToPersonDTO(Person person) {
        PersonDTO personDTO = new PersonDTO();
        personDTO.setId(person.getId());
        personDTO.setFirstName(person.getFirstName());
        personDTO.setLastName(person.getLastName());
        personDTO.setAge(person.getAge());
        personDTO.setPassword(person.getPassword());
        return personDTO;
    }
}
