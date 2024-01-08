package com.salah.course;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/schools")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(
            @RequestBody Course course
    ) {
        service.saveSchool(course);
    }


    @GetMapping("/with-students/{school-id}")
    public ResponseEntity<FullCourseResponse> findAllSchools(
            @PathVariable("school-id") Integer schoolId
    ) {
        return ResponseEntity.ok(service.findSchoolsWithStudents(schoolId));
    }
}
