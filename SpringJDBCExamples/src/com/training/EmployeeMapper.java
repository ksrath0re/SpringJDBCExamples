package com.training;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

public class EmployeeMapper implements RowMapper<Employee> {


	@Override
	public Employee mapRow(ResultSet rs, int arg1) throws SQLException {
		Employee emp = new Employee();
		emp.setId(rs.getInt("empid"));
		emp.setName(rs.getString("name"));
		emp.setSalary(rs.getFloat("salary"));
		return emp;
	}
}