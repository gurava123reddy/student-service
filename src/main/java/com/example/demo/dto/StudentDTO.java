package com.example.demo.dto;

import java.util.List;

import com.example.demo.entity.Result;
import com.example.demo.entity.Student;

public class StudentDTO {
	
	private Student student;
	private List<Result> results;
	
	public StudentDTO() {}

	public StudentDTO(Student student, List<Result> results) {
		super();
		this.student = student;
		this.results = results;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public List<Result> getResults() {
		return results;
	}

	public void setResults(List<Result> results) {
		this.results = results;
	}
}
