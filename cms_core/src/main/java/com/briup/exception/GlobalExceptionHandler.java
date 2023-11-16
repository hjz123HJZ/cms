package com.briup.exception;


import com.briup.util.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.net.BindException;

/**
 * 全局异常处理
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public Object handleException(Exception e) {
        Result result = null;
        e.printStackTrace();
        if (e instanceof com.briup.exception.ServiceException) {
            log.error(e.getMessage());
            result = Result.failure(((com.briup.exception.ServiceException) e).getResultCode());
        }else if(e instanceof MethodArgumentNotValidException)    { //使用了hibernate进行参数校验出现错误后全局异常捕获到自己设置的错误信息
            BindingResult bindingResult = ((MethodArgumentNotValidException) e).getBindingResult();
            result = Result.failure(500, String.valueOf(bindingResult));
        }
        else if (e instanceof DuplicateKeyException){
            result = Result.failure(500,"该数据已存在,请检查后重新输入!");
        } else {
            log.error(e.getMessage());
            result = Result.failure(500, "服务器意外错误：" + e.getMessage());
        }
        return result;
    }
}
