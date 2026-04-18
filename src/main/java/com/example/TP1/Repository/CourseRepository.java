package com.example.TP1.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.TP1.Course;
public interface CourseRepository extends JpaRepository<Course, Long> {
}