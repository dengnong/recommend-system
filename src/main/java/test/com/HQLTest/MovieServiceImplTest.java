package test.com.HQLTest;

import com.config.DBConfig;
import com.entity.Movie;
import com.repository.MovieRepository;
import com.service.MovieService;
import org.hibernate.Session;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by 54472 on 2018/1/9.
 */
@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration(classes = {DBConfig.class})
public class MovieServiceImplTest {
    Session s = null;

    @Autowired
    private MovieRepository movieRepository;

    @Resource(name = "movieServiceImpl")
    private MovieService movieService;

    @Test
    public void allMovie() {
        Pageable pageable = new PageRequest(0, 20);
        Page<Movie> list = movieService.getAllMovieInfo(pageable);
        for(int i = 0; i < 20; i++) {
            System.out.println(list.getContent().get(i).getMovieName() + " "
                    + list.getTotalPages() + "==");
        }
    }

    @Test
    public void findByKind() {

    }

    @Test
    public void findByRate() {

    }

    @Test
    public void kindAndRate() {

    }

    @Test
    public void pageTest() {
        Pageable pageable = new PageRequest(0, 20);
        Page<Movie> list = movieRepository.findAllByRate(pageable);
        for(int i = 0; i < 20 ; i++) {
            System.out.println(list.getContent().get(i).getMovieName());
        }
    }

    @Test
    public void pageTest2() {
        Pageable pageable = new PageRequest(0, 20);
        Page<Movie> list = movieRepository.findByKindAndOrderByRate("科幻", pageable);
        for(int i = 0; i < 20 ; i++) {
            System.out.println(list.getContent().get(i).getMovieName());
        }
    }
}
