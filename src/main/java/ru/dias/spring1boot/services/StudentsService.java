package ru.dias.spring1boot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.dias.spring1boot.entities.Course;
import ru.dias.spring1boot.entities.Student;
import ru.dias.spring1boot.repositories.StudentsRepository;
import ru.dias.spring1boot.utils.StudentNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentsService {
    private StudentsRepository studentsRepository;

    private CoursesService coursesService;

    @Autowired
    public void setStudentsRepository(StudentsRepository studentsRepository) {
        this.studentsRepository = studentsRepository;
    }

    @Autowired
    public void setCoursesService(CoursesService coursesService) {
        this.coursesService = coursesService;
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

    public List<Course> getCoursesByStudentId(Long id) {
        return studentsRepository.findOneById(id).getCourses();
    }

    public List<Course> getMissingCoursesByStudentId(Long id) {
        List<Course> courses = coursesService.getAllCoursesList();
        List<Course> studentsCourses = studentsRepository.findOneById(id).getCourses();
        courses.removeAll(studentsCourses);
        return courses;
    }

    public void addCourseToStudent(Long studentId, Long courseId) {
        Student student = studentsRepository.findOneById(studentId);
        Course course = coursesService.getCourseById(courseId);
        if(student.getCourses() == null) {
            student.setCourses(new ArrayList<Course>());
        }
        student.getCourses().add(course);
        studentsRepository.save(student);
    }

    public void removeCourseFromStudent(Long studentId, Long courseId) {
        Student student = studentsRepository.findOneById(studentId);
        Course course = coursesService.getCourseById(courseId);
        student.getCourses().remove(course);
        studentsRepository.save(student);
    }

    // get
    public Student getStudentById(Long id) {
        Optional<Student> student = studentsRepository.findById(id);
        if (!student.isPresent()) {
            throw new StudentNotFoundException("Student with id = " + id + " not found");
        }
        return student.get();
    }

    // post put
    public Student saveOrUpdate(Student student) {
        return studentsRepository.save(student);
    }

    // delete
    public void delete(Long id) {
        Optional<Student> student = studentsRepository.findById(id);
        if (!student.isPresent()) {
            throw new StudentNotFoundException("Student with id = " + id + " not found");
        }
        studentsRepository.delete(student.get());
    }
}
