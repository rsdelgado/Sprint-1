package com.bootcamp.sprint1.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PostDTOReq {
    private Integer user_id;
    private LocalDate date;
    private ProductDTOReq product;
    private Integer category;
    private Double price;
}
