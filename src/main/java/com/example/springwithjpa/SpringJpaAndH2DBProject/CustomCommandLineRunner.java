package com.example.springwithjpa.SpringJpaAndH2DBProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.springwithjpa.SpringJpaAndH2DBProject.jpa.JpaCourseRepo;
import com.example.springwithjpa.SpringJpaAndH2DBProject.jpa.NewCourse;
import com.example.springwithjpa.SpringJpaAndH2DBProject.springjdbcexample.Course;
import com.example.springwithjpa.SpringJpaAndH2DBProject.springjdbcexample.SpringJdbcCourseRepo;

@Component
public class CustomCommandLineRunner implements CommandLineRunner {

	@Autowired
	JpaCourseRepo courseRepo;

	@Autowired
	SpringJdbcCourseRepo springJdbcCourseRepo;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("-----------spring jpa operation--------------");
		courseRepo.insert(new NewCourse(2, "jpaazure", "jpaauthor1"));
		courseRepo.insert(new NewCourse(3, "jpagcloud", "jpaauthor2"));
		System.out.println("----delete course 3-------");
		courseRepo.deleteCourse(3);
		System.out.println("-----findding course 2--------");
		System.out.println(courseRepo.findCourseByid(2));

		System.out.println();
		System.out.println("-----------spirng jdbc operation--------------");
		springJdbcCourseRepo.insert(new Course(2, "jpaazure", "jpaauthor1"));
		springJdbcCourseRepo.insert(new Course(3, "jpagcloud", "jpaauthor2"));
		System.out.println(springJdbcCourseRepo.findAllCourse());
		springJdbcCourseRepo.deleteCourse(1);
		System.out.println(springJdbcCourseRepo.findAllCourse());
		System.out.println();
		System.out.println(springJdbcCourseRepo.findCourseByid(2));

	}

}
