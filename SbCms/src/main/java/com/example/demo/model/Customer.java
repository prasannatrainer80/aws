package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

	@Id
	@Column(name="CUS_ID")
	private int cusId;
	@Column(name="CUS_NAME")
	private String cusName;
	@Column(name="CUS_PHN_NO")
	private String cusPhnNo;
	@Column(name="CUS_USERNAME")
	private String cusUserName;
	@Column(name="CUS_PASSWORD")
	private String cusPassword;
	@Column(name="CUS_EMAIL")
	private String cusEmail;
}
