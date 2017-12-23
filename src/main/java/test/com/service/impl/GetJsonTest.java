package test.com.service.impl;

import com.service.GetMovieInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by 54472 on 2017/12/21.
 */
@RunWith( SpringJUnit4ClassRunner.class )
public class GetJsonTest {

    @Resource(name = "getMovieInfoServiceImpl")
    private GetMovieInfoService getMovieInfoService;

    @Test
    public void getMovieJsonTest() {
        System.out.println(getMovieInfoService.getTimeMoviesJson());
    }
}
