package com.loda;

import com.loda.entity.vo.ResultInfo;
import com.loda.exceptions.ParamsException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author loda
 * @Date 2022/11/20 23:17
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */
@ControllerAdvice
public class GlobalExceptionHandler     {
    @ExceptionHandler(value = ParamsException.class)
    @ResponseBody
    public ResultInfo resoverParamsException(ParamsException ex){
        ResultInfo resultInfo=new ResultInfo();
        resultInfo.setCode(ex.getCode());
        resultInfo.setMsg(ex.getMsg());
        return resultInfo;
    }

    @ExceptionHandler(value = BindException.class)
    @ResponseBody
    public ResultInfo resoverBindException(BindException ex){
        ResultInfo resultInfo=new ResultInfo();
        resultInfo.setCode(500);
        resultInfo.setMsg(ex.getBindingResult().getFieldError().getDefaultMessage());
        return resultInfo;
    }

    @ExceptionHandler
    @ResponseBody
    public ResultInfo resoverException(Exception ex){
        ResultInfo resultInfo=new ResultInfo();
        resultInfo.setCode(300);
        resultInfo.setMsg("操作失败222!");
        /*if(ex instanceof ParamsException){
            ParamsException pe = (ParamsException) ex;
            resultInfo.setMsg(pe.getMsg());
            resultInfo.setCode(pe.getCode());
        }*/
        return resultInfo;
    }


}
