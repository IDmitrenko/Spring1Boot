package ru.dias.spring1boot.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "students_images")
@Data
public class StudentImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    @JsonManagedReference
    private Student student;

    @Column(name = "path")
    private String path;
}
