package com.student.users.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "student")
@NamedQuery(name = "Student.findAll", query = "SELECT a FROM Student a")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private Integer telugu;

    private Integer english;


}
