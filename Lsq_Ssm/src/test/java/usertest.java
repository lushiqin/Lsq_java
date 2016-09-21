import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.Lus.model.User;
import com.Lus.service.UserService;
import com.alibaba.fastjson.JSON;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-mybatis.xml" })
public class usertest {

	@Autowired
	public UserService users;
	public Logger logger = Logger.getLogger(usertest.class);

	@Test
	public void userinsert() {
		User record = new User();
		record.setUserName("lushiqin");
		record.setUserMobi("15012931651");
		users.userInsert(record);
	}

	@Test
	public void userselect() {
		users.userSelect(1);
		logger.info(JSON.toJSON(users.userSelect(1)));
	}
	
	
	@Test
	public void userupdate(){
		User record = users.userSelect(2);
		record.setUserName("lushiqin");
		record.setUserMobi("15012931651");
		users.userUpdate(record);
		
	}
	
	@Test
	public void userdelete(){
		users.userDelete(3);
	}
	
	
	@Test
	public void userlist(){
		logger.info(JSON.toJSON(users.userList()));
	}
}
