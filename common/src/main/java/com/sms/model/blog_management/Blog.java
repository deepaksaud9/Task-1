package com.sms.model.blog_management;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Blog {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name = "blog_id")
    private Long blogId;

    @Column(name = "blog_title")
    private String blogTitle;

    @Column(name = "blog_description")
    private String blogDescription;

    @Column(name = "created_time")
    private LocalDateTime createdAt;


    @JoinColumn(name = "category_id")
    private String category;

    private String status;

}
