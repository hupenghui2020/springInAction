package com.hph.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 扁担文件类型上传异常
 * @author com.hph
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Spittle Not Found")
public class DuplicateSpittleException extends RuntimeException {
}
