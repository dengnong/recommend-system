package com.service.impl;

import com.entity.Book;
import com.entity.Marks;
import com.entity.Movie;
import com.repository.BookRepository;
import com.repository.MarksRepository;
import com.repository.MovieRepository;
import com.service.MarksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 54472 on 2018/3/1.
 */
@Service(value = "marksServiceImpl")
public class MarksServiceImpl implements MarksService {

    @Autowired
    private MarksRepository marksRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private MovieRepository movieRepository;

    public void markItem(String userId, String itemId, String type) {
        Marks marks = new Marks(userId, itemId, type, LocalDateTime.now());
        marksRepository.save(marks);
    }

    public boolean markInit(String userId, String itemId, String type) {
        boolean flag = false;
        if(marksRepository.findByuserIdAndItemIdAndType(userId, itemId, type) != null) {
            flag = true;
        }
        return flag;
    }

    public void markCancel(String userId, String itemId, String type) {
        Marks marks = marksRepository.findByuserIdAndItemIdAndType(userId, itemId, type);
        if(marks != null)
        marksRepository.delete(marks);
    }

    public List<Book> marksBook(String type) {
        List<String> list = marksRepository.countByMarks(type);
        ArrayList<Book> arrayList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            arrayList.add(bookRepository.findBookByBookId(list.get(i)));
        }
        return arrayList;
    }

    public List<Movie> marksMovie(String type) {
        List<String> list = marksRepository.countByMarks(type);
        ArrayList<Movie> arrayList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            arrayList.add(movieRepository.findMovieByMovieId(list.get(i)));
        }
        return arrayList;
    }
}
