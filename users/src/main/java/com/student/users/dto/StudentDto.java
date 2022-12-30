package com.student.users.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class StudentDto {
    private Long id;

    private String name;

    private Integer telugu;

    private Integer english;
    
    private Integer total;
}
