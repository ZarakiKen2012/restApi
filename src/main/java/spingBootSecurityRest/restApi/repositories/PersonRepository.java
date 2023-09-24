package spingBootSecurityRest.restApi.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import spingBootSecurityRest.restApi.model.Person;

import java.util.Optional;


@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
    @Query("SELECT p FROM Person p JOIN FETCH p.roles WHERE p.firstName = :firstName")
    Optional<Person> findByFirstName(@Param("firstName") String firstName);
}
