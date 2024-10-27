package com.koti.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koti.entity.Student;
import com.koti.repository.StudentRepository;
import com.koti.repository.impl.StudentRepositoryImpl;
import com.koti.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository repo;
	
	private static final Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);
	@Override
	public void createStudent(Student student) {
		logger.info("Request from controller class to save Student with these values : {}",student);
		repo.createStudent(student);
		logger.info("Student saved successfully");
		
	}

	@Override
	public Student getStudentById(int rollNo) {
		logger.info("Request from controller to get students details with roll number : {} ",rollNo);
		try
		{
			Student student = repo.getStudentById(rollNo);
			logger.info("Student with roll number : {},founded : {}",rollNo,student);
			return student;
		}
		catch (Exception e) {
			logger.error("Error Occured while fetching student details with roll number : {}",rollNo,e);
			throw e;
		}
		
	}

	@Override
	public void updateStudent(Student student) {
		
		logger.info("Request from controller class to update student details with roll number : {} ",student.getRollNo());
		try {
			repo.updateStudent(student);
			logger.info("Student with roll number : {} updated sucessfully : {} ",student.getRollNo(),student);
		} catch (Exception e) {
           logger.error("Error occured while updating student details with roll number : {} ",student.getRollNo(),e);
           throw e;
		}
	}

	@Override
	public List<Student> fetchAllStudents() {
		logger.info("Request from controller to get all students details");
		try {
			List<Student> allStudents = repo.fetchAllStudents();
			logger.info("Fetching all student details done : {} ",allStudents);
			return allStudents;
		} catch (Exception e) {
			logger.error("Error Occured while fetching students details",e);
			throw e;
		}
		
	}

	@Override
	public void deleteStudentById(int rollNo) {
		logger.info("Request from controller to delete student details with roll number : {} ",rollNo);
		try {
			repo.deleteStudentById(rollNo);
			logger.info("Student with roll number : {} deleted sucessfully ",rollNo);
		} catch (Exception e) {
			logger.error("Error Occured while deleting student details with roll number : {} ",rollNo,e);
			throw e;
		
	}

}
}
