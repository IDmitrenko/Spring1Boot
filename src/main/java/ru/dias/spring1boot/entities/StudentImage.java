package ru.dias.spring1boot.entities;

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
    private Student student;

    @Column(name = "path")
    private String path;
}
