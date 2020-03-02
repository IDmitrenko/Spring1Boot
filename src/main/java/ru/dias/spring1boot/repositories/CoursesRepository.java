package ru.dias.spring1boot.repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.dias.spring1boot.entities.Course;

@Repository
public interface CoursesRepository extends CrudRepository<Course, Long> {
}
