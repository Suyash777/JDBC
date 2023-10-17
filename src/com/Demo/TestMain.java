package com.Demo;
import com.Demo.repositories.*;
import java.sql.Connection;

import Exception.NoEmpFoundException;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import org.apache.commons.dbcp2.BasicDataSource;

import com.Demo.config.DbUtil;
import com.Demo.model.*;

public class TestMain {

	public static void main(String[] args) throws NoEmpFoundException {
		
		DbUtil dbUtil = new DbUtil("root","root","jdbc:mysql://localhost:3306/mydb");

		BasicDataSource ds = dbUtil.getDataSource();
		
		EmployeeDAO empRepoJDBC = new EmployeeRepositoryJDBCImpl(ds);
		
		
		Scanner scn = new Scanner(System.in);
		int choice = 0;
		do {
		System.out.println("\nMenu : "
							+ "\n1. Add new Employee record"
							+ "\n2. Find particular Employee Detail"
							+ "\n3. Display all Employees"
							+ "\n4. Delete a existing Employee record"
							+ "\n5. Exit");
		
		choice  = scn.nextInt();
		switch(choice) {
		case 1:
			System.out.println("Provide the required Employee deatails:");
			System.out.print("Enter empId : ");
			int eId = scn.nextInt();
			
			System.out.print("Enter empName : ");
			String eName = scn.next();
			
			System.out.print("Enter city : ");
			String eCity = scn.next();
			
			System.out.print("Enter salary : ");
			double eSalary = scn.nextDouble();
			
			Employee emp1 = new Employee(eId,eName,eCity,eSalary);
			empRepoJDBC.addEmployee(emp1);
			break;
			
			
		case 2:
			System.out.print("Enter the EmpId of Employee :");
			int eIdFind = scn.nextInt();
			Employee emp2 = empRepoJDBC.getEmployee(eIdFind);
			System.out.println(emp2);
			break;
			
		case 3:
			ArrayList<Employee> empList = empRepoJDBC.getAllEmployee();	
			System.out.println(empList);
			break;
			
		case 4:
			System.out.print("Enter the EmpId of Employee to delete the record :");
			int eIdDelete = scn.nextInt();
			empRepoJDBC.deleteEmployee(eIdDelete);
			break;
			
		case 5:
			System.out.println("Existing!");
			
		default:
			System.out.println("Invalid input, try again!");
			break;
		}
		
		
	}while(choice !=5 );
		

		try {
			dbUtil.closeConnection(ds.getConnection());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
