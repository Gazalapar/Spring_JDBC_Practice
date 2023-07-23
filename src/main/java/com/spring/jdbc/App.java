package com.spring.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.jdbc.Dao.StudentDao;
import com.spring.jdbc.entities.Student;

public class App {
public static void main(String[] args) {
	System.out.println("Hello");
	//spring jdbc=>jdbcTemplate
	ApplicationContext context=new ClassPathXmlApplicationContext("com/spring/jdbc/config.xml");
	//JdbcTemplate  template =context.getBean("jdbcTemplate",JdbcTemplate.class);
	//insert query
	//String query="insert into student(id,name,city)values(?,?,?)";
	//fire query
	//int result=template.update(query,344, "Isha","GKP");
	//System.out.println("number of record inserted.."+result);
	StudentDao studentDao=context.getBean("studentDao" ,StudentDao.class);
	Student student=new Student();
	/*student.setId(666);
	student.setName("Satakshi");
	student.setCity("GKP");
	int result=studentDao.insert(student);
	System.out.println("student added"+ result);*/
	/*student.setId(344);
	student.setName("Ayehsa");
	student.setCity("Lucknow");
	int res=studentDao.change(student);
	System.out.println("data changed"+ res);*/
	
	int res=studentDao.delete(666);
	System.out.println("delete operation "+ res);
	
	
	
	
	
	
	
}
}
