package com.sms.blogservice.controller;
import com.sms.blogservice.service.BlogService;
import com.sms.model.blog_management.Blog;
import com.sms.pojo.blog_management.BlogPojo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/blog")
public class BlogController {

    private final BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @PostMapping("/saveBlog")
    public ResponseEntity<String> save(@RequestBody BlogPojo blog){
        blogService.saveBlog(blog);
        return ResponseEntity.ok("Blog add successfully.");
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Blog>> findAllBlog(){
        return ResponseEntity.ok().body(blogService.getAllBlog());
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Blog> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(blogService.getByBlogId(id));
    }

    @GetMapping("/deleteBlog/{id}")
    public ResponseEntity<String> deleteBlog(@PathVariable Long id){
        return blogService.deleteBlog(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Blog> update(@RequestBody BlogPojo blog,@PathVariable Long id){
        return ResponseEntity.ok().body(blogService.updateBlog(blog,id));
    }

    @GetMapping("/findAllActive")
    public ResponseEntity<List<Blog>> findAllActive(){
        return ResponseEntity.ok().body(blogService.findAllActiveBlog());
    }
}
