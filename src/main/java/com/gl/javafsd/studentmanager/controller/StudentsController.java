package com.gl.javafsd.studentmanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gl.javafsd.studentmanager.entity.Student;
import com.gl.javafsd.studentmanager.service.StudentService;

@Controller
@RequestMapping("/students")
public class StudentsController {

	@Autowired
	private StudentService studentService;

	@RequestMapping("/listing")
	public String handleStudentsListing(Model model) {
		List<Student> students = studentService.listAll();
		model.addAttribute("students", students);
		return "students-lister";
	}

}
