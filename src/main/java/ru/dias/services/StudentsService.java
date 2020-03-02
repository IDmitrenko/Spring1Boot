package ru.dias.services;

import org.hibernate.annotations.Fetch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.dias.entities.Student;
import ru.dias.repositories.StudentsRepository;

import javax.persistence.FetchType;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class StudentsService {
    private StudentsRepository studentsRepository;

    @Autowired
    public void setStudentsRepository(StudentsRepository studentsRepository) {
        this.studentsRepository = studentsRepository;
    }

    public StudentsService() {
    }

    public List<Student> getAllStudentsList() {
        return (List<Student>)studentsRepository.findAll();
    }

    public void addStudent(Student s) {
        studentsRepository.save(s);
    }

    public void removeById(Long id) {
        studentsRepository.deleteById(id);
    }
}
