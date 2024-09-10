package com.example.StudentDatabase.repository;

import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class Student {

    @Id
    private String name;
    public class Gender {
    }

    public class Category {
    }

    public void setMotherName(String motherName) {
        throw new UnsupportedOperationException("Unimplemented method 'setMotherName'");
    }

    public void setFullName(String fullName) {
        throw new UnsupportedOperationException("Unimplemented method 'setFullName'");
    }

    public void setFatherName(String fatherName) {
        throw new UnsupportedOperationException("Unimplemented method 'setFatherName'");
    }

    public void setGender(Gender gender) {
        throw new UnsupportedOperationException("Unimplemented method 'setGender'");
    }

    public void setDateOfBirth(LocalDate localDate) {
        throw new UnsupportedOperationException("Unimplemented method 'setDateOfBirth'");
    }

    public void setCategory(Category category) {
        throw new UnsupportedOperationException("Unimplemented method 'setCategory'");
    }

    public void setPhoneNumber(String phoneNumber) {
        throw new UnsupportedOperationException("Unimplemented method 'setPhoneNumber'");
    }

    public void setEmailAddress(String emailAddress) {
        throw new UnsupportedOperationException("Unimplemented method 'setEmailAddress'");
    }

    public void setImagePath(String imagePath) {
        throw new UnsupportedOperationException("Unimplemented method 'setImagePath'");
    }

    public void setPasswordHash(String passwordHash) {
        throw new UnsupportedOperationException("Unimplemented method 'setPasswordHash'");
    }

    public Object getId() {
        throw new UnsupportedOperationException("Unimplemented method 'getId'");
    }

}
