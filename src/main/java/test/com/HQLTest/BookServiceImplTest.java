package test.com.HQLTest;

import com.config.DBConfig;
import com.entity.Book;
import com.repository.BookRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by 54472 on 2017/12/21.
 */
@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration(classes = {DBConfig.class})
public class BookServiceImplTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void findBook() {
        Book book = bookRepository.findOne(1);
        System.out.println(book.getBookName());
    }

    @Test
    public void findRandBook() {
        List<Book> book = bookRepository.findRandBooks();
        for(int i = 0; i < 5; i++) {
            System.out.println(book.get(i).getId() + " " + book.get(i).getBookName());
        }
    }
}
