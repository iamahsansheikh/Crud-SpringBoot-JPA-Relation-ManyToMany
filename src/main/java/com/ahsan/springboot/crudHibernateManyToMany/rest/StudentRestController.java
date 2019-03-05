package com.ahsan.springboot.crudHibernateManyToMany.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ahsan.springboot.crudHibernateManyToMany.entity.Student;
import com.ahsan.springboot.crudHibernateManyToMany.service.StudentCourseService;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	private StudentCourseService studentCourseService;

	@Autowired
	public StudentRestController(StudentCourseService studentCourseService) {
		this.studentCourseService = studentCourseService;
	}

	@GetMapping("/students")
	public List<Student> findAll() {
		return studentCourseService.findAll();
	}
	
	@GetMapping("/students/{studentId}")
	public Student findById(@PathVariable int studentId) {
		Student theStudent = studentCourseService.findById(studentId);
		if(theStudent == null) {
			throw new StudentNotFoundException("Student ID not found - " + studentId);
		}
		return theStudent;
	}
	
	@PostMapping("/students")
	public Student addStudent(@RequestBody Student theStudent) {
		theStudent.setId(0);
		studentCourseService.save(theStudent);
		return theStudent;
	}
	
}
