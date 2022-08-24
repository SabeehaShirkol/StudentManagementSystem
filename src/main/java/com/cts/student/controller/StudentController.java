package com.cts.student.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cts.student.entity.Student;
import com.cts.student.service.IStudentService;

@RestController
@RequestMapping("/api/studentmanagement")
public class StudentController {
	
	@Autowired
	private IStudentService studentService;
	
	@PostMapping("/student")
	public Integer createStudent(@RequestBody Student student) {
		Integer sId = studentService.addStudent(student);
		System.out.println(sId);
		return sId;
	}
	
	@GetMapping("/allstudents")
	public List<Student> getStudent() {
		return studentService.getAllStudents();
	}
	
	@GetMapping("/student/studentClass")
	public List<Student> getStudentByClass(@RequestParam String studentClass) {
		List<Student> studentbyClass = studentService.getStudentbyClass(studentClass);
		return studentbyClass;
	}
	
	
	@GetMapping("/student/{sId}")
	public Optional<Student> getStudent(@PathVariable Integer sId) {
		Optional<Student> student = studentService.getStudent(sId);
		return student;
	}
	
	@DeleteMapping("/student/{sId}")
	public ResponseEntity<Student> deleteStudent(@PathVariable Integer sId) {
		System.out.println(sId);
		ResponseEntity<Student> responseEntity = new ResponseEntity<>(HttpStatus.OK);
		try {
			studentService.deleteStudent(sId);
		}
		catch(Exception e) {
			e.printStackTrace();
			responseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return responseEntity;
	}
	
	@DeleteMapping("/allstudents")
	public void deleteStudent() {
		studentService.deleteAllStudents();
	}
	
	
	@PutMapping("/update/{sId}")
	public ResponseEntity<Student> updateStudent(@PathVariable("sId") Integer sId, @RequestBody Student student) {
		return new ResponseEntity<Student>(studentService.updateStudent(student, sId), HttpStatus.OK);
	}
	

}
