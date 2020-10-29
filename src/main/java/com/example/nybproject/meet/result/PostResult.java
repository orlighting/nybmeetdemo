package com.example.nybproject.meet.result;

import lombok.Data;

@Data
public class PostResult {

    int code;

    public PostResult(int code){
        this.code = code;
    }

}
