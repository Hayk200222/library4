package com.library.library3.persistance.author;

import com.library.library3.persistance.AbstractEntity;
import com.library.library3.persistance.book.Book;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "author")
public class Author extends AbstractEntity {

    @Column(name = "first_name")
    private String firstName;

    @OneToMany(mappedBy = "author")
    private List<Book> books= new ArrayList<>();

    protected Author() {
        super();
    }

    public void addBook(Book book) {
        books.add(book);
        book.setAuthor(this);
    }

    public Author(String firstName) {
        super();
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String toString() {
        return "Author{" +
                "firstName='" + firstName + '\'' +
                '}';
    }
}