package com.bjdvt.wx.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.bjdvt.wx.model.WxUser;
@Service
public class DbServiceImp {
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	public List getUsers(){
		String sql="select * from wx_company";
		List list=jdbcTemplate.queryForList(sql);
		return list;
	}
}
