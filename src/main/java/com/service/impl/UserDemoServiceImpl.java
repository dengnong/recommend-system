package com.service.impl;

import com.entity.UserDemo;
import com.repository.UserDemoRepository;
import com.service.UserDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 */
@Service(value = "userDemoService")
public class UserDemoServiceImpl implements UserDemoService {

    @Autowired
    private UserDemoRepository userDemoRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public UserDemo findOne(Integer id) {
        return userDemoRepository.findOne(id);
    }

    @Override
    public void delete(Integer id) {
        userDemoRepository.delete(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public UserDemo save(UserDemo userDemo) {
        return userDemoRepository.save(userDemo);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public Page<UserDemo> find(Pageable pageable) {
        return userDemoRepository.findAll(pageable);
    }

/*
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<UserDemo> findAll() {
        return userRepository.findAll();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<UserDemo> findAll(Sort sort) {
        return userRepository.findAll(sort);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<UserDemo> findAll(Iterable<Integer> integers) {
        return userRepository.findAll(integers);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public List<UserDemo> save(Iterable<UserDemo> entities) {
        return userRepository.save(entities);
    }

    @Override
    public void flush() {
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public UserDemo saveAndFlush(UserDemo entity) {
        return userRepository.saveAndFlush(entity);
    }

    @Override
    public void deleteInBatch(Iterable<UserDemo> entities) {

    }

    @Override
    public void deleteAllInBatch() {

    }
*/

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public UserDemo getOne(Integer integer) {
        return userDemoRepository.getOne(integer);
    }


}
