package com.employee.EmployeeApplication.entity;

import javax.persistence.*;
import java.util.List;

@Entity // Definde by JPA. Signals that this is a table in database
public class Employee {
    @Id // Signals primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto generated field using specific strategy
    int id;
    String name;
    String city;

    @OneToOne
    private Spouse spouse;
    @OneToOne
    @JoinColumn(name = "Account") // Change column name from default: Salary_Account_ID
    private SalaryAccount salaryAccount;

    @OneToMany // No new column created. New table mapping employee to addresses instead.
    @JoinTable(inverseJoinColumns = @JoinColumn(name = "address_id"))
    private List<Address> addressList; // Multiple entries for same employee if more than one address.

    @ManyToMany
    @JoinTable(name="employee_project", // Table name
            joinColumns = @JoinColumn(name="employee_id"), // column name of this entity
            inverseJoinColumns = @JoinColumn(name="project_id")) // name of other entity
    private List<Project> projects;
    public Employee(){}
    public Employee(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Spouse getSpouse() {
        return spouse;
    }

    public void setSpouse(Spouse spouse) {
        this.spouse = spouse;
    }

    public SalaryAccount getSalaryAccount() {
        return salaryAccount;
    }

    public void setSalaryAccount(SalaryAccount salaryAccount) {
        this.salaryAccount = salaryAccount;
    }

    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public void removeProject(Project p){
        this.projects.remove(p);
        p.getEmployees().remove(this);
    }

    public void addProject(Project p){
        this.projects.add(p);
        p.getEmployees().add(this);
    }
}
