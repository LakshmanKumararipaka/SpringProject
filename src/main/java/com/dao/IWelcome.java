package com.dao;

import org.springframework.stereotype.Repository;

import com.model.Welcome;

@Repository
public interface IWelcome {
	
	public void save(Welcome welcome);
	
	public int getMarks(Welcome welcome);
	
	
}
