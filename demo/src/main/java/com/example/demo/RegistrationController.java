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
import java.time.LocalDate;

@RestController
@RequestMapping("/api/students")
@CrossOrigin(origins = "http://127.0.0.1:5500")  // Allow requests from your frontend URL
public class RegistrationController {

    @Autowired
    private StudentRepository studentRepository;

    // Password encoder to hash passwords
    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    // Endpoint to register a new student
    @PostMapping("/register")
    public Response registerStudent(
            @RequestParam String fullName,
            @RequestParam String fatherName,
            @RequestParam String motherName,
            @RequestParam Student.Gender gender,
            @RequestParam String dateOfBirth,
            @RequestParam Student.Category category,
            @RequestParam String phoneNumber,
            @RequestParam String emailAddress,
            @RequestParam String address,
            @RequestParam MultipartFile image,
            @RequestParam String password
    ) throws IOException {

        try {
            // Save the image to the specified directory
            String imageDirectory = "uploads/";
            String imagePath = imageDirectory + image.getOriginalFilename();
            File directory = new File(imageDirectory);
            if (!directory.exists()) {
                directory.mkdirs();  // Create the directory if it doesn't exist
            }
            Path path = Paths.get(imagePath);
            Files.write(path, image.getBytes());  // Write the image to the file system

            // Hash the user's password
            String passwordHash = passwordEncoder.encode(password);

            // Create a new Student object
            Student student = new Student();
            student.setFullName(fullName);
            student.setFatherName(fatherName);
            student.setMotherName(motherName);
            student.setGender(gender);
            student.setDateOfBirth(LocalDate.parse(dateOfBirth));  // Convert String to LocalDate
            student.setCategory(category);
            student.setPhoneNumber(phoneNumber);
            student.setEmailAddress(emailAddress);
            student.setEmailAddress(address);
            student.setImagePath(imagePath);  // Set the path to the uploaded image
            student.setPasswordHash(passwordHash);  // Set the hashed password

            // Save the student in the database
            Student savedStudent = studentRepository.save(student);

            // Return a success response with student ID
            return new Response("success", savedStudent.getId());

        } catch (Exception e) {
            // Return a failure response with the error message
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
