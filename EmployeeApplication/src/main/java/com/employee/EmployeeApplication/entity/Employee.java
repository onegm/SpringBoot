package com.employee.EmployeeApplication.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity // Definde by JPA. Signals that this is a table in database
public class Employee {
    @Id // Signals primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto generated field using specific strategy
    int id;
    String name;
    String city;

    @OneToOne(cascade = CascadeType.ALL) // Cascade propogates all operations on one entity to all the other entities related to it
    private Spouse spouse;
    // Multiple cascade types can be used e.g. cascade = { CascadeType.PERSIST, cascadeType.REMOVE}
    @OneToOne(cascade = CascadeType.ALL, fetch=FetchType.LAZY) // fetch type is eager by default for one to one
    @JoinColumn(name = "Account") // Change column name from default: Salary_Account_ID
    private SalaryAccount salaryAccount;

    @OneToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
    // No new column created. New table mapping employee to addresses instead.
    // EAGER fetchType fetches addresses along with any fetching of the associated employee
    @JoinTable(inverseJoinColumns = @JoinColumn(name = "address_id"))
    private Set<Address> addressList = new HashSet<>(); // Multiple entries for same employee if more than one address.

    @ManyToMany(cascade = CascadeType.PERSIST) // Only allows CREATE but not DELETE to cascade
    @JoinTable(name="employee_project", // Table name
            joinColumns = @JoinColumn(name="employee_id"), // column name of this entity
            inverseJoinColumns = @JoinColumn(name="project_id")) // name of other entity
    private Set<Project> projects = new HashSet<>();
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

    public Set<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(Set<Address> addressList) {
        this.addressList = addressList;
    }

    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }

    public void removeProject(Project p){
        this.projects.remove(p);
        p.getEmployees().remove(p);
    }

    public void addProject(Project p){
        this.projects.add(p);
        p.getEmployees().add(this);
    }

    public void addAddress(Address a){
        this.addressList.add(a);
        a.setEmployee(this);
    }

    public void removeAddress(Address a){
        this.addressList.remove(a);
        a.setEmployee(null);
    }
}
