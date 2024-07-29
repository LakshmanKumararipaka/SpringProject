package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.model.Welcome;

@Repository
public class WelcomeDao implements IWelcome {
	
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	

	@Transactional
	public void save(Welcome welcome) {
		hibernateTemplate.save(welcome);
	}

	@Override
	public int getMarks(Welcome welcome) {
		int score  = 0;
		if(welcome.getAnswer01().equals("delhi"))
			score++;
		if(welcome.getAnswer02().equals("mounteverest"))
			score++;
		return score;
	}

}


