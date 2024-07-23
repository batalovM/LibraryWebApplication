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
    private String full_name;
    @Min(value = 0, message = "Возраст должен быть больше 0!")
    private int year_of_birth;
    public Person() {}
    public Person(int id, String full_name, int year_of_birth) {
        this.id = id;
        this.full_name = full_name;
        this.year_of_birth = year_of_birth;
    }

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public int getYear_of_birth() {
        return year_of_birth;
    }

    public void setYear_of_birth(int year_of_birth) {
        this.year_of_birth = year_of_birth;
    }

}
