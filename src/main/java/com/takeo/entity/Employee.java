package com.takeo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Employee")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

	@Id
	@Column(name = "enumber")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@Transient // it does not participate in parameterized constructor
	private int eno;

	@Column(name = "e_name")
	private String eName;

	@Column(name = "email")
	private String email;

	@Column(name = "address")
	private String address;
	
	public Employee(String eName, String email, String address) {
		super();
		this.eName = eName;
		this.email = email;
		this.address = address;
	}
}
