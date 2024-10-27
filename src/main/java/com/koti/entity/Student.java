package com.koti.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

	private int rollNo;
	private String name;
	private int age;
	private String gender;
	private String department;
	
}
