package com.service;

import com.entity.UserDemo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 *
 */
public interface UserDemoService {

    UserDemo findOne(Integer id);

    void delete(Integer id);

    UserDemo save(UserDemo userDemo);

    Page<UserDemo> find(Pageable pageable);

    //List<UserDemo> findAll();
    //
    //List<UserDemo> findAll(Sort sort);
    //
    //List<UserDemo> findAll(Iterable<Integer> integers);
    //
    //List<UserDemo> save(Iterable<UserDemo> entities);
    //
    //void flush();
    //
    //UserDemo saveAndFlush(UserDemo entity);
    //
    //void deleteInBatch(Iterable<UserDemo> entities);
    //
    //void deleteAllInBatch();

    UserDemo getOne(Integer integer);

}
