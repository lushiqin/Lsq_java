package com.Lsq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

import com.Lsq.dto.User;
import com.Lsq.service.UserService;


/**
*
* 项目名称：Ssm
* 类名称：memberController
* 类描述：
* 创建人：Lsq
* 创建时间：2016年9月7日 上午11:57:37
* 修改人：Lsq
* 修改时间：2016年9月7日 上午11:57:37
* 修改备注：
* @version
*
*/
@Controller
public class memberController {
	@Autowired
	private UserService userService;

	@RequestMapping(value = "meminfo")
	public String meminfo() {
		return "Lsq/meminfo";
	}

	@RequestMapping(value = "indexLogin")
	public String indexLogin() {
		return "Lsq/indexLogin";
	}

	@RequestMapping(value = "logincheck",method = RequestMethod.POST)
	@ResponseBody
	public String[] logincheck(WebRequest request) {
		String msg[] = {"success","200"};
		return msg;
	}
	
	@RequestMapping(value = "register",method = RequestMethod.POST)
	@ResponseBody
	public String register(User record){
		userService.insert(record);
		return "200";
	}
	
	@RequestMapping(value = "lusqmain")
	public String lusqmain(){
		return "Lsq/lusqmain";
	}
}
