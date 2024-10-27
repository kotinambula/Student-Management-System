package com.koti.service;

import java.util.List;

import com.koti.entity.Student;

public interface StudentService {

void createStudent(Student student);
	
	Student getStudentById(int rollNo);
	
	void updateStudent(Student student);
	List<Student> fetchAllStudents();
	void deleteStudentById(int rollNo);
}
