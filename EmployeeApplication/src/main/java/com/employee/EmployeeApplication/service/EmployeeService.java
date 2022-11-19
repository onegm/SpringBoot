package com.employee.EmployeeApplication.service;

import com.employee.EmployeeApplication.entity.Address;
import com.employee.EmployeeApplication.entity.Employee;
import com.employee.EmployeeApplication.entity.Project;
import com.employee.EmployeeApplication.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
@Transactional // To access DB from here 
@Service // Tells Spring that this is a service.
// Service class communicates with controller and data access layer
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository; // Data access layer

    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    public Employee getEmployee(int id){
//        try{
//            return employeeRepository.findById(id).get();
//        }
//        catch(RuntimeException exc){
//            throw new RuntimeException("Not found.");
//        }
//        One line version:

        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Not Found"));
        System.out.println("fetching projects******************************");
        Set<Project> projects = employee.getProjects();
        for(Project p : projects)
            System.out.println(p.getClient());
        return employee;
    }

    public void createEmployee(Employee e){
        Set<Address> addressArrayList = new HashSet<>();
        for(Address address: e.getAddressList()){
            addressArrayList.add(new Address(address.getLine1(), address.getLine2(), address.getZipcode(),
                                 address.getCity(), address.getCountry(), e));
        }
        e.setAddressList(addressArrayList);
        employeeRepository.save(e);
    }

    public void updateEmployee(Employee e){
        employeeRepository.save(e);
    }

    public void deleteEmployee(int id){
        employeeRepository.deleteById(id);
    }
}
