package com.cts.student.service;

import java.util.List;
import java.util.Optional;

import com.cts.student.entity.Student;

public interface IStudentService {

	public Integer addStudent(Student student);
	
	Optional<Student> getStudent(Integer sId);
	
	List<Student> getStudentbyClass(String studentClass);
	
	public List<Student> getAllStudents();
	
	public Student updateStudent(Student student, Integer sId);
	
	public void deleteStudent(Integer sId);
	
	public void deleteAllStudents();
	
	
	
}
