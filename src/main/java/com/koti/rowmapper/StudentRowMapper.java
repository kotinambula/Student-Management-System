package com.koti.rowmapper;


import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.koti.entity.Student;

@Component
public class StudentRowMapper implements RowMapper<Student> {

	private static final Logger logger = LoggerFactory.getLogger(StudentRowMapper.class);
	@Override
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		Student student = new Student(
				rs.getInt("roll_number"),
				rs.getString("name"),
				rs.getInt("age"),
				rs.getString("gender"),
				rs.getString("department"));
		logger.debug("Mapper Student : {}",student);
		return student;
	}

}
