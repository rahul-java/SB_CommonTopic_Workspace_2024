package com.mea.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "emp")
@Data
public class Employee {

	@Id
	@SequenceGenerator(name = "gen1" , sequenceName = "emp_seq1" , initialValue = 1000)
	@GeneratedValue(generator = "gen1", strategy = GenerationType.SEQUENCE)
	private Integer empNo;
	private String empName;
	private String job="CLERK";
	private Double salary;
	private Integer deptNo;
}
