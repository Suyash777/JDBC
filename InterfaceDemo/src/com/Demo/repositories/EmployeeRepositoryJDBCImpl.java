package com.Demo.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.commons.dbcp2.BasicDataSource;

import com.Demo.model.Employee;

import Exception.NoEmpFoundException;

public class EmployeeRepositoryJDBCImpl implements EmployeeDAO {
	
	private BasicDataSource dataSource;
		
	public EmployeeRepositoryJDBCImpl(BasicDataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void addEmployee(Employee employee) {
		try(Connection connection = this.dataSource.getConnection()) {
			
			String insertQuery = "Insert INTO employee_table values(?,?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
			preparedStatement.setInt(1, employee.getEmpId());

			preparedStatement.setString(2, employee.getName());

			preparedStatement.setString(3, employee.getCity());

			preparedStatement.setDouble(4, employee.getSalaray());
								
			int rowAffected = preparedStatement.executeUpdate();
			
			if (rowAffected > 0) {
				System.out.println("Record Inserted");
			}
			else {
				System.out.println("Record not Inserted");
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public Employee getEmployee(int empId) throws NoEmpFoundException {
		Employee employee = null;

		try(Connection connection = this.dataSource.getConnection()) {

		String getEmpQuery = "SELECT empId,empName,city,salary FROM employee_table WHERE empId = (?)";
		PreparedStatement preparedStatement = connection.prepareStatement(getEmpQuery);

		preparedStatement.setInt(1, empId);

		 

		ResultSet resultset = preparedStatement.executeQuery();

		if(resultset.next()) {

			int  eId = resultset.getInt("empId");
	
			String eName = resultset.getString("empName");
	
			String eCity = resultset.getString("city");
	
			double eSalary = resultset.getDouble("salary");
	
			employee = new Employee(eId,eName,eCity,eSalary);

		}

		} catch (SQLException e) {

		// TODO Auto-generated catch block

		e.printStackTrace();

		}
		if(employee!=null) {
			return employee;
		}else {
			return employee;
		}
	}

	@Override
	public ArrayList<Employee> getAllEmployee() {
		ArrayList<Employee> employees = new ArrayList<>();

		String getEmpQuery = "SELECT * FROM employee_table";

		try(Connection connection = this.dataSource.getConnection()) {


		PreparedStatement preparedStatement = connection.prepareStatement(getEmpQuery);

		ResultSet resultset = preparedStatement.executeQuery();

		while(resultset.next()) {

			int  eId = resultset.getInt("empId");
	
			String eName = resultset.getString("empName");
	
			String eCity = resultset.getString("city");
	
			double eSalary = resultset.getDouble("salary");
	
			Employee employee = new Employee(eId,eName,eCity,eSalary);
	
			employees.add(employee);

		}

		} catch (SQLException e) {

		// TODO Auto-generated catch block

		e.printStackTrace();

		}
		return employees;
	}

	@Override
	public void deleteEmployee(int empId) {
		String deleteEmpQuery = "DELETE FROM employee_table WHERE empId = (?)";

		try(Connection connection = this.dataSource.getConnection()) {

		PreparedStatement preparedStatement = connection.prepareStatement(deleteEmpQuery);

		preparedStatement.setInt(1, empId);

		int rowsAffected = preparedStatement.executeUpdate();

		if(rowsAffected > 0) {

		System.out.println("Employee deleted Succesfully");

		}else {

		System.out.println("Employee not Found "  + empId);

		}

		} catch (SQLException e) {

		// TODO Auto-generated catch block

		e.printStackTrace();

		}
		
	}

}
