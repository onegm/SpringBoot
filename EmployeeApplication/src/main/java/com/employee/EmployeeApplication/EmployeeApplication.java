package com.employee.EmployeeApplication;

import com.employee.EmployeeApplication.entity.Address;
import com.employee.EmployeeApplication.entity.Employee;
import com.employee.EmployeeApplication.entity.Project;
import com.employee.EmployeeApplication.entity.Spouse;
import com.employee.EmployeeApplication.service.EmployeeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EmployeeApplication {

	public static void main(String[] args) {SpringApplication.run(EmployeeApplication.class, args);}

	@Bean
	public CommandLineRunner initialCreate(EmployeeService employeeService){
		return(args) -> {

			Address address1 = new Address("Line 1", "Line 2", "zip1", "city1", "country1");
			Project project1 = new Project("project1", "client1");
			Spouse spouse1 = new Spouse("spouse1", "1234321", 29);

			Employee employee1 = new Employee("employee1", "city1");
			employee1.addProject(project1);
			employee1.addAddress(address1);
			employee1.setSpouse(spouse1);

			employeeService.createEmployee(employee1);

			System.out.println("Getting an employee....");
			Employee fetchedEmployee = employeeService.getEmployee(1);
			// One-to-one relationships have EAGER fetch as default and are therefore fetched automatically with employee
			// fetch must be set to EAGER for addresses or others to be fetched along with an employee.


		};
	}
}
