package com.ems.EMS.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.ems.EMS.model.Performance;
 
@Service
public class PerformanceService {
    //eligible for promotion or not
	//list all project
	//print feedback for employee
	
	@Autowired
	private Performance performance;
	public boolean isEligibleForPromotion() {
        return performance.isEligibleForPromotion();
    }
 
    public void printPerformanceDetails() {
        System.out.println("********Performance Details********");
        System.out.println("Employee ID: " + performance.getEmployeeId());
        System.out.println("Rating: " + performance.getRating());
        System.out.println("Feedback: " + performance.getFeedback());
        System.out.println("Projects Handled: " + performance.getProjectsHandled());
        System.out.println("Eligible for Promotion: " + performance.isEligibleForPromotion());
    }

    public String getFeedback(Performance performance) {
        return performance.getFeedback();
    }

}