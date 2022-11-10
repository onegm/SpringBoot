package com.employee.EmployeeApplication.controller;
import com.employee.EmployeeApplication.entity.Employee;
import com.employee.EmployeeApplication.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

//@Controller
//@ResponseBody
@RestController // Combination of @Controller and @ResponseBody and couple others
// Controllers handle requests sent by the browser and communicates with the service layer
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @RequestMapping("/employees") // Annotation to create API request
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @RequestMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id){
        return employeeService.getEmployee(id);
    }

    @RequestMapping(value = "/employees", method = RequestMethod.POST) // Default is GET request
    public void createEmployee(@RequestBody Employee e){
        employeeService.createEmployee(e);
    }

    @PutMapping("/employees/{id}") // Put mapping as a substitute for request mapping with method parameter
    public void updateEmployee(@PathVariable int id, @RequestBody Employee e){
        employeeService.updateEmployee(e);
    }

    @DeleteMapping("/employees/{id}")
    public void deleteEmployee(@PathVariable int id){
        employeeService.deleteEmployee(id);
    }
}
