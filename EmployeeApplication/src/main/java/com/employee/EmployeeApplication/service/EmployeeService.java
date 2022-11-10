package com.employee.EmployeeApplication.service;

import com.employee.EmployeeApplication.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

@Service // Tells Spring that this is a service.
public class EmployeeService {
    // Dummy list for testing
    List<Employee> employeeList = new ArrayList<>(Arrays.asList(
            new Employee(1, "First", "Cairo"),
            new Employee(2, "Second", "New York")
    ));

    public List<Employee> getAllEmployees(){
        return employeeList;
    }

    public Employee getEmployee(int id){
        return employeeList.stream().filter(e -> e.getId() == id).findFirst().get();
    }

    public void createEmployee(Employee e){
        employeeList.add(e);
    }

    public void updateEmployee(Employee e){
        List<Employee> tempEmployeeList = new ArrayList<>();

        for (Employee emp : employeeList) {
            if(emp.getId() == e.getId()){
                emp.setName(e.getName());
                emp.setCity(e.getCity());
            }
            tempEmployeeList.add(emp);
        }
        this.employeeList = tempEmployeeList;
    }

    public void deleteEmployee(int id){
        List<Employee> tempEmployeeList = new ArrayList<>();
        for (Employee emp : employeeList) {
            if(emp.getId() != id){
                tempEmployeeList.add(emp);
            }
        }
        this.employeeList = tempEmployeeList;
    }
}
