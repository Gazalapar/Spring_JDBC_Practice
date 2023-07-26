package com.spring.jdbc.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.spring.jdbc.entities.Student;
@Component("studentDao")
public class StudentDaoImpl  implements StudentDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}


	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}


	@Override
	public int insert(Student student) {
		String query="insert into student(id,name,city)values(?,?,?)";
		int r=this.jdbcTemplate.update(query, student.getId(),student.getName() ,student.getCity());
		
		
	 return r;
	}


	@Override
	public int change(Student student) {
		String query="update student set name=? ,city=? where id=?";
		int r=this.jdbcTemplate.update(query, student.getName(),student.getCity(),student.getId());
		
		return r;
	}


	@Override
	public int delete(int studentId) {
		String query="delete from student where id=?";
		int r=this.jdbcTemplate.update(query,studentId);
		
		return r;
	}


	@Override
	public Student getStudent(int studentId) {
		//selecting single object 
	     String query="select *from student where id=?";
	     RowMapper<Student> rowMapper=new RowMapperImpl();
	   Student student= this.jdbcTemplate.queryForObject(query, rowMapper, studentId);
	     
		return student;
	}


	@Override
	public List<Student> getAllStudents() {
		// selecting multiple students
		String query="select * from student";
		List<Student> students=this.jdbcTemplate.query(query,new RowMapperImpl());
		return students;
	}

	
	
	

}
