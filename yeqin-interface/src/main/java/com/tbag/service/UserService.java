package com.tbag.service;

import java.util.List;

import com.tbag.po.Teacher;

public interface UserService {
	
	public List<Teacher> selectAll() throws Exception;
	
	public String getHello();
}
