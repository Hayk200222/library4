package com.library.library3.service;

import com.library.library3.helper.CSVhelper;
import com.library.library3.persistance.book.Book;
import com.library.library3.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class CSVService {

    @Autowired
    BookRepository repository;

    public void save(MultipartFile file) {
        Assert.notNull(file,"Passed file is null");
        try {
            List<Book> books = CSVhelper.csvToTuBooks(file.getInputStream());
            repository.saveAll(books);
        } catch (IOException e) {
            throw new RuntimeException("fail to store csv data: " + e.getMessage());
        }
    }
}
