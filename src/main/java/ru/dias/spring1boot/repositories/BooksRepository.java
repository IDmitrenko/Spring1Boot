package ru.dias.spring1boot.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ru.dias.spring1boot.entities.Book;

@Repository
public interface BooksRepository extends PagingAndSortingRepository<Book, Long> {
}
