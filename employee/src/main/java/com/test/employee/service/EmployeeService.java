package com.test.employee.service;

import java.util.ArrayList;
import java.util.List;

import com.test.employee.entity.Address;
import com.test.employee.entity.Employee;
import com.test.employee.exception.GlobalException;

public class EmployeeService {

	private List<Employee> employeeList = new ArrayList<Employee>();

	public void addEmployee(long empId, String name, double salary, String city, String country) {
		Address address = new Address(city, country);
		employeeList.add(new Employee(empId, name, salary, address));
	}

	public void addEmployee(Employee emp) {
		employeeList.add(emp);
	}

	public void displayAllEmployees() {
		for (Employee emp : employeeList) {
			System.out.println("Employee Id" + emp.getEmpId());
			System.out.println(" Employee Name" + emp.getName());
			System.out.println("Employee Salary" + emp.getSalary());
			System.out.println("Employee Address" + emp.getAddress().getCity() + "," + emp.getAddress().getCountry());
		}
	}

	public Employee getEmployeeById(int id) throws GlobalException {
		for (int i = 0; i < employeeList.size(); i++) {
			if (employeeList.get(i).getEmpId() == id) {
				return employeeList.get(i);
			} else {
				throw new GlobalException("Employee Id not found!!");
			}
		}
		return null;
	}

	public Employee updateEmployee(int index, Employee emp) {
		return employeeList.set(index, emp);
	}

	public Employee findById(int id) {
		Employee emp = null;
		for (int i = 0; i < employeeList.size(); i++) {
			if (employeeList.get(i).getEmpId() == id) {
				emp = employeeList.get(i);
			}
		}
		return emp;
	}

	public int lengthofEmployeeList() {
		return employeeList.size();
	}

	public void removeEmployeeById(int id) {
		for (int i = 0; i < employeeList.size(); i++) {
			if (employeeList.get(i).getEmpId() == id) {
				employeeList.remove(i);
			}
		}
	}

	public void removeAllEmployees() {
		employeeList.clear();
	}

	public double calculateYearlySalary(int id) {
		double yearlySalary = 0.0;
		for (int i = 0; i < employeeList.size(); i++) {
			if (employeeList.get(i).getEmpId() == id) {
				yearlySalary = employeeList.get(i).getSalary() * 12;
			}
		}
		return yearlySalary;
	}

	public double salaryIncrement(int id) {
		double currentSalary = 0.0;
		double increasedSalary = 0.0;
		for (int i = 0; i < employeeList.size(); i++) {
			if (employeeList.get(i).getEmpId() == id) {
				currentSalary = employeeList.get(i).getSalary();
				if (currentSalary < 10000) {
					increasedSalary = currentSalary + 1000;
				} else if (currentSalary > 20000) {
					increasedSalary = currentSalary + 2000;
				} else {
					increasedSalary = currentSalary + 1500;
				}
			}
		}
		return increasedSalary;
	}
}
