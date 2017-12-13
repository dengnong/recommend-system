package com.service;

import com.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 *
 */
public interface UserService {

    User findOne(Integer id);

    void delete(Integer id);

    User save(User user);

    Page<User> find(Pageable pageable);

    //List<User> findAll();
    //
    //List<User> findAll(Sort sort);
    //
    //List<User> findAll(Iterable<Integer> integers);
    //
    //List<User> save(Iterable<User> entities);
    //
    //void flush();
    //
    //User saveAndFlush(User entity);
    //
    //void deleteInBatch(Iterable<User> entities);
    //
    //void deleteAllInBatch();

    User getOne(Integer integer);

}
