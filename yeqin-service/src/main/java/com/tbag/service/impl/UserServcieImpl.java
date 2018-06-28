package com.tbag.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


import com.alibaba.dubbo.config.annotation.Service;
import com.tbag.mapper.TeacherMapper;
import com.tbag.po.Teacher;
import com.tbag.po.TeacherExample;
import com.tbag.service.UserService;
@Service
public class UserServcieImpl implements UserService {

	@Autowired
	private TeacherMapper teacherMapper;
	
	@Override
	public List<Teacher> selectAll() {
		// TODO Auto-generated method stub
		List<Teacher> list = null;
		try {
			TeacherExample example = new TeacherExample();
			TeacherExample.Criteria criteria = example.createCriteria();
			list = teacherMapper.selectByExample(example);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return list;
	}

	@Override
	public String getHello() {
		// TODO Auto-generated method stub
		return "hello:20880";
	}

}
