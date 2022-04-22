package com.library.library3.persistance.publisher;

import com.library.library3.persistance.AbstractEntity;
import com.library.library3.persistance.book.Book;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Publisher extends AbstractEntity {

    @Column(name = "first_name")
    private String firstName;

    @OneToMany(mappedBy = "publisher")
    private List<Book> books = new ArrayList<>();

    protected Publisher() {
        super();
    }

    public Publisher(String firstName) {
        super();
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void addBook(Book book) {
        books.add(book);
        book.setPublisher(this);
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "firstName='" + firstName + '\'' +
                '}';
    }
}
