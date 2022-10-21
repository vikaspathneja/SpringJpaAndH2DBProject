package com.example.springwithjpa.SpringJpaAndH2DBProject.springjdbcexample;

import java.io.Serializable;

import org.springframework.web.bind.annotation.InitBinder;

public class Course implements Serializable {
	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private String author;

	public Course() {
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", author=" + author + "]\n";
	}

	public Course(Integer id, String name, String author) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
	}
	@InitBinder
	public void init() {
		System.out.println("init method called");
	}

}
