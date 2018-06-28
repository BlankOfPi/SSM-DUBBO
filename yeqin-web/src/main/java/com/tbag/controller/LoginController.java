package com.tbag.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.dubbo.config.annotation.Reference;
import com.tbag.po.Teacher;
import com.tbag.service.UserService;

@Controller
@RequestMapping(value="/user")
public class LoginController{
	@Reference
	private UserService service;
	

	private static  final transient Logger log = Logger.getLogger(LoginController .class);
	
	@RequestMapping(value="/selectAll")
	@ResponseBody
	public List<Teacher> selectAll(@Validated Teacher teacher) throws Exception {	
		Map resResult = new HashMap();
		Map data = new HashMap();
		resResult.put("errcode","-1");
		resResult.put("errmsg","失败");
		List<Teacher> list = null;
		try {
			list = service.selectAll();
			resResult.put("errcode","1");
			resResult.put("errmsg","成功");
			resResult.put("list", list);
		} catch (Exception e) {
			// TODO: handle exception
			log.info("login-->"+"errormsg:"+e.getMessage());
		}
		return list;
	}
	
	@RequestMapping(value="/getHello")
	@ResponseBody
	public String getHello(@Validated Teacher teacher) throws Exception {	
		
		String list = null;
		try {
			list = service.getHello();
		} catch (Exception e) {
			// TODO: handle exception
			log.info("login-->"+"errormsg:"+e.getMessage());
		}
		return list;
	}
	
}

