package spingBootSecurityRest.restApi.controller;

import org.springframework.web.bind.annotation.*;
import spingBootSecurityRest.restApi.converters.PersonConverter;
import spingBootSecurityRest.restApi.dto.PersonDto;
import spingBootSecurityRest.restApi.model.Person;
import spingBootSecurityRest.restApi.service.PersonService;

import java.util.List;

@RestController
@RequestMapping(value = "api/admin/")
public class AdminRestController {
    private final PersonService personService;
    private final PersonConverter personConverter;

    public AdminRestController(PersonService personService, PersonConverter personConverter) {
        this.personService = personService;
        this.personConverter = personConverter;
    }

    @GetMapping()
    public List<Person> getAllPerson() {
        return personService.getAllPersons();
    }

    @GetMapping(value = "/{id}")
    public PersonDto getPerson(@PathVariable("id") int id) {
        return personConverter.convertToPersonDto(personService.getPersonById(id));
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
}
