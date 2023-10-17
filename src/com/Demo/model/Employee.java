package com.Demo.model;

public class Employee {
	private int empId;
	private String name;
	private String city;
	private double salaray;
	
	public Employee() {
		super();
	}
	
	public Employee(int empId, String name, String city, double salaray) {
		super();
		this.empId = empId;
		this.name = name;
		this.city = city;
		this.salaray = salaray;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalaray() {
		return salaray;
	}
	public void setSalaray(double salaray) {
		this.salaray = salaray;
	}
	@Override
	public String toString() {
		return "\nEmployee [empId=" + empId + ", name=" + name + ", city="+city+", salaray=" + salaray + "]";
	}
	

}
