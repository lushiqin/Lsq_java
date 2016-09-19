package com.Lsq.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.math.NumberUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartFile;
import com.Lsq.dto.User;
import com.Lsq.service.Export;
import com.Lsq.service.UserService;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;


/**
*
* 项目名称：Ssm
* 类名称：UserController
* 类描述：
* 创建人：Lsq
* 创建时间：2016年9月1日 下午5:14:26
* 修改人：Lsq
* 修改时间：2016年9月1日 下午5:14:26
* 修改备注：
* @version
*
*/
@Controller
public class UserController {

	private @Autowired UserService user;
	private @Autowired Export Export;
	private final Logger logger = Logger.getLogger(getClass());

	@RequestMapping(value = "login")
	public String UserLogin() {
		return "Userlogin";
	}

	@RequestMapping(value = "member", method = RequestMethod.POST)
	@ResponseBody
	public String UserLogins(WebRequest request) {
		return "200";
	}

	@RequestMapping(value = "membercenter")
	public String center() {
		return "membercenter";
	}

	@RequestMapping(value = "userregister")
	public String userregister() {
		return "register";
	}

	/**
	 * 会员注册
	 * 
	 * @param request
	 * @param record
	 */
	@RequestMapping(value = "userregisters")
	@ResponseBody
	public void userregisters(WebRequest request, User record) {
		user.insert(record);
	}

	@RequestMapping(value = "memberlist")
	@ResponseBody
	public String memberlist() {
		User userlist = user.selectByPrimaryKey(1);
		return "200:123";
	}

	/**
	 * 导出
	 * 
	 * @throws IOException
	 */
	@RequestMapping(value = "exceloutput")
	@ResponseBody
	public void userimp(WebRequest request, HttpServletResponse response) throws Exception {
		List<String> list1 = new ArrayList<String>();
		list1.add("1");
		list1.add("2");
		list1.add("3");
		list1.add("4");
		
		Map<String, List<String>> map = new HashMap<>();
		map.put("", list1);

		String title[] = { "id", "name", "mobi", "age" };
		String name = "student.xls";
		String msg = Export.FileExport(map, title, name, response);
		System.out.println(msg);
	}

	@RequestMapping(value = "excelinput")
	@ResponseBody
	public void fileinput(@RequestParam("file") MultipartFile file) throws Exception {

		if (!file.isEmpty()) {
			System.out.println(file.getOriginalFilename() + "文件导入了");
			String msg = Export.FileImp(file);
			System.out.println(msg);
		}
	}
	
	
	@RequestMapping(value = "userlist")
	@ResponseBody
	public void userlist(HttpServletResponse response) throws Exception {
		List<User> UserList = user.userList();
		String title[] = { "id", "name", "mobi", "address" };
		String FileName = "User.xls";
		Export.FileExport(FileName, title, UserList, response);
	}
	
	
	@RequestMapping(value = "SearchUser")
	@ResponseBody
	public String SearchUser(WebRequest request) {
		String userid = request.getParameter("search");
		int UserId = NumberUtils.toInt(userid);
		String returnvalue = null;

		if (userid == "" || userid == null) {
			List<User> Users = user.userList();
			returnvalue = JSONArray.toJSONString(Users);
		} else {
			User Users = user.selectByPrimaryKey(UserId);
			returnvalue = JSONArray.toJSONString(Users);
		}

		return returnvalue;
	}
	
	@RequestMapping(value = "DeleteUser")
	@ResponseBody
	public String DeleteUser(WebRequest request){
		int UserId = NumberUtils.toInt(request.getParameter("search"));
		user.deleteByPrimaryKey(UserId);
		return "success";
	}
	
	
	@RequestMapping(value = "MemList")
	public String MemList(){
		return "MemList";
	}
	
	@RequestMapping(value = "MemLists")
	@ResponseBody
	public List<User> MemLists(){
		return user.userList();
	}
}
