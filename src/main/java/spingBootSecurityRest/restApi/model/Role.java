package spingBootSecurityRest.restApi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "roles")
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "role")
    private String role;
    @JsonIgnore
    @ManyToMany(mappedBy = "roles")
    private Set<Person> persons = new HashSet<>();

    public Role(String role) {
        this.role = role;
    }

    public Role() {
    }

    public String getRole() {
        return role;
    }

    public Set<Person> getPersons() {
        return persons;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setPersons(Set<Person> persons) {
        this.persons = persons;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String getAuthority() {
        return "ROLE_" + role;
    }//Вызывается автоматически Security, на каждом элементе списка ролей

}
