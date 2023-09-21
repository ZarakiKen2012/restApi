package spingBootSecurityRest.restApi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import spingBootSecurityRest.restApi.model.Person;

@RestController
@RequestMapping(value = "/api/user/")
public class UserRestController {

    @GetMapping
    public ResponseEntity<Person> getAUthUser(@AuthenticationPrincipal Person person) {
        return new ResponseEntity<Person>(person, HttpStatus.OK);
    }
}
