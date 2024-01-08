package com.salah.course;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FullCourseResponse {

    private String name;
    private String email;
    List<Student> students;
}
