package com.library.library3.persistance.author;

import com.library.library3.persistance.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Author extends AbstractEntity {

    @Column(name = "first_name")
    private String firstName;

    public Author() {
    }

    public Author(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

}