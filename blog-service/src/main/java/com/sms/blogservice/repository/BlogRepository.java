package com.sms.blogservice.repository;

import com.sms.model.blog_management.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepository extends JpaRepository<Blog,Long> {


    public List<Blog> findByStatus(String status);
}
