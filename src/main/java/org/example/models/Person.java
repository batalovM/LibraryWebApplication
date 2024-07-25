package org.example.models;
import javax.validation.constraints.*;
/**
 * @author batal
 * @Date 23.07.2024
 */
public class Person {
    private int id;

    @NotEmpty(message = "ФИО не должно быть пустым!")
    @Pattern(regexp =  "^[А-ЯЁ][а-яё]+\\s+[А-ЯЁ][а-яё]+\\s+[А-ЯЁ][а-яё]+$", message = "ФИО нужно записывать в виде Фамилия Имя Отчество")
    private String fullName;
    @Min(value = 1900, message = "Дата должена быть больше 1900!")
    private int yearOfBirth;
    public Person() {}
    public Person(int id, String fullName, int yearOfBirth) {
        this.id = id;
        this.fullName = fullName;
        this.yearOfBirth = yearOfBirth;
    }

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

}
