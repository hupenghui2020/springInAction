package com.hph.aspect;

import com.hph.exception.DuplicateSpittleException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 通知定义：处理所有控制器抛出的异常
 * @author hph
 */

@ControllerAdvice
public class AppWideExceptionHandler {

    /**
     * 处理控制器抛出的 DuplicateSpittleException 异常
     * @return
     */
    @ExceptionHandler(DuplicateSpittleException.class)
    public String duplicateSpittleHandler(){
        return "error/duplicate";
    }
}
