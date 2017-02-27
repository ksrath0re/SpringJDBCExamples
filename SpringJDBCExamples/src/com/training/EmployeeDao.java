package com.training;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;  
public class EmployeeDao implements RowMapper<Employee>{  
	private JdbcTemplate jdbcTemplate;
	private String tableName;
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {  
		this.jdbcTemplate = jdbcTemplate;  
	}  

	public void createTable(String tableName){
		this.tableName=tableName;
		jdbcTemplate.execute("create table "+tableName+"(empid int(5),name varchar(30),salary double(7,2))");
		System.out.println("table created");
	}
	public int saveEmployee(Employee e){  
		String query="insert into "+tableName+" values('"+e.getId()+"','"+e.getName()+"','"+e.getSalary()+"')";  
		return jdbcTemplate.update(query);  
	}  
	public int updateEmployee(Employee e){  
		String query="update "+tableName+" set name='"+e.getName()+"',salary='"+e.getSalary()+"' where empid='"+e.getId()+"' ";  
		return jdbcTemplate.update(query);  
	}  
	public int deleteEmployee(Employee e){  
		String query="delete from "+tableName+" where empid='"+e.getId()+"' ";  
		return jdbcTemplate.update(query);  
	}
	
	public int displayRecords(){
		String SQL = "select * from "+tableName+"";
		List<Employee> employees= jdbcTemplate.query(SQL,new EmployeeMapper());
		for(int i=0;i<employees.size();i++){
			System.out.print(employees.get(i).getId()+"  ");
			System.out.print(employees.get(i).getName()+"  ");
			System.out.println(employees.get(i).getSalary()+"  ");
		}
		return 0;
		
	}

	@Override
	public Employee mapRow(ResultSet arg0, int arg1) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}  

}  