package com.bootcamp.sprint1.dto.respose;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class FollowerCountDTORes{
    private Integer user_id;
    private String user_name;
    private Integer followers_count;
}
