package com.bjdvt.wx;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.bjdvt.wx.controller.UserController;
import com.bjdvt.wx.exception.ApiErrorResponse;
import com.bjdvt.wx.exception.CustomException;


import javax.validation.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 *
 * @author ming 定义全局异常处理
 * @RestControllerAdvice 是@controlleradvice 与@ResponseBody 的组合注解
 */
@ControllerAdvice
public class GlobalControllerExceptionHandler {
	 Logger logger = LoggerFactory.getLogger(GlobalControllerExceptionHandler.class);
	 @ResponseBody
	 @ExceptionHandler(value = CustomException.class)
    public ApiErrorResponse constraintViolationException(CustomException ex) {
		 logger.error("CustomException error");
		 logger.error("error" ,ex);
    	ex.printStackTrace();
    	ApiErrorResponse error=new ApiErrorResponse(ex.getCode(),100,ex.getMessage());
        return error;
    }
    
    @ExceptionHandler(value = { IllegalArgumentException.class })
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrorResponse IllegalArgumentException(IllegalArgumentException ex) {
    	ex.printStackTrace();
    	 logger.error("IllegalArgumentException error");
		 logger.error("error" ,ex);
        return new ApiErrorResponse(501, 5002, ex.getMessage());
    }

    @ExceptionHandler(value = { NoHandlerFoundException.class })
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiErrorResponse noHandlerFoundException(Exception ex) {
    	ex.printStackTrace();
    	 logger.error("Exception error");
		 logger.error("error" ,ex);
        return new ApiErrorResponse(404, 4041, ex.getMessage());
    }

    @ResponseBody
	@ExceptionHandler(value = Exception.class)
    public ApiErrorResponse unknownException(Exception ex) {
    	ex.printStackTrace();
    	 logger.error("Exception error");
		 logger.error("error" ,ex);
        return new ApiErrorResponse(500, 5002, ex.getMessage());
    }
}