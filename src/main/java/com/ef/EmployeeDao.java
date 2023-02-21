package com.ef;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

public class EmployeeDao {
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	public Boolean saveEmployeeUsingPreparedStatement(Employee e){
		String myQuery = "insert into employee2 values(?,?)";
		return jdbcTemplate.execute(myQuery, new PreparedStatementCallback<Boolean>() {
			@Override
			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setInt(1, e.getId());
				ps.setString(2, e.getName());
				return ps.execute();
			}
			});			
	}
	public List<Employee> findAllEmployeesByResultSetExtractor(){
		return jdbcTemplate.query("select * from employee2", new ResultSetExtractor<List<Employee>>() {

			@Override
			public List<Employee> extractData(ResultSet rs) throws SQLException, DataAccessException {
				 List<Employee> elist = new ArrayList<Employee>();
				 while(rs.next()) {
					 Employee e = new Employee();
					 e.setId(rs.getInt(1));
					 e.setName(rs.getString(2));
					 elist.add(e);
				 }
				return elist;
			}
			
		});
		
	}
	public List<Employee> findAllEmployeesByRowMapper(){
		return jdbcTemplate.query("select * from employee2", new RowMapper<Employee>() {

			@Override
			public Employee mapRow(ResultSet rs, int rownum) throws SQLException, DataAccessException {
				
					 Employee e = new Employee();
					 e.setId(rs.getInt(1));
					 e.setName(rs.getString(2));
					 
				 
				return e;
			}
			
		});
		
	}
	public int saveEmployee(Employee e) {
		String myQuery = "insert into employee2 values('"+e.getId()+"','"+e.getName()+"')";
		return jdbcTemplate.update(myQuery);
	}
	public int updateEmployee(Employee e) {
		String myQuery = "update employee2 set name='"+e.getName()+"' where id='"+e.getId()+"'";
		return jdbcTemplate.update(myQuery);
	}
	public int deleteEmployee(Employee e) {
		String myQuery = "delete from employee2 where id="+e.getId()+"";
		return jdbcTemplate.update(myQuery);
	}

}
