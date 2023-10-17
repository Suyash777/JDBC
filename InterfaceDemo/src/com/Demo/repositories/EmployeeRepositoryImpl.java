package com.Demo.repositories;

import java.util.ArrayList;

import com.Demo.model.*;

public class EmployeeRepositoryImpl implements EmployeeDAO{
	
	private ArrayList<Employee> listEmployee;
	
	public EmployeeRepositoryImpl() {
		super();
		this.listEmployee = new ArrayList<>();
	}

	
	@Override
	public void addEmployee(Employee employee) {
			listEmployee.add(employee);
	}
	

	@Override
	public Employee getEmployee (int empId) {
		for(Employee emp: listEmployee) {
			if (emp.getEmpId()==empId) {
				return emp;
			}
		}
		return null;
	}

	

	@Override
	public ArrayList<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		return this.listEmployee;
	}

	@Override
	public void deleteEmployee(int empId) {
		// TODO Auto-generated method stub
		Employee emp = getEmployee(empId);
		if (emp != null) {
			listEmployee.remove(emp);
		}
	}

}
