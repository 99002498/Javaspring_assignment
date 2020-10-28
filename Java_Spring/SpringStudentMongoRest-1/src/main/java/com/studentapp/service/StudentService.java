package com.studentapp.service;

import java.util.List;

import com.studentapp.exception.StudentNotFoundException;
import com.studentapp.model.Student;

public interface StudentService {
	Student addStudent(Student student);
	Student getStudentById(Integer studentId) throws StudentNotFoundException;
	boolean deleteStudent(Integer studentId) ;
	List<Student>getAllStudent();
	List<Student> getStudentByAddressCity(String city) throws StudentNotFoundException;
	List<Student> getStudentByDepartment(String department) throws StudentNotFoundException;
	List<Student>findStudentByAge(Integer age);


}
