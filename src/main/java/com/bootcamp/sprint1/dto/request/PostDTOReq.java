package com.bootcamp.sprint1.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PostDTOReq {
    private Integer user_id;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;
    private ProductDTOReq product;
    private Integer category;
    private Double price;
}
