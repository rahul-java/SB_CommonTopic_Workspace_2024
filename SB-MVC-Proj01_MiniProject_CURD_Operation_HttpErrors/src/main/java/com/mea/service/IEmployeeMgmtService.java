package com.mea.service;

import com.mea.entity.Employee;
import com.mea.errors.EmployeeNotFoundException;

public interface IEmployeeMgmtService {

	public Iterable<Employee> showAllEmployee();
	public String registerEmployee(Employee emp);
	public Employee fetchEmployeeById(Integer id) throws EmployeeNotFoundException;
	public String updateEmployee(Employee emp);
	public String deleteEmployeeById(Integer id);
}
