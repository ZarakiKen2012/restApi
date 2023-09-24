package spingBootSecurityRest.restApi.converters;

import org.springframework.stereotype.Component;
import spingBootSecurityRest.restApi.dto.PersonDto;
import spingBootSecurityRest.restApi.model.Person;

@Component
public class PersonConverter {
    public PersonDto convertToPersonDto(Person person) {
        PersonDto personDto = new PersonDto();
        personDto.setId(person.getId());
        personDto.setFirstName(person.getFirstName());
        personDto.setLastName(person.getLastName());
        personDto.setAge(person.getAge());
        personDto.setPassword(person.getPassword());
        return personDto;
    }
}
