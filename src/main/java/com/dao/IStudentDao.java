package com.dao;

import com.model.LoginStudent;
import com.model.Student;

public interface IStudentDao {
	
	public void saveStudent(Student student);
	
	public void deleteStudent(String regnumber);
	
	public Student valiadteStudent(LoginStudent loginstudent);
	
	public String updateStudent(Student ustudent);
	
	public Student getStudentById(String regnumber);

}
