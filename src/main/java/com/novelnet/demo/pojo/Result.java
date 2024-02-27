package com.novelnet.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@AllArgsConstructor
@Data
@NoArgsConstructor
public class Result {
    private int code;
    private Object data;
    private String msg;

    public Result(int code, Object data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }
}
