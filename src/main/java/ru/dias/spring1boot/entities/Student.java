package ru.dias.spring1boot.entities;

import lombok.Data;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "students")
@Data
public class Student {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToMany
    @JoinTable(
            name = "students_courses",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    @Cascade({org.hibernate.annotations.CascadeType.DELETE, org.hibernate.annotations.CascadeType.DETACH})
    private List<Course> courses;

    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "student")
    private List<StudentImage> images;

    public void addImage(StudentImage studentImage) {
        if (images == null) {
            images = new ArrayList<>();
        }
        images.add(studentImage);
    }

    @Override
    public String toString() {
        return "Student id=" + id + ", courses=" + courses.size() + '}';
    }
}
