package org.example.util;

import org.example.dao.PersonDAO;
import org.example.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * @author batal
 * @Date 23.07.2024
 */
@Component
public class PersonValidator implements Validator {

    private final PersonDAO personDAO;
    @Autowired
    public PersonValidator(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }

    @Override
    public void validate(Object o, Errors errors) {
        Person person = (Person) o;
        if(personDAO.show(person.getFull_name()).isPresent()){
            errors.rejectValue("full_name", "", "Человек уже добавлен");
        }
    }
}
