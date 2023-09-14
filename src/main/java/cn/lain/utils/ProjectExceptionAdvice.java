package cn.lain.utils;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// 作为SpringMVC的异常处理器
@RestControllerAdvice
public class ProjectExceptionAdvice {
    // 拦截所有的异常信息
    @ExceptionHandler
    public R doException(Exception e) {
        // 显示异常信息
        e.printStackTrace();
        return new R("未知错误，请稍后再试！");
    }
}
