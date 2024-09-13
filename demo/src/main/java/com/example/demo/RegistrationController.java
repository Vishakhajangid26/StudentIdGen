package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.example.StudentDatabase.repository.Student;
import com.example.StudentDatabase.repository.StudentRepository;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

@RestController
@RequestMapping("/api/students")
public class RegistrationController {

    @Autowired
    private StudentRepository studentRepository;

    // Password encoder instance

    // Registration endpoint (modifying password hashing)
    @PostMapping("/register")
    public Response registerStudent(
            @RequestParam String fullName,
            @RequestParam String fatherName,
            @RequestParam String motherName,
            @RequestParam String gender,
            @RequestParam String dateOfBirth,
            @RequestParam String category,
            @RequestParam String phoneNumber,
            @RequestParam String emailAddress,
            @RequestParam String address,
            @RequestParam MultipartFile image,
            @RequestParam String password
    ) throws IOException {

        try {
            String imageDirectory = "uploads/";
            String imagePath = imageDirectory + image.getOriginalFilename();
            File directory = new File(imageDirectory);
            if (!directory.exists()) {
                directory.mkdirs();
            }
            Path path = Paths.get(imagePath);
            Files.write(path, image.getBytes());

            Student student = new Student();
            student.setFullName(fullName);
            student.setFatherName(fatherName);
            student.setMotherName(motherName);
            student.setGender(gender);
            student.setDateOfBirth(dateOfBirth);
            student.setCategory(category);
            student.setPhoneNumber(phoneNumber);
            student.setEmailAddress(emailAddress);
            student.setAddress(address);
            student.setImagePath(imagePath);

            // Hash password before saving
            student.setPasswordHash(password);

            Student savedStudent = studentRepository.save(student);

            return new Response("success", savedStudent.getId());

        } catch (Exception e) {
            return new Response("failure", e.getMessage());
        }
    }

    // Login endpoint
    @PostMapping("/login")
    public Response login(
            @RequestParam String emailAddress,
            @RequestParam String password
    ) {
        try {
            Optional<Student> optionalStudent = studentRepository.findByEmailAddress(emailAddress);

            if (optionalStudent.isPresent()) {
                Student student = optionalStudent.get();
                System.out.println(password);
                System.out.println(student.getPasswordHash());
                if (password.equals(student.getPasswordHash())) {
                    return new Response("success", "Login successful. Student ID: " + student.getId());
                } else {
                    return new Response("failure", "Invalid password.");
                }
            } else {
                return new Response("failure", "Student not found with this email address.");
            }
        } catch (Exception e) {
            return new Response("failure", e.getMessage());
        }
    }

    // Inner class to handle response format
    static class Response {
        private String status;
        private Object data;

        public Response(String status, Object data) {
            this.status = status;
            this.data = data;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public Object getData() {
            return data;
        }

        public void setData(Object data) {
            this.data = data;
        }
    }
}
