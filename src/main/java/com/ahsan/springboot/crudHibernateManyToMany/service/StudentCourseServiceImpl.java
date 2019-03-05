package com.ahsan.springboot.crudHibernateManyToMany.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ahsan.springboot.crudHibernateManyToMany.dao.StudentCourseDAO;
import com.ahsan.springboot.crudHibernateManyToMany.entity.Student;

@Service
public class StudentCourseServiceImpl implements StudentCourseService {

	private StudentCourseDAO studentDAO;

	@Autowired
	public StudentCourseServiceImpl(StudentCourseDAO studentDAO) {
		this.studentDAO = studentDAO;
	}

	@Override
	@Transactional
	public List<Student> findAll() {

		return studentDAO.findAll();
	}

	@Override
	@Transactional
	public Student findById(int theId) {
		return studentDAO.findById(theId);
	}

	@Override
	@Transactional
	public void save(Student theStudent) {
		studentDAO.save(theStudent);
		
	}

}
