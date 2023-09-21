package spingBootSecurityRest.restApi.service;


import org.hibernate.Hibernate;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import spingBootSecurityRest.restApi.model.Person;

import java.util.Optional;

@Service
public class PersonDetailsService implements UserDetailsService {
    private final PersonServiceImpl personServiceImpl;

    public PersonDetailsService(PersonServiceImpl personServiceImpl) {
        this.personServiceImpl = personServiceImpl;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Person> person = personServiceImpl.getPersonByName(username);
        if (person.isEmpty()){
            throw new UsernameNotFoundException("User not found");
        }

        return person.get();
    }
}
