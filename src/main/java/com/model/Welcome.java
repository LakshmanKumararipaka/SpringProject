package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="answers")
public class Welcome {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String regnumber;
	
	private String answer01;
	private String answer02;
	
	private String remarks;

	public String getRegnumber() {
		return regnumber;
	}

	public void setRegnumber(String regnumber) {
		this.regnumber = regnumber;
	}

	@Override
	public String toString() {
		return "Welcome [regnumber=" + regnumber + "]";
	}

	public String getAnswer01() {
		return answer01;
	}

	public void setAnswer01(String answer01) {
		this.answer01 = answer01;
	}

	public String getAnswer02() {
		return answer02;
	}

	public void setAnswer02(String answer02) {
		this.answer02 = answer02;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	

}
