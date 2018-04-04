package test.com.HQLTest;

import com.config.DBConfig;
import com.entity.Marks;
import com.repository.MarksRepository;
import com.service.MarksService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by 54472 on 2018/3/1.
 */
@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration(classes = {DBConfig.class})
public class MarksServiceImplTest {

    @Autowired
    private MarksRepository marksRepository;

    @Resource(name = "marksServiceImpl")
    private MarksService marksService;

    @Test
    public void marks() {
        Marks marks = new Marks("account", "1434071", "book", LocalDateTime.now());
        marksRepository.save(marks);
    }

    @Test
    public void initMarks() {
        if (marksService.markInit("2", "11", "book")) {
            System.out.println("hello");
        } else {
            System.out.println("shit!");
        }
    }

    @Test
    public void cancel() {
        marksService.markCancel("1", "11", "book");
    }

    @Test
    public void marksBook() {
        System.out.println(marksRepository.marksBook("account"));
    }

    @Test
    public void countUser() {
        System.out.println(marksRepository.countUserId("movie"));
    }

    @Test
    public void findUserId() {
        System.out.println(marksRepository.findUserId("book").get(1));
    }

    @Test
    public void findItemIdByUserId() {
        System.out.println(marksRepository.findItemIdByUserId("account", "book").get(1));
    }

    @Test
    public void countMarks() {
        List<String> list =  marksRepository.countByMarks("book");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
