package com.example.demo;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Anshu {

    @Id
    public String name;

    public Anshu(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
