package com.Lsq.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

import com.Lsq.dto.User;

public interface Export {
	public String FileExport(Map<String, List<String>> map, String title[], String name, HttpServletResponse response)
			throws Exception;

	public String FileImp(MultipartFile file) throws Exception;

	public String FileExport(String FileName, String[] title, List<User> UserList, HttpServletResponse response) throws Exception;
}
