package com.sms.userservice.service;

import com.sms.model.user_management.User;
import com.sms.pojo.user_management.UserPojo;

import java.util.List;
import java.util.Map;
import java.util.Objects;
//import com.sms.userservice.User;

public interface UserService {
    public User save(User user);
    public User updateUser(Long id, UserPojo userPojo);
    public User getByEmail(String email);
    public User getUserById(Long id);

    public User getById(Long id);

    List<User> getAllUser();
}
