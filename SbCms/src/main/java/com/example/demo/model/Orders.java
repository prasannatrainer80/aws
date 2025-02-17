package com.example.demo.model;

import java.sql.Date;

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
public class Orders {

	@Id
	private int ordId;
	private int cusId;
	private int venId;
	private int menId;
	private String walSource;
	private Date ordDate;
	private int ordQuantity;
	private double ordBillamount;
	private String ordStatus;
	private String ordComments;
}
