package com.service.impl;

import com.entity.User;
import com.repository.UserRepository;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 */
@Service(value = "userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public User findOne(Integer id) {
        return userRepository.findOne(id);
    }

    @Override
    public void delete(Integer id) {
        userRepository.delete(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public Page<User> find(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

/*
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<User> findAll(Sort sort) {
        return userRepository.findAll(sort);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<User> findAll(Iterable<Integer> integers) {
        return userRepository.findAll(integers);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public List<User> save(Iterable<User> entities) {
        return userRepository.save(entities);
    }

    @Override
    public void flush() {
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public User saveAndFlush(User entity) {
        return userRepository.saveAndFlush(entity);
    }

    @Override
    public void deleteInBatch(Iterable<User> entities) {

    }

    @Override
    public void deleteAllInBatch() {

    }
*/

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public User getOne(Integer integer) {
        return userRepository.getOne(integer);
    }


}
