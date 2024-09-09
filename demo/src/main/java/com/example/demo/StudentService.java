package com.example.demo;

import com.example.StudentDatabase.repository.Student;
import com.example.StudentDatabase.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;  // Import the Optional class

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    // Save the student details to the database
    public Student saveStudent(Student student) {
        return studentRepository.save(student);  // Saves student and auto-generates ID
    }

    // Fetch a student by ID
    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);  // Correct use of Optional
    }
}
