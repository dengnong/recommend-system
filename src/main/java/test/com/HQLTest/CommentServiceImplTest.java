package test.com.HQLTest;

import com.config.DBConfig;
import com.entity.Comment;
import com.repository.CommentRepository;
import com.service.CommentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * Created by 54472 on 2018/3/7.
 */
@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration(classes = {DBConfig.class})
public class CommentServiceImplTest {

    @Autowired
    private CommentRepository commentRepository;

    @Resource(name = "commentServiceImpl")
    private CommentService commentService;

    @Test
    public void findComment() {
        System.out.println(commentRepository.findByItemIdAndType("26277313", "movie").get(1).getContent());

    }

    @Test
    public void saveComment() {
        Comment comment = new Comment("15", "26277313", "movie",
                LocalDateTime.now(), "fdsaadfsafdsfds2345", "1211");
        commentRepository.save(comment);
    }
}
