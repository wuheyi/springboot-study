package com.zyhy.disposal.service.impl;

import com.zyhy.disposal.model.User;
import com.zyhy.disposal.repository.UserRepository;
import com.zyhy.disposal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wuheyi on 2019/5/21.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return (List<User>) userRepository.findAll();
    }


}
