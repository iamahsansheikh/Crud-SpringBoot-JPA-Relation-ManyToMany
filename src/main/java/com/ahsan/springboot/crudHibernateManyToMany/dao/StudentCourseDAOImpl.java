package com.ahsan.springboot.crudHibernateManyToMany.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ahsan.springboot.crudHibernateManyToMany.entity.Course;
import com.ahsan.springboot.crudHibernateManyToMany.entity.Student;

@Repository
public class StudentCourseDAOImpl implements StudentCourseDAO {

	// define field for entity manager
	private EntityManager entityManager;

	// set up constructor injection
	@Autowired
	public StudentCourseDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Student> findAll() {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// create a query
		Query<Student> theQuery = currentSession.createQuery("from Student ", Student.class);

		// execute query and get a result list
		List<Student> students = theQuery.getResultList();

		// return the results
		return students;
	}

	@Override
	public Student findById(int theId) {

		Session currentSession = entityManager.unwrap(Session.class);

		Student theStudents = currentSession.get(Student.class, theId);

		return theStudents;
	}

	@Override
	public void save(Student theStudent) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(theStudent);

	}

}
