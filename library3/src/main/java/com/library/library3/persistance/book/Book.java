package com.library.library3.persistance.book;

import com.library.library3.persistance.AbstractEntity;
import com.library.library3.persistance.author.Author;
import com.library.library3.persistance.publisher.Publisher;

import javax.persistence.*;

@Entity
@Table(name = "book")
public class Book extends AbstractEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_books_author_id"))
    private Author author;

    @Column(name = "genre")
    private String genre;

    @Column(name = "sub_genre")
    private String subGenre;

    @Column(name = "height")
    private String height;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "publisher_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_books_publisher_id"))
    private Publisher publisher;


    protected Book() {
        super();
    }

    public Book(Author author, String genre, String subGenre, String height, Publisher publisher) {
        super();
        this.author = author;
        this.genre = genre;
        this.subGenre = subGenre;
        this.height = height;
        this.publisher = publisher;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getSubGenre() {
        return subGenre;
    }

    public void setSubGenre(String subGenre) {
        this.subGenre = subGenre;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }
}
