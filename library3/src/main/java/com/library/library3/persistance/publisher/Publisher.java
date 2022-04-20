package com.library.library3.persistance.publisher;

import com.library.library3.persistance.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Publisher extends AbstractEntity {

    @Column(name = "first_name")
    private String firstName;

    public Publisher() {
    }

    public Publisher(String firstName) {
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
        return "Publisher{" +
                "firstName='" + firstName + '\'' +
                '}';
    }
}
