package com.service.impl;

import com.entity.Marks;
import com.repository.MarksRepository;
import com.service.MarksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * Created by 54472 on 2018/3/1.
 */
@Service(value = "marksServiceImpl")
public class MarksServiceImpl implements MarksService {

    @Autowired
    private MarksRepository marksRepository;

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
}
