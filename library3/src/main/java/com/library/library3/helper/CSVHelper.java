package com.library.library3.helper;

import com.library.library3.persistance.author.Author;
import com.library.library3.persistance.book.Book;
import com.library.library3.persistance.publisher.Publisher;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class CSVHelper {

    public static List<Book> parseCSV(InputStream is) {
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
             CSVParser csvParser = new CSVParser(fileReader,
                     CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim())) {
            List<Book> books = new ArrayList<>();
            Iterable<CSVRecord> csvRecords = csvParser.getRecords();
            for (CSVRecord csvRecord : csvRecords) {
                Author author = new Author(csvRecord.get(0));
                Publisher publisher = new Publisher(csvRecord.get(4));
                Book book = new Book(
                        author,
                        csvRecord.get(1),
                        csvRecord.get(2),
                        csvRecord.get(3),
                        publisher
                );
            }
            return books;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
    }
}
