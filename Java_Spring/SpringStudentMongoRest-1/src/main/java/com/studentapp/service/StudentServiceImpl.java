
package com.studentapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentapp.dao.StudentRepository;
import com.studentapp.exception.StudentNotFoundException;
import com.studentapp.model.Student;
@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	StudentRepository studentRepository;
	

	@Override
	public Student addStudent(Student student) {
		Student newstudent = studentRepository.save(student);
		return newstudent;
	}
	@Override
	public boolean deleteStudent(Integer studentId) {
		studentRepository.deleteById(studentId);
		return true;
	}

	@Override
	public Student getStudentById(Integer studentId) throws StudentNotFoundException {
		return studentRepository.findById(studentId).orElseThrow(()->new StudentNotFoundException("Id not available"));
	}

	@Override
	public List<Student> getStudentByAddressCity(String city) throws StudentNotFoundException {
		return studentRepository.findStudentByAddressCity(city);
	}

	@Override
	public List<Student> getStudentByDepartment(String department) throws StudentNotFoundException{
		return studentRepository.findStudentByDepartment(department);
	}


	@Override
	public List<Student> getAllStudent() {
		return studentRepository.findAll();
	}

	@Override
	public List<Student> findStudentByAge(Integer age) {
		return studentRepository.findStudentByAge(age);
	}
	

}
