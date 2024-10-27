package com.koti.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.koti.entity.Student;
import com.koti.service.StudentService;

@RestController
@RequestMapping("/api/students")
public class StudentController {

	@Autowired
	private StudentService service;
	private static final Logger logger = LoggerFactory.getLogger(StudentController.class);
	
	@PostMapping("/save")
	public String createStudent(@RequestBody Student student)
	{
		logger.info("Request from client to save student with values : {}",student);
		try
		{
		service.createStudent(student);
		logger.info("student saved successfully");
		return "Student Saved ";
		}
		catch (Exception e) {
			logger.error("Error occured while saving student",e);
			throw e;
		}
	}
	
	@GetMapping("/{rollNo}")
	public Student fetchStudentByRollNumber(@PathVariable int rollNo)
	{
		logger.info("Request from client to fetch student details with the roll number : {}",rollNo);
		try {
			
			Student student = service.getStudentById(rollNo);
			logger.info("Student with roll number : {},Founded Sucessfully : {}",rollNo,student);
			return student;
		} catch (Exception e) {
			logger.error("Error occured while fetching student details with roll number : {}",rollNo,e);
			throw e;
		}
	}
	
	@PutMapping("/{rollNo}")
	public Student updateStudent(@RequestBody Student student,@PathVariable int rollNo)
	{
		student.setRollNo(rollNo);
		logger.info("Request from client to update student details with roll number : {}",rollNo);
		try {

			service.updateStudent(student);
			logger.info("Student with roll number : {},updated : {}",rollNo,student);
		return student;
		} catch (Exception e) {
			logger.error("Error occured while updating student details with his roll number : {} ",rollNo,e);
			throw e;
		}
	}
		
	@GetMapping("/all")
		public List<Student> getAllStudents()
		{
			logger.info("Request from client to fetch all students details");
			try {
				List<Student> allStudents = service.fetchAllStudents();
				logger.info("Fetching all student details done : {} ",allStudents);
				return allStudents;
			} catch (Exception e) {
				logger.error("Error occured while fetching all students details");
				throw e;
			}
		}
		
	@DeleteMapping("/{rollNo}")
		public String deleteStudent(@PathVariable int rollNo)
		{
			logger.info("Request from client to delete student details with roll number : {} ",rollNo);
			try {
				service.deleteStudentById(rollNo);
				return "Student with roll number "+rollNo+" deleted sucessfully";
			} catch (Exception e) {
				logger.error("Error Occured while deleting student details with roll number : {} ",rollNo,e);
				throw e;
		}
		
		
		
	}
}
