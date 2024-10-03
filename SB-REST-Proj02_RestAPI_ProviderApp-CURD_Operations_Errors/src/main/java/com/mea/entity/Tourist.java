package com.mea.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "REST_JPA_TOURIST")
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class Tourist {

	@Id
	@SequenceGenerator(name = "gen1",sequenceName = "TID_SEQ",initialValue = 1,allocationSize = 1)
	@GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)
	private Integer tid;
	@NonNull
	@Column(length = 20)
	private String tname;
	@NonNull
	@Column(length = 40)
	private String taddress;
	@NonNull
	@Column(length = 20)
	private String tpackage;
	@NonNull
	private Double tbudget;
}
