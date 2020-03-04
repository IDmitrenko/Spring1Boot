package ru.dias.spring1boot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.dias.spring1boot.entities.Book;
import ru.dias.spring1boot.repositories.BooksRepository;

import java.util.List;

@Service
public class BooksService {

    private BooksRepository booksRepository;
    @Autowired
    public void setBooksRepository(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    public BooksService() {
    }

    public List<Book> getAllBooksList() {
        return (List<Book>) booksRepository.findAll();
    }

    public void addBook(Book book) {
        booksRepository.save(book);
    }

    public void removeById(Long id) {
        booksRepository.deleteById(id);
    }
}
