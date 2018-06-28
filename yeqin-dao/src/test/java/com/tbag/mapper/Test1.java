package com.tbag.mapper;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tbag.po.Teacher;
import com.tbag.po.TeacherExample;

import junit.framework.TestCase;

public class Test1 extends TestCase {
	
	@Test
	public void test1(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-dao.xml");
		TeacherMapper mapper = (TeacherMapper) context.getBean(TeacherMapper.class);
		TeacherExample example = new TeacherExample();
		List<Teacher> list = mapper.selectByExample(example);
		System.out.println(list);
	}
}
