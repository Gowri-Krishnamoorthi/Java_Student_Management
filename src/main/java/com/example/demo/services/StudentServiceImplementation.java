package com.example.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;

@Service
public class StudentServiceImplementation implements StudentServices {
     StudentRepository srepo;

	public StudentServiceImplementation(StudentRepository srepo) {
		super();
		this.srepo = srepo;
	}

	@Override
	public String addStudent(Student s) {
		srepo.save(s);
		return "Student Added Successfully";
	}

	@Override
	public Student getStudent(String kodId) {
		Student st=srepo.findById(kodId).get();
		return st;
	}
    
	
	@Override
	public List<Student> getAllStudent() {
		   List<Student> slit=srepo.findAll();
		return slit;
	}

	@Override
	public String updateStudent(Student s) {
		srepo.save(s);
		return "Student Updated Successfully";
	}

	@Override
	public String deleteStudent(String kodId) {
		srepo.deleteById(kodId);
		return "Student Deleted Successfully";
	}
     
}
