package com.sms.blogservice.service.serviceImpl;
import com.sms.blogservice.repository.BlogRepository;
import com.sms.blogservice.service.BlogService;
import com.sms.exception.NotFoundException;
import com.sms.model.blog_management.Blog;
import com.sms.pojo.blog_management.BlogPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private  BlogRepository blogRepository;

    public BlogServiceImpl(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    @Override
    public Blog saveBlog(BlogPojo blogPojo) {

        Blog blog = new Blog();
        blog.setBlogTitle(blogPojo.getBlogTitle());
        blog.setBlogDescription(blogPojo.getBlogDescription());
        blog.setCreatedAt(LocalDateTime.now());
        blog.setCategory(blogPojo.getCategory());
        blog.setStatus("ACTIVE");


        return blogRepository.save(blog);
    }

    @Override
    public List<Blog> getAllBlog() {
        List<Blog> blogs = blogRepository.findAll();
        if (blogs==null){
            throw new NotFoundException("no any blog present in the DB");
        }
        return blogs;
    }

    @Override
    public Blog getByBlogId(Long id) {

        Blog blog = blogRepository.findById(id).get();
        if (blog==null){
            throw new NotFoundException("This blog not found");
        }
        return blog;
    }

    @Override
    public Blog updateBlog(BlogPojo blogPojo,Long id) {

        Optional<Blog> optionalBlog=blogRepository.findById(id);

        if (optionalBlog==null){
            throw new NotFoundException("Blog Not Found");
        }
        Blog blog=new Blog();
        blog.setBlogTitle(blogPojo.getBlogTitle());
        blog.setBlogDescription(blogPojo.getBlogDescription());
        blog.setCategory(blogPojo.getCategory());
        return blogRepository.save(blog);
    }

    @Override
    public ResponseEntity<String> deleteBlog(Long id) {
        Optional<Blog> optionalBlog=blogRepository.findById(id);
        if (optionalBlog==null){
            throw new NotFoundException("thi blog not found");
        }

        optionalBlog.get().setStatus("NOT ACTIVE");
         blogRepository.save(optionalBlog.get());

         return ResponseEntity.ok().body("Deleted Successfully.");
    }

    @Override
    public List<Blog> findAllActiveBlog() {
        List<Blog> blogs = blogRepository.findByStatus("ACTIVE");
        if (blogs==null){
            throw new NotFoundException("no any active blogs");
        }
        return blogs;
    }
}
