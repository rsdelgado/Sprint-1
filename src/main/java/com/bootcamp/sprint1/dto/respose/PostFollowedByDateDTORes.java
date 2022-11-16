package com.bootcamp.sprint1.dto.respose;

import com.bootcamp.sprint1.dto.request.ProductDTOReq;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PostFollowedByDateDTORes {
    private Integer user_id;
    private List<PostDTORes> posts;
}
