package com.employee.EmployeeApplication.service;

import com.employee.EmployeeApplication.entity.Address;
import com.employee.EmployeeApplication.entity.Employee;
import com.employee.EmployeeApplication.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

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
        return employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Not Found"));
    }

    public void createEmployee(Employee e){
        ArrayList<Address> addressArrayList = new ArrayList<>();
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
