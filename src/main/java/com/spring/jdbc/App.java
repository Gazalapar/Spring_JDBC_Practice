package com.spring.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.jdbc.Dao.StudentDao;
import com.spring.jdbc.entities.Student;

public class App {
public static void main(String[] args) {
	System.out.println("Hello");
	//spring jdbc=>jdbcTemplate
	//when we declare bean using xml we use the below declaration
	//ApplicationContext context=new ClassPathXmlApplicationContext("com/spring/jdbc/config.xml");
	
	//when we declare the bean using Annotation we use the given declartion
	ApplicationContext context=new AnnotationConfigApplicationContext(JdbcConfig.class);
	JdbcTemplate  template =context.getBean("jdbcTemplate",JdbcTemplate.class);
	
	//insert query
	/*String query="insert into student(id,name,city)values(?,?,?)";
	//fire query
	int result=template.update(query,345, "Kulsum","GKP");
	System.out.println("number of record inserted.."+result);*/
	
	StudentDao studentDao=context.getBean("studentDao" ,StudentDao.class);
	Student student=new Student();
	
	////update query
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
	
	///Delete query
/*	int res=studentDao.delete(666);
	System.out.println("delete operation "+ res);  */
	
	
	//Selecting single object
/*	Student student1=studentDao.getStudent(344);
	System.out.println(student1);*/
	
	//selecting multiple objects
	List<Student> students=studentDao.getAllStudents();
	for(Student s:students) {
		System.out.println(s);
	}
	
	
	
	
}
}
