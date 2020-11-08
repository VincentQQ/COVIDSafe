package com.magic.Bean;

import lombok.Getter;
import lombok.Setter;

/**
 *  Entity Class: response Response: backend->frontend
 */

@Getter
@Setter
public class UserResponse {
    private Boolean isSuccess;
    private String message;
}
