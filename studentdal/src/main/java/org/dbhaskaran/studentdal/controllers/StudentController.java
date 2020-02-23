package org.dbhaskaran.studentdal.controllers;

import java.util.List;

import org.dbhaskaran.studentdal.entities.Student;
import org.dbhaskaran.studentdal.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudentController {

	@Autowired
	StudentServiceImpl studentService;

	@RequestMapping("/createStudent")
	public String showCreate() {
		return "createStudent";
	}

	@RequestMapping("/saveStudent")
	public String saveStudent(@ModelAttribute("student") Student student, ModelMap modelMap) {
		if (student.getName() != null) {
			Student savedStu = studentService.saveStudent(student);
			String msg = "Student saved with ID: " + savedStu.getId();
			modelMap.addAttribute("msg", msg);
		}
		return "createStudent";
	}

	@RequestMapping("/displayStudents")
	public String displayStudents(ModelMap modelMap) {
		List<Student> allStudents = studentService.getAllStudents();
		modelMap.addAttribute("students", allStudents);
		return "displayStudents";
	}

	@RequestMapping("/deleteStudent")
	public String deleteStudent(@RequestParam("id") int id, ModelMap modelMap) {
		Student savedStu = studentService.getStudentbyId(id);
		studentService.deleteStudent(savedStu);
		List<Student> allStudents = studentService.getAllStudents();
		modelMap.addAttribute("students", allStudents);
		return "displayStudents";
	}

	@RequestMapping("/editStudent")
	public String editStudent(@RequestParam("id") int id, ModelMap modelMap) {
		Student savedStu = studentService.getStudentbyId(id);
		modelMap.addAttribute("student", savedStu);
		return "editStudent";
	}

	@RequestMapping("/updateStudent")
	public String updateStudent(@ModelAttribute("student") Student student, ModelMap modelMap) {
		studentService.updateStudent(student);
		List<Student> allStudents = studentService.getAllStudents();
		modelMap.addAttribute("students", allStudents);
		return "displayStudents";
	}

}
