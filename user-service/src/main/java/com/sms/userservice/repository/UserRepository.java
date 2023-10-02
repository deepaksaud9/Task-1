package com.sms.userservice.repository;

import com.sms.model.user_management.User;
import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

@Query("Select u from User u where u.email = : email")
    public Optional<User> getUserByEmail(@Param("email") String email);



}
