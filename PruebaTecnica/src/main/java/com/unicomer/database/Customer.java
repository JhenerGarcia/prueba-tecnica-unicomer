package com.unicomer.database;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "CUSTOMER")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String customerId;
	private String firstName;
	private String lastName;
	private String birthday;
	private String gender;
	private String cellPhone;
	private String homePhone;
	private String homeAddress;
	private String profession;
	private String income;

}
