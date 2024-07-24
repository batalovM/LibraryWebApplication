package org.example.models;

import javax.validation.constraints.*;

/**
 * @author batal
 * @Date 23.07.2024
 */
public class Book {
    private int id;

    @NotNull(message = "Название не может быть пустым")
    @Size(min = 2, max = 100, message = "Название должно быть между 2 и 100 символами")
    private String title;

    @Pattern(regexp = "^[А-ЯЁ][а-яё]+\\s+[А-ЯЁ][а-яё]+$",message = "Автор должен соответствовать вводу: Фамилия Имя")
    @NotNull(message = "Автор не может быть пустым")
    private String author;

    @NotNull(message = "Год не может быть пустым")
    @Min(value = 750, message = "Год не может быть меньше 750")
    @Max(value = 2025, message = "Книга не может быть из будущего")
    private String year;

    public Book(int id, String title, String author, String year) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.year = year;
    }
    public Book(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
