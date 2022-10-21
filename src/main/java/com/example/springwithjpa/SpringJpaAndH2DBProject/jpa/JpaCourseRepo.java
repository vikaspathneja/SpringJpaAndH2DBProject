package com.example.springwithjpa.SpringJpaAndH2DBProject.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;


@Repository
@Transactional
public class JpaCourseRepo {
	@PersistenceContext
	private EntityManager entityManager;
	
					
	public void insert(NewCourse course){
		entityManager.merge(course);
	}
	public void deleteCourse(Integer cid) {
		NewCourse course=entityManager.find(NewCourse.class, cid);
		entityManager.remove(course);
	}
	
	
	public NewCourse findCourseByid(Integer cid) {
		return entityManager.find(NewCourse.class, cid);
	}
	
}
