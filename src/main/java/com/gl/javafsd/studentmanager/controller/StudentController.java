package com.gl.javafsd.studentmanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gl.javafsd.studentmanager.entity.Student;
import com.gl.javafsd.studentmanager.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@RequestMapping("/begin-add")
	public String handleBeginAdd(Model theModel) {

		Student student = new Student();

		theModel.addAttribute("student", student);

		return "student-form";
	}

	@RequestMapping("/begin-update")
	public String handleBeginUpdate(@RequestParam("studentId") int theId, Model theModel) {

		Student student = studentService.findById(theId);
		theModel.addAttribute("student", student);
		return "student-form";
	}

	@PostMapping("/save")
	public String handleSave(@RequestParam("id") int id, 
			@RequestParam("name") String name,
			// @RequestParam("lastName") String lastName,
			@RequestParam("department") String department, 
			@RequestParam("country") String country) {

		Student student;
		if (id != 0) {
			// Update Student
			student = studentService.findById(id);
			student.setName(name);
			student.setDepartment(department);
			student.setCountry(country);
		} else {

			// Add Student
			student = new Student(id, name, department, country);
		}
		studentService.save(student);
		return "redirect:/students/listing";

	}

	@RequestMapping("/delete")
	public String handleDelete(@RequestParam("studentId") int theId) {
		studentService.deleteById(theId);
		return "redirect:/students/listing";
	}
	
	@RequestMapping("/search")	
	public String handleSearch(
		
		@RequestParam("name") String name,
		@RequestParam("department") String department,
		Model model){
		
		// "   name1   " -> "name1"
		if (name.trim().isEmpty() && department.trim().isEmpty()) {
			
			return "redirect:/students/listing";
		}else {
			
			List<Student> students = studentService.searchBy(name, department);
			
			model.addAttribute("students", students);
			
			return "students-lister";
		}		

}
}
