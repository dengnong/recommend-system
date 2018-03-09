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
}
