package com.example.TP1.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.TP1.Student;
import com.example.TP1.Repository.StudentRepository;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


@RestController
@RequestMapping("/students")
public class StudentController {
@Autowired
private StudentRepository studentRepository;
@GetMapping
public List<Student> getAll() {
return studentRepository.findAll();
}
@PostMapping
public Student create(@RequestBody @Valid Student student) {
return studentRepository.save(student);
}
@GetMapping("/{id}")
public Student getById(@PathVariable Long id) {
return studentRepository.findById(id)
.orElseThrow(() -> new RuntimeException("Student not found"));
}
@DeleteMapping("/{id}")
public void delete(@PathVariable Long id) {
studentRepository.deleteById(id);
}
@GetMapping("/page")
    public Page<Student> getPage(Pageable pageable) {
        return studentRepository.findAll(pageable);
    }
@GetMapping("/search")
public List<Student> search(@RequestParam String name) {
    return studentRepository.findByName(name);
}

public StudentRepository getStudentRepository() {
    return studentRepository;
}


@PutMapping("/{id}")
public Student update(@PathVariable Long id, @RequestBody Student newStudent) {
    return studentRepository.findById(id)
            .map(student -> {
                student.setName(newStudent.getName());
                student.setEmail(newStudent.getEmail());
                return studentRepository.save(student);

            }).orElseThrow(() -> new RuntimeException("Student not found"));

}
}
