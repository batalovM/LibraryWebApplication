package org.example.dao;

import org.example.models.Book;
import org.example.models.Person;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * @author batal
 * @Date 23.07.2024
 */
@Component
public class PersonDAO {
    private final JdbcTemplate jdbcTemplate;

    public PersonDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Person> index() {
        return jdbcTemplate.query("SELECT * FROM Person", new BeanPropertyRowMapper<>(Person.class));
    }

    public Person show(int id){
        return jdbcTemplate.query("SELECT * FROM Person WHERE person_id=?", new Object[]{id}, new BeanPropertyRowMapper<>(Person.class))
                .stream().findAny().orElse(null);
    }

    public void save(Person person){
        jdbcTemplate.update("INSERT INTO Person(full_name, year_of_birth) VALUES(?, ?)", person.getFullName(), person.getYearOfBirth());
    }

    public void update(int id, Person updatePerson){
        jdbcTemplate.update("UPDATE Person SET (full_name, year_of_birth), WHERE id=?",
                updatePerson.getFullName(), updatePerson.getYearOfBirth(), id);
    }
    public void delete(int id){
        jdbcTemplate.update("DELETE FROM Person WHERE id=?", id);
    }

    public Optional<Person> getPersonByFullName(String full_name){
        return jdbcTemplate.query("SELECT * FROM Person WHERE full_name=?", new Object[]{full_name},
                new BeanPropertyRowMapper<>(Person.class)).stream().findAny();
    }
    public List<Book> getBooksByPerson(int id){
        return jdbcTemplate.query("SELECT * FROM Book WHERE person_id=?", new Object[]{id}, new BeanPropertyRowMapper<>(Book.class));
    }

}
