package com.sms.blogservice.service;
import com.sms.model.blog_management.Blog;
import com.sms.pojo.blog_management.BlogPojo;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BlogService {

    public Blog saveBlog(BlogPojo blog);

    public List<Blog> getAllBlog();

    public Blog getByBlogId(Long id);

    public Blog updateBlog(BlogPojo blogPojo,Long id);

    public ResponseEntity<String> deleteBlog(Long id);


    public List<Blog> findAllActiveBlog();


}
