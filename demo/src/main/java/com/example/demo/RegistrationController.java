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

@RestController
@RequestMapping("/api/students")
public class RegistrationController {

    @Autowired
    private StudentRepository studentRepository;

    // Endpoint to register a new student
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
            System.out.println("Anshu is here");
            String imageDirectory = "uploads/";
            String imagePath = imageDirectory + image.getOriginalFilename();
            File directory = new File(imageDirectory);
            if (!directory.exists()) {
                directory.mkdirs(); 
            }
            System.err.println(imagePath);
            Path path = Paths.get(imagePath);
            Files.write(path, image.getBytes());
            System.err.println(path);
            Student student = new Student();
            student.setFullName(fullName);
            student.setFatherName(fatherName);
            student.setMotherName(motherName);
            student.setGender(gender);
            student.setDateOfBirth(dateOfBirth); 
            student.setCategory(category);
            student.setPhoneNumber(phoneNumber);
            student.setEmailAddress(emailAddress);
            student.setEmailAddress(address);
            student.setImagePath(imagePath);
            student.setPasswordHash(password); 

            Student savedStudent = studentRepository.save(student);

            return new Response("success", savedStudent.getId());

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

        // Getters and Setters
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
