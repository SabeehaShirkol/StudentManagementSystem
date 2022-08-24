package com.cts.student.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.student.entity.Student;
import com.cts.student.exception.RecordNotFoundException;
import com.cts.student.repository.StudentRepository;

@Service
public class StudentServiceImpl implements IStudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public Integer addStudent(Student student) {
		Student saveStudent = studentRepository.save(student);
		return saveStudent.getsId();
	}

	@Override
	public Optional<Student> getStudent(Integer sId) {
		return studentRepository.findById(sId);
	}

	@Override
	public List<Student> getStudentbyClass(String studentClass) {
		return studentRepository.findByStudentClass(studentClass);
	}

	@Override
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	@Override
	public Student updateStudent(Student student, Integer sId) {
		Student existingStudent = studentRepository.findById(sId).orElseThrow(
			()-> new RecordNotFoundException("Student", "sId",sId));
		existingStudent.setFirstName(student.getFirstName());
		existingStudent.setLastName(student.getLastName());
		existingStudent.setSubject(student.getSubject());
		existingStudent.setDob(student.getDob());
		
		studentRepository.save(existingStudent);
		return existingStudent;
	}

	@Override
	public void deleteStudent(Integer sId) {
			studentRepository.deleteById(sId);
	}

	@Override
	public void deleteAllStudents() {
		studentRepository.deleteAll();
	}	
	
}
