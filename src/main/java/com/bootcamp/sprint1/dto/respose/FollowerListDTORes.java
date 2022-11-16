package com.bootcamp.sprint1.dto.respose;

import com.bootcamp.sprint1.entity.UserBuyer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class FollowerListDTORes extends UserDTORes {
    private List<UserDTORes> followers;
}
