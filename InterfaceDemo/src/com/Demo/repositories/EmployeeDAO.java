package com.Demo.repositories;
import java.util.ArrayList;

import com.Demo.model.Employee;

import Exception.NoEmpFoundException;

public interface EmployeeDAO {
	
	public abstract void addEmployee(Employee employee);
	public abstract Employee getEmployee(int empId)  throws NoEmpFoundException;
	public abstract ArrayList<Employee> getAllEmployee();
	public abstract void deleteEmployee(int empId);
	
	

}
