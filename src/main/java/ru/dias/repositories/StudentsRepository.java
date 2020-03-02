package ru.dias.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ru.dias.entities.Student;

import java.util.List;

@Repository
public interface StudentsRepository extends PagingAndSortingRepository<Student, Long> {
}
