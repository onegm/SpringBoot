package com.employee.EmployeeApplication.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String client;

    @JsonIgnore
    @ManyToMany(mappedBy = "projects")
    private Set<Employee> employees = new HashSet<>();

    public Project() {
    }

    public Project(String name, String client, Set<Employee> employees) {
        this.name = name;
        this.client = client;
        this.employees = employees;
    }

    public Project(String name, String client) {
        this.name = name;
        this.client = client;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }
}
