package com.mea.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mea.entity.Employee;

public interface IEmployeeRepository extends JpaRepository<Employee, Integer>{

}
