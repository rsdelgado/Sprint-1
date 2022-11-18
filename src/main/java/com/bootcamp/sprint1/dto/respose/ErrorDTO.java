package com.bootcamp.sprint1.dto.respose;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ErrorDTO {
    private Integer status;
    private String message;
}
