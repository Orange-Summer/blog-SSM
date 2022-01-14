package com.backend.vo;

import lombok.Data;
import lombok.NonNull;

/**
 * Description:
 *
 * @author OrangeSummer
 * @date Created on 2021/8/10
 */
@Data
public class ResultVO<T> {

    private Integer code;

    private String msg;

    private T data;

    public ResultVO(){

    }

    public ResultVO(Integer code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public ResultVO(Integer code, String msg, @NonNull T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}

