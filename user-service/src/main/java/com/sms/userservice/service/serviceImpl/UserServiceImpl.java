package com.sms.userservice.service.serviceImpl;

import com.sms.exception.NotFoundException;
import com.sms.pojo.user_management.UserPojo;
import com.sms.userservice.repository.UserRepository;
import com.sms.userservice.service.UserService;
import com.sms.model.user_management.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(Long id, UserPojo userPojo) {

        User user = userRepository.findById(id).get();
        if (user.equals(null)){
            throw new NotFoundException("this user not found");
        }
        user.setUserId(userPojo.getUserId());
        user.setFirstName(userPojo.getFirstName());
        user.setLastName(user.getLastName());
        user.setEmail(user.getEmail());
        User updatedUser = userRepository.save(user);

        return updatedUser;
    }

    @Override
    public User getByEmail(String email){
        Optional<User> res=userRepository.getUserByEmail(email);
        return res.get();
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).get();
    }



    @Override
    public User getById(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

}
