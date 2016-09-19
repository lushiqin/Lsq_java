package com.Lsq.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

import com.Lsq.dto.User;
import com.Lsq.service.UserService;
import com.alibaba.fastjson.JSON;


/**
*
* 项目名称：Ssm
* 类名称：memberinfoController
* 类描述：
* 创建人：Lsq
* 创建时间：2016年9月6日 上午9:38:56
* 修改人：Lsq
* 修改时间：2016年9月6日 上午9:38:56
* 修改备注：
* @version
*
*/
@Controller
public class memberinfoController {

	@Autowired
	private UserService userService;
	private final Logger logger = Logger.getLogger(getClass());
	
	@RequestMapping(value = "userList" ,method = RequestMethod.POST)
	@ResponseBody
	public List<User> userList(){
		List<User> users =  userService.userList();
		return users;
	}
	
	
	@RequestMapping(value = "addTest")
	public String addTest(){
		return "memberinfo";
	}
	@RequestMapping(value = "addTests")
	@ResponseBody
	public String addTests(User record,WebRequest request){
		userService.insert(record);
		return "addTests";
	}
	
	@RequestMapping(value = "delTest")
	public String delTest(Model model){
		User uss = userService.selectByPrimaryKey(2);
		logger.info(JSON.toJSON(uss));
		model.addAttribute(uss);
		return "memberinfo";
	}
	
	@RequestMapping(value = "setTest")
	public String setTest(){
		return "memberinfo";
	}
	
	@RequestMapping(value = "serTest")
	public String serTest(){
		return "memberinfo";
	}
}
