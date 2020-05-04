package com.example.basedemo.controller;


import com.example.basedemo.error.BusinessException;
import com.example.basedemo.error.EmBusinssError;
import com.example.basedemo.utils.CommonreturnType;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 〈公共的控制器〉
 *
 * @author Chkl
 * @create 2019/3/9
 * @since 1.0.0
 */
public class BaseController {


    //定义exceptionhandler解决未被controller层吸收的exception
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Object handlerException(HttpServletRequest request, Exception ex){
        Map<String, Object> responseData = new HashMap<>();

        if (ex instanceof BusinessException){
            BusinessException businessException = (BusinessException)ex;
            responseData.put("errCode",businessException.getErrCode());
            responseData.put("errMsg",businessException.getErrMsg());

        }else {
            responseData.put("errCode", EmBusinssError.UNKNOWN_ERROR.getErrCode());
            responseData.put("errMsg",EmBusinssError.UNKNOWN_ERROR.getErrMsg());
        }

        return CommonreturnType.create(responseData,"fail");


    }

}
