package com.bamboocloud.framework.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.bamboocloud.framework.domain.SysResult;

/**
 * 全局异常处理器
 * 
 * @author jiulu
 */
@RestControllerAdvice
public class GlobalExceptionHandler
{
	private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);


    /**
     * 请求方式不支持
     */
    @ExceptionHandler({ HttpRequestMethodNotSupportedException.class })
    public SysResult handleException(HttpRequestMethodNotSupportedException e)
    {
    	log.error(e.getMessage(), e);
        return SysResult.error("不支持' " + e.getMethod() + "'请求");
    }

    /**
     * 拦截未知的运行时异常
     */
    @ExceptionHandler(RuntimeException.class)
    public SysResult notFount(RuntimeException e)
    {
    	 log.error("运行时异常:", e);
        return SysResult.error("运行时异常:" + e.getMessage());
    }

    /**
     * 系统异常
     */
    @ExceptionHandler(Exception.class)
    public SysResult handleException(Exception e)
    {
    	 log.error(e.getMessage(), e);
        return SysResult.error("服务器错误，请联系管理员");
    }

    
}
