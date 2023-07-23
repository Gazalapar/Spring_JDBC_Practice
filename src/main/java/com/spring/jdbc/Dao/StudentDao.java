package com.spring.jdbc.Dao;

import com.spring.jdbc.entities.Student;

public interface StudentDao {
    public int insert(Student student);
    public int change(Student student);
    public int delete(int studentId);
}
