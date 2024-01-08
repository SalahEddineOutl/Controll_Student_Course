package com.salah.course;

import com.salah.course.client.StudentClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository repository;
    private final StudentClient client;

    public void saveSchool(Course school) {
        repository.save(school);
    }

    public List<Course> findAllSchools() {
        return repository.findAll();
    }

    public FullCourseResponse findSchoolsWithStudents(Integer schoolId) {
        var school = repository.findById(schoolId)
                .orElse(
                        Course.builder()
                                .name("NOT_FOUND")
                                .email("NOT_FOUND")
                                .build()
                );
        var students = client.findAllStudentsBySchool(schoolId);
        return FullCourseResponse.builder()
                .name(school.getName())
                .email(school.getEmail())
                .students(students)
                .build();
    }


}
