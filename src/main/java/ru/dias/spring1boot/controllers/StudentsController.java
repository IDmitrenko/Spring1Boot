package ru.dias.spring1boot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.dias.spring1boot.entities.Student;
import ru.dias.spring1boot.services.ImageSaverService;
import ru.dias.spring1boot.services.StudentsService;

import javax.transaction.Transactional;
import java.util.List;

@Controller
@RequestMapping("/students")
@Transactional
public class StudentsController {
    private StudentsService studentsService;
    private ImageSaverService imageSaverService;

    @Autowired
    public void setStudentsService(StudentsService studentsService) {
        this.studentsService = studentsService;
    }

    public void setImageSaverService(ImageSaverService imageSaverService) {
        this.imageSaverService = imageSaverService;
    }

    @RequestMapping("/list")
    public String showStudentsList(Model model) {
        List<Student> allStudents = studentsService.getAllStudentsList();
        model.addAttribute("studentsList", allStudents);
        return "students-list";
    }

    @RequestMapping(path="/add", method=RequestMethod.GET)
    public String showAddForm(Model model) {
        Student student = new Student();
        student.setName("Unknown");
        model.addAttribute("student", student);
        return "add-student-form";
    }

    @RequestMapping(path="/add", method=RequestMethod.POST)
    public String showAddForm(Student student) {
        studentsService.addStudent(student);
        return "redirect:/students/list";
    }

    @RequestMapping(path="/remove/{id}", method=RequestMethod.GET)
    public String removeById(@PathVariable(value = "id") Long studentId) {
        studentsService.removeById(studentId);
        return "redirect:/students/list";
    }

    @RequestMapping(path = "/courses/{id}", method = RequestMethod.GET)
    public String showStudentsCoursesInfo(Model model, @PathVariable(value = "id") Long studentId) {
        model.addAttribute("studentId", studentId);
        model.addAttribute("studentCourses", studentsService.getCoursesByStudentId(studentId));
        model.addAttribute("studentMissingCourses", studentsService.getMissingCoursesByStudentId(studentId));
        return "student-courses-list";
    }

    @RequestMapping(path = "/courses/add/{studentId}/{courseId}", method = RequestMethod.GET)
    public String addCourseToStudent(Model model, @PathVariable(value = "studentId") Long studentId, @PathVariable(value = "courseId") Long courseId) {
        studentsService.addCourseToStudent(studentId, courseId);
        return "redirect:/students/courses/" + studentId;
    }

    @RequestMapping(path = "/courses/remove/{studentId}/{courseId}", method = RequestMethod.GET)
    public String removeCourseFromStudent(Model model, @PathVariable(value = "studentId") Long studentId, @PathVariable(value = "courseId") Long courseId) {
        studentsService.removeCourseFromStudent(studentId, courseId);
        return "redirect:/students/courses/" + studentId;
    }

//    @RequestMapping(path="/add", method=RequestMethod.POST)
//    public String showAddForm(@RequestParam(value="student") Student student) {
//        studentsService.addStudent(student);
//        return "redirect:/students/list";
//    }
//
//    @RequestMapping("/processForm")
//    public String processForm(@ModelAttribute("student") Student student) {
//        System.out.println(student.getFirstName() + " " + student.getLastName());
//        return "student-form-result";
//    }
//
//    // http://localhost:8189/students/showStudentById?id=5
//    @RequestMapping(path="/showStudentById", method=RequestMethod.GET)
//    public String showStudentById(Model model, @RequestParam int id) {
//        Student student = studentsService.getStudentById(new Long(id));
//        model.addAttribute("student", student);
//        return "student-form-result";
//    }
//
//    @RequestMapping(path="/getStudentById", method=RequestMethod.GET)
//    @ResponseBody
//    public Student getStudentById(@RequestParam int id) {
//        Student student = studentsService.getStudentById(new Long(id));
//        return student;
//    }
//
//    @RequestMapping(path="/getStudentById/{sid}", method=RequestMethod.GET)
//    @ResponseBody
//    public Student getStudentByIdFromPath(@PathVariable("sid") int id) {
//        Student student = studentsService.getStudentById(new Long(id));
//        return student;
//    }
}
