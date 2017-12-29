package test.com.HQLTest;

import com.config.DBConfig;
import com.entity.Book;
import com.repository.BookRepository;
import com.service.BookService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 54472 on 2017/12/21.
 */
@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration(classes = {DBConfig.class})
public class BookServiceImplTest {

    @Autowired
    private BookRepository bookRepository;

    @Resource(name = "bookServiceImpl")
    private BookService bookService;

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

    @Test
    public void findAllBook() {
        Pageable pageable = new PageRequest(10, 20);
        Page<Book> books = bookService.getAllBookInfo(pageable);
        for(int i = 0; i < 10; i++) {
            System.out.println(books.getContent().get(i).getBookAuthor());
        }
    }

    @Test
    public void findBookOrderByRate() {

    }
}
