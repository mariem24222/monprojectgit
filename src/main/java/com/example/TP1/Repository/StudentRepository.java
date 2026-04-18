package com.example.TP1.Repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.TP1.Student;
public interface StudentRepository extends JpaRepository<Student, Long> {
List<Student> findByName(String name);
}
