package com.ahsan.springboot.crudHibernateManyToMany.dao;

import java.util.List;

import com.ahsan.springboot.crudHibernateManyToMany.entity.Student;

public interface StudentCourseDAO {

	public List<Student> findAll();
	
	public Student findById(int theId);
	
	public void save(Student theStudent);

}
