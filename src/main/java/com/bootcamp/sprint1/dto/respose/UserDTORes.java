package com.bootcamp.sprint1.dto.respose;

import com.bootcamp.sprint1.entity.UserBuyer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UserDTORes {
    private Integer user_id;
    private String user_name;

    public UserDTORes(UserBuyer e) {
        this.user_id = e.getUser_id();
        this.user_name = e.getUser_name();
    }
}
