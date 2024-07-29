package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
//import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.model.RegistrationNumber;



@Repository
public class RegistrationNumberDao implements IRegistrationNumberDao{
	
	@Autowired
	private JdbcTemplate template;
	
	
	static int i = 1;
	
	@Transactional
	public String getRegistrationNumber() {
		String sql = "Select * from regnumber where regId = "+i;
		
		rowMapper rm = new rowMapper();
		List<RegistrationNumber> regnumber = template.query(sql, rm);
		i++;
		if(regnumber.size()>0) {
			return regnumber.get(0).getRegnumber();
		}
		else {
			return null;
		}
	}

}

class rowMapper implements RowMapper<RegistrationNumber>{

	@Override
	public RegistrationNumber mapRow(ResultSet rs, int rowNum) throws SQLException {
		RegistrationNumber rn = new RegistrationNumber();
		rn.setRegId(rs.getInt(1));
		rn.setRegnumber(rs.getString(2));
		return rn;
	}
	
}
