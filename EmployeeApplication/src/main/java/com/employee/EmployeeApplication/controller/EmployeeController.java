package com.employee.EmployeeApplication.controller;
import com.employee.EmployeeApplication.entity.Employee;
import com.employee.EmployeeApplication.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
}
