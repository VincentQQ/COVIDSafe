package com.magic.Bean;

import lombok.Getter;
import lombok.Setter;

/**
 *  实体类：response 响应：后端->前端
 */

@Getter
@Setter
public class UserResponse {
    private Boolean isSuccess;
    private String message;
}
