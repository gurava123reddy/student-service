package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.client.ResultClient;
import com.example.demo.dto.StudentDTO;
import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;

@RestController
@RequestMapping("/student-service")
public class StudentController {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private ResultClient resultClient;
	
	@PostMapping
	public ResponseEntity<String> saveStudent(@RequestBody StudentDTO studentDTO){
		Student saveStudent = studentRepository.save(studentDTO.getStudent());
		if(saveStudent != null && saveStudent.getStudentId()>0) {
			resultClient.saveResult(studentDTO.getResults(), saveStudent.getStudentId());
		}
		return new ResponseEntity<>("Student "+saveStudent.getStudentName()+ " saved successfully with ID: "+saveStudent.getStudentId(), HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<Student>> getAllStudents(){
		List<Student> students = studentRepository.findAll();
		return new ResponseEntity<>(students, HttpStatus.CREATED);
	}

}
