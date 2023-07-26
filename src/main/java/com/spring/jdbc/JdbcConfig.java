package com.spring.jdbc;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.spring.jdbc.Dao.StudentDao;
import com.spring.jdbc.Dao.StudentDaoImpl;

@Configuration
@ComponentScan(basePackages= {"com.spring.jdbc.Dao"})
public class JdbcConfig {
	//to pass this datasource(metaData) to the JdbcTemplate
	@Bean(name={"ds"})
	public DataSource getDataSource() {
		DriverManagerDataSource ds=new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/springjdbc");
		ds.setUsername("root");
		ds.setPassword("Gazalaparveen@1109");
		return ds;
		
	}
	//JdbcTemplate class object declaration
	@Bean(name= {"jdbcTemplate"})
  public JdbcTemplate getTemplate() {
		JdbcTemplate jdbcTemplate =new JdbcTemplate();
		jdbcTemplate.setDataSource(getDataSource());
	return jdbcTemplate;
		
	  
  }
	//when we do not autowire then we need to declare this bean to get the jdbcTemplate object 
	/*@Bean(name= {"studentDao"})
	public StudentDao getStudentDa() {
		StudentDaoImpl studentDao =new StudentDaoImpl();
		studentDao.setJdbcTemplate(getTemplate());
		return studentDao;
		
	}
	*/
}
