import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.Lsq.dto.User;
import com.Lsq.service.UserService;
import com.alibaba.fastjson.JSON;


/**
*
* 项目名称：Ssm
* 类名称：test
* 类描述：
* 创建人：Lsq
* 创建时间：2016年9月1日 下午5:22:43
* 修改人：Lsq
* 修改时间：2016年9月1日 下午5:22:43
* 修改备注：
* @version
*
*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mvc.xml"})
public class test {
	@Resource
	private UserService users;
	
	private final Logger logger = Logger.getLogger(test.class);
	
	@Test
	public void test(){
		List<User> user  = users.userList();
		logger.info(JSON.toJSON(user));
	};
}
