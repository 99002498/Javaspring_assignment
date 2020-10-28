package com.studentapp.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.studentapp.model.Student;
@Repository
public interface StudentRepository extends MongoRepository<Student, Integer> {
	
	//boolean deleteStudent(Integer studentId);
	List<Student> findStudentByName(String name);
	List<Student> findStudentByAddressCity(String city);
	List<Student> findStudentByDepartment(String department);
	
	 @Query("{'age': ?0}")
	List<Student> findStudentByAge(Integer age);

}
