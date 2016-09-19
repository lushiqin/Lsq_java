package com.Lsq.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartFile;
import com.Lsq.dto.User;
import com.Lsq.service.Export;
import com.Lsq.service.UserService;

@Controller
public class lusqMainController {

	private @Autowired UserService userservice;
	private @Autowired Export export;

	/**
	 * userser(用户列表)
	 * 
	 * @param name
	 * @param @return
	 *            设定文件
	 * @return String DOM对象
	 * @Exception 异常对象
	 * @since CodingExample Ver(编码范例查看) 1.1
	 */
	@RequestMapping(value = "userser")
	@ResponseBody
	public List<User> userser(HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		List<User> user = userservice.userList();
		return user;
	}

	/**
	 * userIdser(根据ID查找用户)
	 * 
	 * @param name
	 * @param @return
	 *            设定文件
	 * @return String DOM对象
	 * @Exception 异常对象
	 * @since CodingExample Ver(编码范例查看) 1.1
	 */
	@RequestMapping(value = "userIdser")
	@ResponseBody
	public User userIdser(String userid, WebRequest request) {
		int id = NumberUtils.toInt(userid);
		User users = userservice.selectByPrimaryKey(id);
		return users;
	}

	/**
	 * userUpd(修改用户信息)
	 * 
	 * @param name
	 * @param @return
	 *            设定文件
	 * @return String DOM对象
	 * @Exception 异常对象
	 * @since CodingExample Ver(编码范例查看) 1.1
	 */
	@RequestMapping(value = "userUpd")
	@ResponseBody
	public String userUpd(User record) {
		userservice.updateByPrimaryKey(record);
		return "200";
	}

	/**
	 * userDel(根据ID删除用户信息)
	 * 
	 * @param name
	 * @param @return
	 *            设定文件
	 * @return String DOM对象
	 * @Exception 异常对象
	 * @since CodingExample Ver(编码范例查看) 1.1
	 */
	@RequestMapping(value = "userDel")
	@ResponseBody
	public String userDel(Integer userid, WebRequest request) {
		userservice.deleteByPrimaryKey(userid);
		return "200";
	}

	/**
	 * userIns(新增用户)
	 * 
	 * @param name
	 * @param @return
	 *            设定文件
	 * @return String DOM对象
	 * @Exception 异常对象
	 * @since CodingExample Ver(编码范例查看) 1.1
	 */
	@RequestMapping(value = "userIns")
	@ResponseBody
	public String userIns(User record) {
		userservice.insert(record);
		return "200";
	}

	/**
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "userForm")
	@ResponseBody
	public Map<String, String> userForm(WebRequest request,HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String confirm_password = request.getParameter("confirm_password");
		String email = request.getParameter("email");
		String isZipCode = request.getParameter("isZipCode");
		String phoneUS = request.getParameter("phoneUS");
		String agree = request.getParameter("agree");
		String newsletter = request.getParameter("newsletter");
		String topic_marketflash = request.getParameter("topic_marketflash");
		String topic_fuzz = request.getParameter("topic_fuzz");
		String topic_digester = request.getParameter("topic_digester");
		String selected = request.getParameter("selected");
		Map<String, String> map = new HashMap<String, String>();
		map.put("firstname", firstname);
		map.put("lastname", lastname);
		map.put("username", username);
		map.put("password", password);
		map.put("confirm_password", confirm_password);
		map.put("email", email);
		map.put("isZipCode", isZipCode);
		map.put("phoneUS", phoneUS);
		map.put("agree", agree);
		map.put("newsletter", newsletter);
		map.put("topic_marketflash", topic_marketflash);
		map.put("topic_fuzz", topic_fuzz);
		map.put("topic_digester", topic_digester);
		map.put("selected", selected);
		System.out.println(map);
		
		Map<String, String> map2 = new HashMap<String, String>();
		
		if (phoneUS == "" || phoneUS == null) {
			map2.put("status", "0");
			map2.put("msg", "手机号码为空");
			return map2;
		}else {
			map2.put("status", "1");
			map2.put("msg", "提交成功");
			return map2;
		}
	}

	/**
	 * docExport(文件导出)
	 * 
	 * @param name
	 * @param @return
	 *            设定文件
	 * @return String DOM对象
	 * @Exception 异常对象
	 * @since CodingExample Ver(编码范例查看) 1.1
	 */
	@RequestMapping(value = "docExport")
	@ResponseBody
	public void docExport(HttpServletResponse response) throws Exception {
		String FileName = "user";
		String title[] = { "id", "username", "usermobi", "useradde" };
		List<User> UserList = userservice.userList();
		export.FileExport(FileName, title, UserList, response);
	}

	/**
	 * docImport(文件导入)
	 * 
	 * @param name
	 * @param @return
	 *            设定文件
	 * @return String DOM对象
	 * @Exception 异常对象
	 * @since CodingExample Ver(编码范例查看) 1.1
	 */
	@RequestMapping(value = "fileinput")
	public String docImport() {
		return "Lsq/fileinput";
	}

	@RequestMapping(value = "docImport")
	@ResponseBody
	public void docImport(@RequestParam("file") MultipartFile file) throws Exception {
		export.FileImp(file);
	}
}
