package com.ems.EMS.model;

import java.util.Map;

public class HR {

	private Map<Integer,Employee > employeeRecords;
	
	

	public HR() {
		super();
	}

	public HR(Map<Integer, Employee> employeeRecords) {
		super();
		this.employeeRecords = employeeRecords;
	}

	public Map<Integer, Employee> getEmployeeRecords() {
		return employeeRecords;
	}

	public void setEmployeeRecords(Map<Integer, Employee> employeeRecords) {
		this.employeeRecords = employeeRecords;
	}
	
	public void displayEmployee() {
		for(Employee emp : employeeRecords.values()) {
			System.out.println(emp);
		}
	}

	@Override
	public String toString() {
		return "HR [employeeRecords=" + employeeRecords + "]";
	}
	
}
