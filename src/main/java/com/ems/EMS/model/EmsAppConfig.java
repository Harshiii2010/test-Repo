package com.ems.EMS.model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages ="com.ems.EMS.Service")
@PropertySource("classpath:application.properties")//load properties file
public class EmsAppConfig {

//	@Bean
//	public Address address() {
//		Address address = new Address();
//		address.setStreet("tonk Road");
//		address.setCity("Jaipur");
//		address.setState("Rajasthan");
//		address.setZipcode("450098");
//		return address;
//	}
//	
//	@Bean
//	public Department department() {
//		Department department= new Department();
//		department.setDeptId(2);
//		department.setDeptName("Development");
//		return department;
//	}
//	
//	@Bean
//	public List<String> skills(){
//		return Arrays.asList("Java","MySQL","SpringFramework");
//	}
//	
//	@Bean
//	public Employee employee() {
//		Employee employee = new Employee();
//		employee.setId(2);
//		employee.setName("smith");
//	    employee.setEmail("smith@gmail.com");
//	    employee.setPhone("8762829628");
//	    employee.setSalary(50000);
//		employee.setAddress(address());
//		employee.setDepartment(department());
//		employee.setSkills(skills());
//		
//		return employee;
//	}
//	@Bean
//	public Payroll payroll() {
//		Payroll payroll = new Payroll();
//		payroll.setBaseSalary(66000);
//		payroll.setBonuses(5000);
//		payroll.setDeduction(2000);
//		return payroll;
//	}
//	@Bean
//	public Performance performance() {
//		Performance performance = new Performance();
//		performance.setEmployeeId(3);
//		performance.setFeedback("Good Performance");
//		performance.setRating(4.5);
//		return performance;
//	}
	
//	@Bean
//	public Map<Integer, Employee> empRecords(){
//		 Map<Integer, Employee> records = new HashMap<>();
//		 records.put(1,  employee());
//		 return records;
//	}
//	
//	@Bean 
//	public HR hr() {
//		HR hr = new HR();
//		hr.setEmployeeRecords(empRecords());
//		return  hr;
//	}
	
	//for address bean
	@Value("${address.street}")
	private String street;
	@Value("${address.city}")
	private String city;
	@Value("${address.state}")
	private String state;
	@Value("${address.zipcode}")
	private String zipcode;
	
	@Bean
	public Address address() {
		Address address = new Address();
		address.setStreet(street);
		address.setCity(city);
		address.setState(state);
		address.setZipcode(zipcode);
		return address;
	}
	
	@Value("${department.id}")
	private int deptId;
	@Value("${department.name}")
	private String deptName;
	
	@Bean
	public Department department() {
		Department department= new Department();
		department.setDeptId(deptId);
		department.setDeptName(deptName);
		return department;
	}
	
	//list of skills for employee
	@Value("${employee.skills}")
	private String skillsString;
	@Bean
	public List<String> skills(){
		return Arrays.asList(skillsString.split(","));
	}
	@Value("${employee.id}")
	private int id ;
	@Value("${employee.name}")
	private String name;
	@Value("${employee.email}")
	private String email;
	@Value("${employee.phone}")
	private String phone;
	@Value("${employee.salary}")
	private double salary;
	@Value("${employee.designation}")
	private String designation;
	
	@Bean
	public Employee employee() {
		Employee employee = new Employee();
		employee.setId(id);
		employee.setName(name);
	    employee.setEmail(email);
	    employee.setPhone(phone);
	    employee.setSalary(salary);
	    employee.setDesignation(designation);
		employee.setAddress(address());
		employee.setDepartment(department());
		employee.setSkills(skills());
		
		return employee;
	}
	
	@Value ("${performance.projectsHandled}")
	private String projectsHandled;
	@Bean
	public List<String> projectsHandled(){
		return Arrays.asList(projectsHandled.split(","));
	}
	@Value("${performance.employeeId}")
	private int employeeId;
	@Value("${performance.rating}")
	private double rating;
	@Value("${performance.feedback}")
	private String feedback;
	@Value("${performance.eligibleForPromotion}")
	private boolean eligibleForPromotion;
	
	@Bean
	public Performance performance() {
		Performance performance = new Performance();
		performance.setEmployeeId(employeeId);
		performance.setRating(rating);
		performance.setFeedback(feedback);
		performance.setProjectsHandled(projectsHandled());
		performance.setEligibleForPromotion(eligibleForPromotion);
		return performance;
	}
	
	// Payroll bean
    @Value("${payroll.baseSalary}")
    private double baseSalary;
    @Value("${payroll.bonuses}")
    private double bonuses;
    @Value("${payroll.deduction}")
    private double deduction; 
    @Bean
    public Payroll payroll() {
        Payroll payroll = new Payroll();
        payroll.setBaseSalary(baseSalary);
        payroll.setBonuses(bonuses);
        payroll.setDeduction(deduction);
        return payroll;
    }
  //HR bean
    @Bean
	public Map<Integer, Employee> empRecords() {
		Map<Integer, Employee> records = new HashMap<>();
		records.put(id, employee());
		return records;
	}
	@Bean
	public HR hr() {
		HR hr = new HR();
		hr.setEmployeeRecords(empRecords());
		return hr;
	}
}

