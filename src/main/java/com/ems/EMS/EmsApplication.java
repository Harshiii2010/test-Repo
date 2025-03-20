package com.ems.EMS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ems.EMS.Service.EmployeeService;
import com.ems.EMS.Service.HRService;
import com.ems.EMS.Service.PayrollService;
import com.ems.EMS.Service.PerformanceService;
import com.ems.EMS.model.Employee;
import com.ems.EMS.model.EmsAppConfig;
import com.ems.EMS.model.HR;
import com.ems.EMS.model.Payroll;
import com.ems.EMS.model.Performance;

@SpringBootApplication
public class EmsApplication {

	public static void main(String[] args) {
//		//SpringApplication.run(EmsApplication.class, args);
//		ApplicationContext context = new AnnotationConfigApplicationContext(EmsAppConfig.class);
//		Employee emp = context.getBean("employee", Employee.class);
//		//Employee emp2 = context.getBean("employee2", Employee.class);
//		Payroll payroll = context.getBean("payroll", Payroll.class);
//		//Payroll payroll2 = context.getBean("payroll2", Payroll.class);
//		Performance performance = context.getBean("performance", Performance.class);
//		//Performance performance2 = context.getBean("performance2", Performance.class);
//		HR hr = context.getBean("hr", HR.class);
//		
//		System.out.println(emp);
//		System.out.println("Calculated Salary : " + payroll.calculateSalary());
//		System.out.println(performance);
////		System.out.println("-------------------------------------");
////		System.out.println(emp);
////		System.out.println("Calculated Salary : " + payroll2.calculateSalary());
////		System.out.println(performance2);
//		System.out.println("-------------------------------------");
//		hr.displayEmployee();
//      System.out.println("Fetched Employee: " + employee);

		ApplicationContext context = new AnnotationConfigApplicationContext(EmsAppConfig.class);
		
		EmployeeService empService = context.getBean(EmployeeService.class);
		HRService hrService = context.getBean(HRService.class);
        PayrollService payrollService = context.getBean(PayrollService.class);
        PerformanceService performanceService = context.getBean(PerformanceService.class);
        
        
		System.out.println("Calculated salary: " + empService.calAnnualSalary());
		System.out.println("Skills: " + empService.getEmployeeSkills());
        System.out.println("-----------------");
        //System.out.println(empService.printEmpDetails());
//		System.out.println(empService.calAnnualSalary());
//		System.out.println("---------------------------------------");
 		
        hrService.displayAllEmployees();      
        System.out.println("---------------------------------------");
        Employee employee = hrService.getEmpById(2);
        payrollService.printPayrollReceipt();
        System.out.println("---------------------------------------");
        System.out.println("Eligibility for promotion : " + performanceService.isEligibleForPromotion());
        System.out.println("---------------------------------------");
        performanceService.printPerformanceDetails();
	}

}
