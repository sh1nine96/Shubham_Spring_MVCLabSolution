package com.gl.javafsd.studentmanager.service;

import java.util.List;

import com.gl.javafsd.studentmanager.entity.Student;

public interface StudentService {

	List<Student> listAll();

	void save(Student student);

	Student findById(int id);

	void deleteById(int theId);

	List<Student> searchBy(String name, String department);

}
