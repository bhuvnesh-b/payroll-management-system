package com.payroll.Employees;

import com.payroll.Employees.entity.Login;
import com.payroll.Employees.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmployeesApplication implements CommandLineRunner {
	public static void main(String[] args) {
		SpringApplication.run(EmployeesApplication.class, args);
	}

	@Autowired
	private LoginRepository repository;


	@Override
	public void run(String... args) throws Exception {
		Login login=new Login(10001L,9001L,"abcd");
		repository.save(login);
	}
}
