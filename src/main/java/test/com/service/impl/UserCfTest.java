package test.com.service.impl;

import com.config.DBConfig;
import com.entity.Book;
import com.entity.Movie;
import com.service.BookService;
import com.service.MovieService;
import com.service.UserCFService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 54472 on 2018/3/12.
 */
@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration(classes = {DBConfig.class})
public class UserCfTest {

    @Resource(name = "userCFServiceImpl")
    private UserCFService userCFService;

    @Resource(name = "bookServiceImpl")
    private BookService bookService;

    @Resource(name = "movieServiceImpl")
    private MovieService movieService;

    @Test
    public void user_item() {
        List<String> list = userCFService.userCf("account", "book");
        List<Book> list2 = bookService.findBookById(list);
        for (int i = 0; i < list2.size(); i++) {
            System.out.println(list.get(i).toString());
        }
    }

    @Test
    public void user_item2() {
        List<String> list = userCFService.userCf("account", "movie");
        List<Movie> list2 = movieService.findMovieById(list);
        for (int i = 0; i < list2.size(); i++) {
            System.out.println(list.get(i).toString());
        }
    }
}
