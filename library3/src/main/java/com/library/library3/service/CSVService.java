package com.library.library3.service;

import com.library.library3.helper.CSVHelper;
import com.library.library3.persistance.author.Author;
import com.library.library3.persistance.book.Book;
import com.library.library3.persistance.publisher.Publisher;
import com.library.library3.repository.AuthorRepository;
import com.library.library3.repository.BookRepository;
import com.library.library3.repository.PublisherRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class CSVService {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public CSVService(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    public void saveBooks(MultipartFile file) throws IOException {
        Assert.notNull(file, "File must not be null");
        List<Book> books = CSVHelper.parseCSV(file.getInputStream());
        for (Book book : books) {

            Optional<Author> optionalAuthor = authorRepository.findByFirstName(book.getAuthor().getFirstName());
            Author author = authorRepository.save(optionalAuthor.orElseGet(() -> authorRepository.save(book.getAuthor())));
            book.setAuthor(author);

            Optional<Publisher> publisherOptional = publisherRepository.findByFirstName(book.getPublisher().getFirstName());
            Publisher publisher = publisherRepository.save(publisherOptional.orElseGet(() -> publisherRepository.save(book.getPublisher())));
            book.setPublisher(publisher);
            bookRepository.save(book);

        }
    }

}
