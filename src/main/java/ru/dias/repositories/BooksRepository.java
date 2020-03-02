package ru.dias.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ru.dias.entities.Book;
import ru.dias.entities.Student;

@Repository
public interface BooksRepository extends PagingAndSortingRepository<Book, Long> {
}
