package com.dao;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.model.LoginStudent;
import com.model.Student;



@Repository
public class StudentDao implements IStudentDao {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Autowired
	IRegistrationNumberDao regnumberdao;
	
	
	@Transactional
	public void saveStudent(Student student) {
	    hibernateTemplate.save(student);
	}

	@Transactional
	public void deleteStudent(String regnumber) {
		Student student = hibernateTemplate.get(Student.class, regnumber);
		hibernateTemplate.delete(student);
	}

	@Transactional
	public Student valiadteStudent(LoginStudent loginstudent) {
		
		System.out.println(loginstudent.toString());
		Student s = hibernateTemplate.get(Student.class, loginstudent.getRegnumber());
		System.out.println(s);
		if(s!=null && s.getUsername().equals(loginstudent.getUsername()) && s.getPassword().equals(loginstudent.getPassword())) {
			return s;
		}else {
			return null;
		}
	}
	
	@Transactional
	public String updateStudent(Student ustudent) {
		Student s = hibernateTemplate.get(Student.class, ustudent.getRegnumber());
		s.setFirstname(ustudent.getFirstname());
		s.setMiddlename(ustudent.getMiddlename());
		s.setLastname(ustudent.getLastname());
		s.setEmail(ustudent.getEmail());
		s.setPhnno(ustudent.getPhnno());
		s.setDob(ustudent.getDob());
		s.setSex(ustudent.getSex());
		s.setHouseno(ustudent.getHouseno());
		s.setStreet(ustudent.getStreet());
		s.setCity(ustudent.getCity());
		s.setState(ustudent.getState());
		s.setCountry(ustudent.getCountry());
		if(s.getRegnumber().equals(s.getRegnumber())) {
			hibernateTemplate.update(s);
			return "success";
		}
		return "fail";
		
	}
	
	@Transactional
	public Student getStudentById(String regnumber) {
		return hibernateTemplate.get(Student.class, regnumber);
	}

}
