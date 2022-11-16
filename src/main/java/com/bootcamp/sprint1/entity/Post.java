package com.bootcamp.sprint1.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Post {
    private Integer post_id;
    private LocalDate date;
    private Product product;
    private Category category;
    private Double price;
}
