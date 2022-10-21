package com.example.springwithjpa.SpringJpaAndH2DBProject.springjdbcexample;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SpringJdbcCourseRepo {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private final String inser_course_sql="insert into course values(?,?,?)";
	private final String delete_course_sql="delete from course where id=?";
	private final String select_course_sql="select * from course";
	private final String select_course_by_id_sql="select * from course where id=?";
					
	public void insert(Course course){
		jdbcTemplate.update(inser_course_sql,course.getId(),course.getName(),course.getAuthor());
	}
	public void deleteCourse(Integer cid) {
		jdbcTemplate.update(delete_course_sql,cid);
	}
	
	public List<Course> findAllCourse() {
		  BeanPropertyRowMapper<Course> rowMapper = BeanPropertyRowMapper.newInstance(Course.class);
	        List<Course> courses = jdbcTemplate.query(select_course_sql, rowMapper);
	        return courses;
		
	}
	public Course findCourseByid(Integer cid) {
		  BeanPropertyRowMapper<Course> rowMapper = BeanPropertyRowMapper.newInstance(Course.class);
	        Course course = jdbcTemplate.queryForObject(select_course_by_id_sql, rowMapper,cid);
	        return course;
		
	}
	
}
