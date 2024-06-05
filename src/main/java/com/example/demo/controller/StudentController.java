package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Student;
import com.example.demo.services.StudentServices;

import org.springframework.ui.Model;

@RestController
@RequestMapping("/spr")
public class StudentController {
        
	StudentServices ss;

	public StudentController(StudentServices ss) {
		super();
		this.ss = ss;
	}
	
	
	@PostMapping("/addStud")
    public String addStudent(@RequestParam("studentId") String kodId, @RequestParam("studentName") String name, @RequestParam("studentBranch") String branch) {
        Student s = new Student(kodId, name, branch);
        String msg = ss.addStudent(s);
        return msg;
    }
	
	@PutMapping("/updStud")
	public String updateStudent(@RequestParam("studentId") String kodId, @RequestParam("studentName") String name, @RequestParam("studentBranch") String branch)
	{
		Student st=ss.getStudent(kodId);
		st.setBranch(branch);
		st.setName(name);
		String msg=ss.updateStudent(st);
		return msg;
	}
    
	@GetMapping("/getStud")
	public String getStudent(@RequestParam("studentId") String kodId, Model model) {
	    Student s = ss.getStudent(kodId);
	    if (s != null) {
	        ((Model) model).addAttribute("Student", s);
		    return "<html><body><h1>Student Details</h1><p>ID: " + s.getKodId() + "</p><p>Name: " + s.getName() + "</p><p>Branch: " + s.getBranch() + "</p></body></html>";
	    } else {
	        // Handle the case where the student is not found
	        return "studentNotFound"; // Return an error view
	    }
	}
     
	@DeleteMapping("/delStud")
	public String deleteStudent(@RequestParam("studentId")String kodId)
	{
		String msg=ss.deleteStudent(kodId);
		return msg;
	}
}









