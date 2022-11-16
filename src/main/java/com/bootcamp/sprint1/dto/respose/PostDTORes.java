package com.bootcamp.sprint1.dto.respose;

import com.bootcamp.sprint1.dto.request.ProductDTOReq;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PostDTORes {
    private Integer user_id;
    private Integer post_id;
    private LocalDate date;
    private ProductDTORes product;
    private Integer category;
    private Double price;
}
