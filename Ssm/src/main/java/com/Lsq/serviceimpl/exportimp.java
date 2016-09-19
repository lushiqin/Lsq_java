package com.Lsq.serviceimpl;

import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.math.NumberUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.Lsq.dto.User;
import com.Lsq.service.Export;
import com.Lsq.service.UserService;


/**
*
* 项目名称：Ssm
* 类名称：exportimp
* 类描述：
* 创建人：Lsq
* 创建时间：2016年9月2日 下午3:49:41
* 修改人：Lsq
* 修改时间：2016年9月2日 下午3:49:41
* 修改备注：
* @version
*
*/
@Service
public class exportimp implements Export {
	
	private @Autowired UserService users;
	
	/**
	 * 文件导出
	 */
	
	/**
	* (non-Javadoc)
	* @see com.Lsq.service.export#exportout(java.util.Map, java.lang.String[], java.lang.String, javax.servlet.http.HttpServletResponse)
	*/
	@Override
	public String FileExport(Map<String, List<String>> map, String title[], String name, HttpServletResponse response)
			throws Exception {

		response.setContentType("application/vnd.ms-excel");
		response.setHeader("Content-disposition", "attachment;filename=" + name);

		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet();
		HSSFRow row = null;
		HSSFCell cell = null;

		// 设置标题
		row = sheet.createRow(0);
		for (int i = 0, j = title.length; i < j; i++) {
			cell = row.createCell(i);
			cell.setCellValue(title[i]);
		}
		
		// 添加内容
		for (int i = 0, n = map.size(); i < n; i++) {
			row = sheet.createRow(i + 1);
			for (int j = 0, k = title.length; j < k; j++) {
				cell = row.createCell(j);
				cell.setCellValue(map.get("").get(j));
			}
		}

		OutputStream output = response.getOutputStream();
		workbook.write(output);
		workbook.close();

		return "success";
	}

	/**
	 * 文件导入
	 */
	
	/**
	* (批量添加会员)
	* @see com.Lsq.service.export#exportinp(org.springframework.web.multipart.MultipartFile)
	*/
	@Override
	public String FileImp(MultipartFile file) throws Exception {
		HSSFWorkbook workbook = new HSSFWorkbook(file.getInputStream());
		HSSFSheet sheet = workbook.getSheetAt(0);
		HSSFRow row = null;
		HSSFCell cell = null;

		for (int rowNum = 0, lastrowNum = sheet.getLastRowNum(); rowNum <= lastrowNum; rowNum++) {
			row = sheet.getRow(rowNum);
//			for (int cellNum = 0, lastcellNum = row.getLastCellNum(); cellNum < lastcellNum; cellNum++) {
//				cell = row.getCell(cellNum);
//				String value = cell.getStringCellValue();
//				System.out.print(value + " ");
//			}
//			System.out.println();
			
			String id = row.getCell(0).getStringCellValue();
			String username = row.getCell(1).getStringCellValue();
			String usermobi = row.getCell(2).getStringCellValue();
			String useradde = row.getCell(3).getStringCellValue();
			
			User user = new User();
			user.setUsername(username);
			user.setUsermobi(usermobi);
			user.setUsername(username);
			user.setUseradde(useradde);
			users.insert(user);
		}
		workbook.close();
		return "sucess";
	}

	
	/**
	* (文件导出 List<User>格式)
	* @see com.Lsq.service.export#FileExport(java.lang.String, java.lang.String[], java.util.List, javax.servlet.http.HttpServletResponse)
	*/
	@Override
	public String FileExport(String FileName, String[] title, List<User> UserList, HttpServletResponse response) throws Exception {
		response.setContentType("application/vnd.ms-excel");
		response.setHeader("Content-disposition", "attachment;filename=" + FileName + ".xls");
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet();
		HSSFRow row = null;
		HSSFCell cell = null;

		// 设置文档标题
		row = sheet.createRow(0);
		for (int cellNum1 = 0, cellSize1 = title.length; cellNum1 < cellSize1; cellNum1++) {
			cell = row.createCell(cellNum1);
			cell.setCellValue(title[cellNum1]);
		}

		// 设置文档内容
		for (int rowNum = 0, rowSize = UserList.size(); rowNum < rowSize; rowNum++) {
			User Users = UserList.get(rowNum);
			row = sheet.createRow(rowNum + 1);
			for (int cellNum2 = 0, cellSize2 = title.length; cellNum2 < cellSize2; cellNum2++) {
				cell = row.createCell(cellNum2);
				if (cellNum2 == 0) {
					cell.setCellValue(Users.getId());
				} else if (cellNum2 == 1) {
					cell.setCellValue(Users.getUsername());
				} else if (cellNum2 == 2) {
					cell.setCellValue(Users.getUsermobi());
				} else if (cellNum2 == 3) {
					cell.setCellValue(Users.getUseradde());
				} else {
					cell.setCellValue("内容长度与文件长度不符");
				}
			}
		}
		
		OutputStream OutPut = response.getOutputStream();
		workbook.write(OutPut);
		workbook.close();

		return "success";
	}
}
