package com.sms.pojo.blog_management;

import com.sms.model.blog_management.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BlogPojo {

    private Long blogId;
    private String blogTitle;
    private String blogDescription;
    private Category category;
}
