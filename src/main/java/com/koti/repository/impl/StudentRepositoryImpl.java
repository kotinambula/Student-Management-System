package com.koti.repository.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.koti.entity.Student;
import com.koti.repository.StudentRepository;
import com.koti.rowmapper.StudentRowMapper;

@Repository
public class StudentRepositoryImpl implements StudentRepository {
	
	@Autowired
	private JdbcTemplate template;
	@Autowired
	private StudentRowMapper mapper;
	private static final Logger logger = LoggerFactory.getLogger(StudentRepositoryImpl.class);

	@Override
	public int createStudent(Student student) {
		logger.info("Request from service class to save student with details of : name={},age={},gender={},department={}",
				student.getName(),student.getAge(),student.getGender(),student.getDepartment());
		String sql = "CALL create_Student(?, ?, ?, ?)";
		logger.debug("Execute a Procedure Query To save student :{}, with values : name={},age={},gender={},department={}",
				sql,student.getName(),student.getAge(),student.getGender(),student.getDepartment() );
		try
		{
			int rowsEffected = template.update(sql,student.getName(),student.getAge(),student.getGender(),student.getDepartment());
			logger.info("Saving Student Done : {},rows effected : {}",student,rowsEffected);
			return rowsEffected;
		}
		catch (Exception e) {
			logger.error("Error Occured While Saving Student",e);
			throw e;
		}
		
		
	}

	@Override
	public Student getStudentById(int rollNo) {
		logger.info("Request from service to get employee by this roll number : {}",rollNo);
		String sql = "CALL get_Student(?)";
		logger.debug("Execute sql query : {}, to fetch student with roll number : {}",sql,rollNo);
		try
		{
			Student student = template.queryForObject(sql,new StudentRowMapper(),rollNo);
			logger.info("Student with Roll Number : {},fetched sucessfully : {}",rollNo,student);
		return student;
		}
		catch (Exception e) {
			logger.error("Error Occured while fetching student details with roll number : {}",rollNo,e);
			throw e;
		}
	}

	@Override
	public void updateStudent(Student student) {
		logger.info("Request from service class to update the student details by their roll number : {}",student.getRollNo());
		String sql = "CALL update_Student(?,?,?,?,?)";
		logger.debug("Execute update query :{} with values : roll number={},name={},age={},gender={},department={} ",sql,student.getRollNo(),student.getName(),student.getAge()
				,student.getGender(),student.getDepartment());
		try {
			template.update(sql,student.getRollNo(),student.getName(),student.getAge()
				,student.getGender(),student.getDepartment());
			logger.info("Student updated Sucessfully");
		} catch (Exception e) {
			logger.error("Error occured while updating student details with his roll number : {} ",student.getRollNo(),e);
			throw e;
		}
		
	}

	@Override
	public List<Student> fetchAllStudents() {
		logger.info("Request from service to get all students details");
		String sql = "CALL get_All_Students()";
		logger.debug("Execute sql query to fetch all students details : {}",sql);
		try {
			List<Student> students = template.query(sql, new StudentRowMapper());
			logger.info("Fetching all student details done : {} ",students);
			return students;
			
		} catch (Exception e) {
			logger.error("Error Occured while fetching students details",e);
			throw e;
		}
	}

	@Override
	public void deleteStudentById(int rollNo) {
		logger.info("Request from service to delete student details with roll number : {} ",rollNo);
		String sql = "CALL delete_Student(?)";
		logger.debug("Execute sql query to delete student details :{}, with roll number : {}",sql,rollNo);
		try {
			template.update(sql,rollNo);
			logger.info("Student with roll number : {} deleted sucessfully ",rollNo);
			
		} catch (Exception e) {
			logger.error("Error Occured while deleting student details with roll number : {} ",rollNo,e);
			throw e;
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
