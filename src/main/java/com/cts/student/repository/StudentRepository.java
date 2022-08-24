package com.cts.student.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.student.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

	public List<Student> findByStudentClass(String studentClass);

}
