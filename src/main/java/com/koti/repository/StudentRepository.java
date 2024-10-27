package com.koti.repository;

import java.util.List;

import com.koti.entity.Student;

public interface StudentRepository {

	int createStudent(Student student);
	
	Student getStudentById(int rollNo);
	
	void updateStudent(Student student);
	List<Student> fetchAllStudents();
	void deleteStudentById(int rollNo);
}
