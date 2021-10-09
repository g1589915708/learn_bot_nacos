package com.learn.tools;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class ResultCode {

    public static final Integer iSUCCESS = 200;
    public static final Integer iERROR = 401;

    public static final String SUCCESS = "SUCCESS";
    public static final String ERROR = "ERROR";

    private int status = ResultCode.iSUCCESS;
    private String massage = "SUCCESS";
    private Map<String,Object> data = new HashMap<>();
    private boolean success = true;

    public static ResultCode ok(){
        ResultCode resultCode = new ResultCode();
        return resultCode;
    }


    public static ResultCode error(){
        ResultCode resultCode = new ResultCode();
        resultCode.status = ResultCode.iERROR;
        resultCode.success = false;
        resultCode.massage = ResultCode.ERROR;
        return resultCode;
    }

    public static void addData(ResultCode code,String key,Object data){
        code.data.put(key,data);
    }

}
