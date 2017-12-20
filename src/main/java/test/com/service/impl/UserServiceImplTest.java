package test.com.service.impl;

import com.entity.User;
import com.repository.UserRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/** 
* UserServiceImpl Tester. 
* 
* @author <Authors name> 
* @since <pre>Ê®¶þÔÂ 20, 2017</pre> 
* @version 1.0 
*/ 
public class UserServiceImplTest {
    @Autowired
    private UserRepository userRepository;

/** 
* 
* Method: initUser(String username, String password) 
* 
*/ 
@Test
public void testInitUser() throws Exception { 
//TODO: Test goes here...
    User user = userRepository.findByUsername("amazing");
    user.getPassword();
}

} 
