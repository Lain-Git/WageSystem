package cn.lain.utils;

import lombok.Data;

/**
 * R对象
 * 统一后端数据格式
 */
@Data
public class R {
    private Boolean flag;
    private String msg;
    private Object data;

    public R(){}


    public R(Boolean flag) {
        this.flag = flag;
    }

    public R(Boolean flag, Object data) {
        this.flag = flag;
        this.data = data;
    }

    public R(String msg) {
        this.flag = false;
        this.msg = msg;
    }

    public R(Boolean flag, String msg) {
        this.flag = flag;
        this.msg = msg;
    }

    public R(Boolean flag, String msg, Object data) {
        this.flag = flag;
        this.msg = msg;
        this.data = data;
    }

}
