package test.com.HQLTest;

import com.config.DBConfig;
import com.entity.Book;
import com.repository.BookRepository;
import com.service.BookService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.data.domain.*;
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
    public void orderByRate() {
        Sort.Order order = new Sort.Order(Sort.Direction.DESC, "rateCount");
        Pageable pageable = new PageRequest(0, 20, new Sort(order));
        Page<Book> books = bookRepository.findAll(pageable);
        for(int i = 0; i < 20; i++) {
            System.out.println(books.getContent().get(i).getRateCount());
        }
//        List<Book> books = bookRepository.findAll(new Sort(Sort.Direction.DESC, "bookRate"));
    }

    @Test
    public void order() {
        Pageable pageable = new PageRequest(0, 20);
        List<Book> books = bookService.getRandomBookInfo();
//        Page<Book> page = new PageImpl<>(books, pageable, books.size());
        PagedListHolder<Book> pagedListHolder = new PagedListHolder<>(books);
        pagedListHolder.setPageSize(20);
        pagedListHolder.setPage(0);
        for(int i = 0; i < 20; i++) {
            System.out.println(pagedListHolder.getPageList().get(i).getBookRate()
                    +" " + pagedListHolder.getPageList().get(i).getBookName()
                    +" " + pagedListHolder.getPage());
        }
    }

    @Test
    public void kindAndOrder() {
        List<Book> books = bookRepository.findByKindAndOrderByRateCount("武侠");
        for (int i = 0; i < 50; i++) {
            System.out.println(books.get(i).getRateCount());
        }
    }
}
