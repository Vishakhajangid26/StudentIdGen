package com.example.StudentDatabase.repository;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class Student {

    @Id
    private String Id;
    private String name;
    private String motherName;
    private String fullName;
    private String fatherName;
    private String gender;
    private String localDate;
    private String category;
    private String phoneNumber;
    private String emailAddress;
    private String imagePath;
    private String passwordHash;

    public void setMotherName(String _motherName) {
        motherName = _motherName;
        // throw new UnsupportedOperationException("Unimplemented method 'setMotherName'");
    }

    public void setFullName(String _fullName) {
        fullName = _fullName;
        // throw new UnsupportedOperationException("Unimplemented method 'setFullName'");
    }

    public void setFatherName(String _fatherName) {
        fatherName = _fatherName;
        // throw new UnsupportedOperationException("Unimplemented method 'setFatherName'");
    }

    public void setGender(String _gender) {
        gender = _gender;
        // throw new UnsupportedOperationException("Unimplemented method 'setGender'");
    }

    public void setDateOfBirth(String _localDate) {
        localDate = _localDate;
        // throw new UnsupportedOperationException("Unimplemented method 'setDateOfBirth'");
    }

    public void setCategory(String _category) {
        category = _category;
        // throw new UnsupportedOperationException("Unimplemented method 'setCategory'");
    }

    public void setPhoneNumber(String _phoneNumber) {
        phoneNumber = _phoneNumber;
        // throw new UnsupportedOperationException("Unimplemented method 'setPhoneNumber'");
    }

    public void setEmailAddress(String _emailAddress) {
        emailAddress =_emailAddress;
        // throw new UnsupportedOperationException("Unimplemented method 'setEmailAddress'");
    }

    public void setImagePath(String _imagePath) {
        imagePath = _imagePath;
        // throw new UnsupportedOperationException("Unimplemented method 'setImagePath'");
    }

    public void setPasswordHash(String _passwordHash) {
        passwordHash = _passwordHash;
        // throw new UnsupportedOperationException("Unimplemented method 'setPasswordHash'");
    }

    public Object getId() {
        throw new UnsupportedOperationException("Unimplemented method 'getId'");
    }

}
