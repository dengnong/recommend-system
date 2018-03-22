package test.com.HQLTest;

import com.config.DBConfig;
import com.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by 54472 on 2018/3/15.
 */
@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration(classes = {DBConfig.class})
public class UserTest
{
    @Resource(name = "userServiceImpl")
    private UserService userService;

    @Test
    public void initUser() {
        System.out.println(userService.initUser("1' OR '1'='1", "1' OR '1'='1"));
    }
}
