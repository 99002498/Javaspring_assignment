package com.studentapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.studentapp.exception.StudentNotFoundException;
import com.studentapp.model.Student;
import com.studentapp.service.StudentService;

@RestController
@RequestMapping("/student-api")
public class StudentResponseController {
	@Autowired
	StudentService studentService;
	
	@PostMapping("/students")
	Student addStudent(@RequestBody Student student) {
		return studentService.addStudent(student);
	}
	@GetMapping("/students/get-one/{studentId}")
	Student getStudentById(@PathVariable("studentId")Integer studentId) throws StudentNotFoundException{
		return studentService.getStudentById(studentId);
	}
	@GetMapping("/students/city/{city}")
	List<Student> getStudentByAddressCity(@PathVariable("city")String city) throws StudentNotFoundException {
		return studentService.getStudentByAddressCity(city);
	}
	@GetMapping("/students/department/{department}")
	List<Student> getStudentbyDepartment(@PathVariable("department")String department) throws StudentNotFoundException{
		return studentService.getStudentByDepartment(department);
	}
	@GetMapping("/students")
	List<Student>getAllStudent(){
		return studentService.getAllStudent();
	}
	@GetMapping("/students/age/{age}")
		List<Student>findStudentByAge(@PathVariable("age")Integer age){
			return studentService.findStudentByAge(age);
		}
	@DeleteMapping("/students/delete/{studentId}")
	boolean deleteStudentbyId(@PathVariable("studentId")Integer studentId) {
		return studentService.deleteStudent(studentId);
		
	}
	
	

}
