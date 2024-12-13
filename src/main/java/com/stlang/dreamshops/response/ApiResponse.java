package com.stlang.dreamshops.response;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ApiResponse {
    private String message;
    private Object data;

    public ApiResponse(String message, Object data) {
        this.message = message;
        this.data = data;
    }

}
