package com.mea.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mea.entity.Employee;
import com.mea.errors.EmployeeNotFoundException;
import com.mea.repository.IEmployeeRepository;

@Service
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {

	@Autowired
	private IEmployeeRepository empRepo;
	
	@Override
	public Iterable<Employee> showAllEmployee() {

		return empRepo.findAll();
	}

	@Override
	public String registerEmployee(Employee emp) {

		Employee save = empRepo.save(emp);
		return "Employee Record is inserted with id value :"+save.getEmpNo();
	}

	@Override
	public Employee fetchEmployeeById(Integer id) throws EmployeeNotFoundException {
		//return empRepo.findById(id).orElseThrow(()->new IllegalArgumentException("Invalid Emp No"));
		return empRepo.findById(id).orElseThrow(()->new EmployeeNotFoundException("Invalid Emp No"));
	}

	@Override
	public String updateEmployee(Employee emp) {
		Optional<Employee> optional=empRepo.findById(emp.getEmpNo());
		if(optional.isPresent())
		{
			Employee saved = empRepo.save(emp);
			return "Employee with id : "+saved.getEmpNo()+" is updated successfully.";
		}
		
		return "Employee with id : "+emp.getEmpNo()+" is not found for updation.";
	}

	@Override
	public String deleteEmployeeById(Integer id) {
		Optional<Employee> optional=empRepo.findById(id);
		if(optional.isPresent())
		{
			empRepo.deleteById(id);
			return "Employee with id : "+id+" is deleted successfully.";
		}
		
		return "Employee with id : "+id+" is not found for deletion.";
	}

}
