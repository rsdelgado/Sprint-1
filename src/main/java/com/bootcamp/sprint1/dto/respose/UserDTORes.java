package com.bootcamp.sprint1.dto.respose;

import com.bootcamp.sprint1.entity.UserBuyer;
import com.bootcamp.sprint1.entity.UserSeller;
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
    public UserDTORes(UserSeller e) {
        this.user_id = e.getUser_id();
        this.user_name = e.getUser_name();
    }

}
