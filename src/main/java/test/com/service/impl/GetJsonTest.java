package test.com.service.impl;

import com.config.DBConfig;
import com.service.GetBookInfoService;
import com.service.GetMovieInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Map;

/**
 * Created by 54472 on 2017/12/21.
 */
@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration(classes = {DBConfig.class})
public class GetJsonTest {

    @Resource(name = "getMovieInfoServiceImpl")
    private GetMovieInfoService getMovieInfoService;

    @Resource(name = "getBookInfoServiceImpl")
    private GetBookInfoService getBookInfoService;

    @Test
    public void getMovieJsonTest() {
        System.out.println(getMovieInfoService.getTimeMoviesJson());
    }

    @Test
    public void getBookJsonTest() {
        System.out.println(getBookInfoService.getDoubanBooksJson("26986954").get("author_intro"));
    }

    @Test
    public void getMovieInfoTest() {
        System.out.println(getMovieInfoService.getDoubanMoviesJson("26586766").get("writer"));
    }

    @Test
    public void searchDoubanBook() {
        ArrayList<Map<String, String>> list = new ArrayList<>();
        list = getBookInfoService.searchDoubanBook("白夜");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).get("title"));
            System.out.println(list.get(i).get("author"));
            System.out.println(list.get(i).get("publisher"));
            System.out.println(list.get(i).get("alt"));
            System.out.println("+++++++++" + i + "++++++++++");
        }
    }
}
