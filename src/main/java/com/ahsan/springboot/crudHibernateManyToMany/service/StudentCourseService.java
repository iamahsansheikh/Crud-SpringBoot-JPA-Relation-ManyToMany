package com.ahsan.springboot.crudHibernateManyToMany.service;

import java.util.List;

import com.ahsan.springboot.crudHibernateManyToMany.entity.Student;

public interface StudentCourseService {

	public List<Student> findAll();

	public Student findById(int theId);
	
	public void save(Student theStudent);
}
