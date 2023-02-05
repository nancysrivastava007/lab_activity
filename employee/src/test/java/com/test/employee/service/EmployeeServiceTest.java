package com.test.employee.service;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;

import com.test.employee.entity.Address;
import com.test.employee.entity.Employee;
import com.test.employee.exception.GlobalException;

@TestMethodOrder(value = OrderAnnotation.class)
public class EmployeeServiceTest {

	private EmployeeService employeeService= new EmployeeService();

	@BeforeEach
	public void setUp() throws Exception {
		//employeeService = new EmployeeService();
	}

	@AfterEach
	public void tearDown() throws Exception {
		employeeService = null;
		System.out.println("objetc is garbage collected !!");
	}

	@Test
	@Order(1)
	@DisplayName("Testing add employee method")
	public void testAddEmployee() {
		Address add = Address.builder().city("Pune").country("india").build();
		Employee emp = Employee.builder().empId(123).name("Nancy").salary(35000).address(add).build();
		employeeService.addEmployee(emp);
		int length = employeeService.lengthofEmployeeList();
		assertTrue(length > 0);
	}

	@Test
	@Order(3)
	@DisplayName("Testing display employee by Id")
	public void testDisplayByEmpId() throws GlobalException {
		Address add = Address.builder().city("Pune").country("India").build();
		Employee emp = Employee.builder().empId(123).name("Nancy").salary(35000).address(add).build();
		employeeService.addEmployee(emp);
		Employee e = employeeService.getEmployeeById(123);
		assertEquals(35000.00, e.getSalary());
	}

	@Test
	@Order(2)
	@DisplayName("Testing update employee")
	public void testUpdateEmployee() {
		Address add = Address.builder().city("Pune").country("India").build();
		Employee emp = Employee.builder().empId(123).name("Nancy").salary(35000).address(add).build();
		employeeService.addEmployee(emp);
		Employee e = employeeService.findById(123);
		e.setName("Srivastava");
		employeeService.updateEmployee(0, e); // updating the employee details
		employeeService.displayAllEmployees();
		assertEquals("Srivastava", e.getName());
	}

	@Test
	@Order(5)
	@DisplayName("Deleting all employee details")
	public void testDeleteAllDetails() {
		employeeService.removeAllEmployees(); // removing all the details of employee
		System.out.println("All details of employee  are removed");
		employeeService.displayAllEmployees();
	}

	@Test
	public void testRemoveEmployeeById() {
		Address add = Address.builder().city("Pune").country("India").build();
		Employee emp = Employee.builder().empId(145).name("TestUser").salary(30000).address(add).build();
		employeeService.addEmployee(emp);
	}

	@Test
	public void testCalculateYearlySalary() {
		Address add = Address.builder().city("Pune").country("India").build();
		Employee emp = Employee.builder().empId(145).name("TestUser").salary(30000).address(add).build();
		employeeService.addEmployee(emp);

		double sal = employeeService.calculateYearlySalary(145);
		assertEquals(360000, sal);
	}

	@Test
	public void testSalaryIncrement() {
		Address add = Address.builder().city("Pune").country("India").build();
		Employee emp = Employee.builder().empId(145).name("Nancy").salary(30000).address(add).build();
		employeeService.addEmployee(emp);

		double increasedSalary = employeeService.salaryIncrement(145);
		assertEquals(32000, increasedSalary);
	}

}
