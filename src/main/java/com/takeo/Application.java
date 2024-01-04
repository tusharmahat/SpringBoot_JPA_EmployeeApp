package com.takeo;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.takeo.entity.Employee;
import com.takeo.repo.EmployeeRepo;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);
		EmployeeRepo daoImpl = (EmployeeRepo) ctx.getBean(EmployeeRepo.class);

		Employee e = new Employee("Tushar", "tm@gmail.com", "Canada");

		Employee er = (Employee) daoImpl.save(e);

		if (er != null) {
			System.out.println("Employee saved successfully in DB");
		} else {
			System.out.println("Failed to save the employee to DB");
		}
		
		e = new Employee("Ram", "tushar@gmail.com", "Canada");
		
		
		 er = (Employee) daoImpl.save(e);

		if (er != null) {
			System.out.println("Employee saved successfully in DB");
		} else {
			System.out.println("Failed to save the employee to DB");
		}
		

		Optional<Employee> emp = daoImpl.findById(1);
		Employee empO = emp.get();
		if (empO != null) {
			System.out.println(empO.getEName() + "\t" + empO.getEmail() + "\t" + empO.getAddress());
		} else {
			System.out.println("Employee not found");
		}

		Optional<Employee> emp1 = daoImpl.findByEmail("tm@gmail.com");
		Employee emp1O = emp1.get();
		if (emp1O != null) {
			System.out.println(emp1O.getEName() + "\t" + emp1O.getEmail() + "\t" + emp1O.getAddress());
		} else {
			System.out.println("Employee not found");
		}

		List<String> allEmails = daoImpl.getAllEmails();

		allEmails.stream().forEach(System.out::println);

		List<Employee> allEmp = (List<Employee>) daoImpl.findAll();

		allEmp.stream().forEach(empl -> System.out.println(empl.getEmail()));
//		List<Employee> empLists = daoImpl.getAllEmails(1);
//		empLists.stream().forEach(empl -> System.out.println(empl.getEmail()));
		
		List<String> empLists = daoImpl.getAllEmails(2);
		empLists.stream().forEach(empl -> System.out.println(empl));
	}

}
